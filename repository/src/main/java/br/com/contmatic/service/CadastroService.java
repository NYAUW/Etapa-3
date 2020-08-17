package br.com.contmatic.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import br.com.contmatic.cliente.Cadastro;
import br.com.contmatic.repository.ICadastroRepository;

public class CadastroService implements ICadastroRepository{
	
	private String host = "localhost";

	private String database = "Empresa";

	private MongoCollection<Cadastro> collection;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CadastroService.class);

	private MongoDatabase getMongoDatabase() {
		MongoClient mongoClient = mongoClient();
		return mongoClient.getDatabase(database).withCodecRegistry(createCodecRegistry());
	}

	private MongoClient mongoClient() {
		return new MongoClient(host, MongoClientOptions.builder().codecRegistry(createCodecRegistry()).build());
	}
	
	private void closeConnection() {
		mongoClient().close();
	}

	private void connectCollection() {
		MongoDatabase mongoDatabase = getMongoDatabase().withCodecRegistry(createCodecRegistry());
		collection = mongoDatabase.getCollection("cadastro", Cadastro.class).withCodecRegistry(createCodecRegistry());
	}
	
	private static CodecRegistry createCodecRegistry() {
		return CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
	}
	
	@Override
	public void save(Cadastro cadastro) {
		try {
			connectCollection();
			CodecRegistry codecRegistry = createCodecRegistry();
			collection.withCodecRegistry(codecRegistry).insertOne(cadastro);
			closeConnection();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}


	@Override
	public void update(Cadastro cadastro) {
		try {
			connectCollection();
			CodecRegistry codecRegistry = createCodecRegistry();
			Bson findByCpf = Filters.eq("cpf", cadastro.getCpf());
			collection.withCodecRegistry(codecRegistry).replaceOne(findByCpf, cadastro);
			closeConnection();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Override
	public void deleteById(String id) throws IllegalAccessException {
		try {
			connectCollection();
			collection.deleteOne(Filters.eq("cpf", id));
			closeConnection();
		} catch (NullPointerException e) {
			LOGGER.error("Cliente não existe", e);
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Override
	public Cadastro findById(String id) {
		try {
		connectCollection();
		Bson findByCpf = Filters.eq("cpf", id);
		Cadastro cadastro = collection.find(findByCpf).first();
		closeConnection();
		return cadastro;
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public List<Cadastro> findAll() {
		connectCollection();
		MongoCursor<Cadastro> cursor = collection.find().iterator();
		List<Cadastro> cadastros = new ArrayList<>();
		try {
			while (cursor.hasNext()) {
				cadastros.add(cursor.next());
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			cursor.close();
		}
		closeConnection();
		return cadastros;
	}

}

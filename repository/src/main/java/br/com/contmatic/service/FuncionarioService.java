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

import br.com.contmatic.empresa.Funcionario;
import br.com.contmatic.repository.IFuncionarioService;

public class FuncionarioService implements IFuncionarioService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FuncionarioService.class);
	
	private static final String CODIGO = "codigo";
	
	private String host = "localhost";

	private String database = "Empresa";

	private MongoCollection<Funcionario> collection;

	public FuncionarioService() {
		super();
	}

	
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
		collection = mongoDatabase.getCollection("funcionario", Funcionario.class)
				.withCodecRegistry(createCodecRegistry());
	}

	private static CodecRegistry createCodecRegistry() {
		return CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
	}

	@Override
	public void save(Funcionario funcionario) {
		try {
			connectCollection();
			CodecRegistry codecRegistry = createCodecRegistry();
			collection.withCodecRegistry(codecRegistry).insertOne(funcionario);
			closeConnection();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Override
	public void update(Funcionario funcionario) {
		try {
			connectCollection();
			CodecRegistry codecRegistry = createCodecRegistry();
			Bson findByCpf = Filters.eq(CODIGO, funcionario.getCodigo());
			collection.withCodecRegistry(codecRegistry).replaceOne(findByCpf, funcionario);
			closeConnection();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Override
	public void deleteById(int id) throws IllegalAccessException {
		try {
			connectCollection();
			collection.deleteOne(Filters.eq(CODIGO, id));
			closeConnection();
		} catch (NullPointerException e) {
			LOGGER.error("Funcionario não existe", e);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Override
	public Funcionario findById(int id) {
		try {
			connectCollection();
			Bson findByCodigo = Filters.eq(CODIGO, id);
			Funcionario funcionario = collection.find(findByCodigo).first();
			closeConnection();
			return funcionario;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public List<Funcionario> findAll() {
		connectCollection();
		MongoCursor<Funcionario> cursor = collection.find().iterator();
		List<Funcionario> funcionarios = new ArrayList<>();
		try {
			while (cursor.hasNext()) {
				funcionarios.add(cursor.next());
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			cursor.close();
		}
		closeConnection();
		return funcionarios;
	}
}

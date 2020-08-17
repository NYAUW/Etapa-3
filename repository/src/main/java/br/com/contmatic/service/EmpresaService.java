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

import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.repository.IEmpresaRespository;

public class EmpresaService implements IEmpresaRespository {

	private String host = "localhost";

	private String database = "Empresa";

	private MongoCollection<Empresa> collection;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmpresaService.class);
	
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
		collection = mongoDatabase.getCollection("empresa", Empresa.class).withCodecRegistry(createCodecRegistry());
	}

	@Override
	public void save(Empresa empresa) {
		try {
		connectCollection();
		CodecRegistry codecRegistry = createCodecRegistry();
		collection.withCodecRegistry(codecRegistry).insertOne(empresa);
		closeConnection();
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	private static CodecRegistry createCodecRegistry() {
		return CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
	}

	@Override
	public void update(Empresa empresa) {
		try {
		connectCollection();
		CodecRegistry codecRegistry = createCodecRegistry();
		Bson findByCnpj = Filters.eq("cnpj", empresa.getCnpj());
		collection.withCodecRegistry(codecRegistry).replaceOne(findByCnpj, empresa);
		closeConnection();
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Override
	public void deleteById(String cnpj) {
		try {
		connectCollection();
		collection.deleteOne(Filters.eq("cnpj", cnpj));
		closeConnection();
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Override
	public Empresa findById(String cnpj) {
		try {
		connectCollection();
		Bson findByCnpj = Filters.eq("cnpj", cnpj);
		Empresa empresa = collection.find(findByCnpj).first();
		closeConnection();
		return empresa;
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public List<Empresa> findAll() {
		connectCollection();
		MongoCursor<Empresa> cursor = collection.find().iterator();
		List<Empresa> empresas = new ArrayList<>();
		try {
			while (cursor.hasNext()) {
				empresas.add(cursor.next());
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			cursor.close();
		}
		closeConnection();
		return empresas;
	}

}

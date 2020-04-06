package br.com.contmatic.connectionMongoDB;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.contmatic.cliente.Cadastro;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Funcionario;

public class MongoDbConnection {

	private static Logger LOGGER = LoggerFactory.getLogger("Mongo Connection");

	private static final String HOST = "localhost"; // endereço ip do banco de dados, no nosso caso local

	private static final String DB_NAME = "Empresa";

	private static MongoClient mongoClient;

	private static MongoDatabase database = MongoDbConnection.getMongoDatabase();

	public static MongoDatabase getMongoDatabase() {
		mongoClient = new MongoClient(HOST);
		return mongoClient.getDatabase(DB_NAME);
	}

	public static void SentToDatabaseEmpresa(Empresa empresa) {
        MongoCollection<Document> empresaCollection = database.getCollection("Empresa");
        empresaCollection.insertOne(Document.parse(empresa.toString()).append("_id", empresa.getCnpj()));
        LOGGER.info("Empresa -> Documento " + empresa.toString() + " Inserido com sucesso");
        }

	public static void SentoToDatabaseFuncionario(Funcionario funcionario) {
		MongoCollection<Document> funcionarioCollection = database.getCollection("Funcionario");
		funcionarioCollection.insertOne(Document.parse(funcionario.toString()).append("_id", funcionario.getCodigo()));
		LOGGER.info("Funcionario -> Documento nº" + funcionario.toString() + "Inserido com sucesso");
	}

	public static void SentToDatabaseCadastro(Cadastro cadastro) {
		MongoCollection<Document> cadastroCollection = database.getCollection("Cadastro");
		cadastroCollection.insertOne(Document.parse(cadastro.toString()).append("_id", cadastro.getCpf()));
		LOGGER.info("Cadastro -> Documento nº" + cadastro.toString() + "Inserido com sucesso");
	}
}

package br.com.contmatic.connectionMongoDB;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.contmatic.cliente.Cadastro;
import br.com.contmatic.easyRandomizer.EasyRandomClass;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Funcionario;

public class MongoDbConnection {
    
    private static final Logger LOGGER = LoggerFactory.getLogger("MongoDbConnection");
    
    private static EasyRandomClass randomObject = EasyRandomClass.InstanciaEasyRandomClass();
    
    private static Faker faker = new Faker();

    private static final String HOST = "localhost"; // endereço ip do banco de dados, no nosso caso local

    private static final String DB_NAME = "Empresa";

    private static MongoClient mongoClient;

    private static MongoDatabase database = MongoDbConnection.getMongoDatabase();

    private static MongoDatabase getMongoDatabase() {
        mongoClient = new MongoClient(HOST);
        return mongoClient.getDatabase(DB_NAME);
    }

    public static void SentToDatabaseEmpresa(Empresa empresa) {
        MongoCollection<Document> empresaCollection = database.getCollection("Empresa");
        empresaCollection.insertOne(Document.parse(empresa.toString()).append("_id", empresa.getCnpj()));
        LOGGER.info("EMPRESA ENVIA -> Documento nº " + empresa.toString() + " Inserido com sucesso");
    }

    public static void SentoToDatabaseFuncionario(Funcionario funcionario) {
        MongoCollection<Document> funcionarioCollection = database.getCollection("Funcionario");
        funcionarioCollection.insertOne(Document.parse(funcionario.toString()).append("_id", funcionario.getCodigo()));
        LOGGER.info("FUNCIONARIO ENVIA-> Documento nº" + funcionario.toString() + "Inserido com sucesso");
    }

    public static void SentToDatabaseCadastro(Cadastro cadastro) {
        MongoCollection<Document> cadastroCollection = database.getCollection("Cadastro");
        cadastroCollection.insertOne(Document.parse(cadastro.toString()).append("_id", cadastro.getCpf()));
        LOGGER.info("CADASTRO ENVIA -> Documento nº" + cadastro.toString() + "Inserido com sucesso");
    }

    public static void DeleteDocumentInEmpresa(Empresa empresa) {
        MongoCollection<Document> empresaCollection = database.getCollection("Empresa");
        String cnpj = empresa.getCnpj();
        empresaCollection.insertOne(Document.parse(empresa.toString()).append("_id", cnpj));
        LOGGER.info("Documento {} inserido com sucesso", empresaCollection.countDocuments());
        empresaCollection.deleteOne(new Document("_id", cnpj));
        LOGGER.info("EMPRESA DELETE -> Documento {} deletado com sucesso", empresaCollection.countDocuments());
    }
    
    public static void DeleteDocumentInCadastro(Cadastro cadastro) {
        MongoCollection<Document> cadastroCollection = database.getCollection("Cadastro");
        String cpf = cadastro.getCpf();
        cadastroCollection.insertOne(Document.parse(cadastro.toString()).append("_id", cpf));
        LOGGER.info("Documento {} inserido com sucesso", cadastroCollection.countDocuments());
        cadastroCollection.deleteOne(new Document("_id", cpf));
        LOGGER.info("CADASTRO DELETE -> Documento {} deletado com sucesso", cadastroCollection.countDocuments());
    }
    
    public static void DeleteDocumentInFuncionario(Funcionario funcionario) {
        MongoCollection<Document> funcionarioCollection = database.getCollection("Cadastro");
        int cod = funcionario.getCodigo();
        funcionarioCollection.insertOne(Document.parse(funcionario.toString()).append("_id", cod));
        LOGGER.info("Documento {} inserido com sucesso", funcionarioCollection.countDocuments());
        funcionarioCollection.deleteOne(new Document("_id", cod));
        LOGGER.info("FUNCIONARIO DELETE Documento {} deletado com sucesso", funcionarioCollection.countDocuments());
    }
    
    public static void UpdateDocumentInEmpresa(Empresa empresa) {
        String oldName = empresa.getNome();
        String newName = faker.leagueOfLegends().champion();
        MongoCollection<Document> empresaCollection = database.getCollection("Empresa");
        empresaCollection.insertOne(Document.parse(empresa.toString()).append("_id", empresa.getCnpj()));
        Bson filter = new Document("cnpj", empresa.getCnpj());
        Bson update = new Document("nome", newName);
        Bson updateOperationDocument = new Document("$set", update);
        empresaCollection.updateOne(filter, updateOperationDocument);
        LOGGER.info("EMPRESA UPDATE: Entradas atualizadas do documento {} de {} para {} com sucesso",empresaCollection.countDocuments(), oldName, newName);
    }
    
    public static void UpdateDocumentInCadastro(Cadastro cadastro) {
        String oldName = cadastro.getNome();
        String newName = faker.name().fullName();
        MongoCollection<Document> cadastroCollection = database.getCollection("Cadastro");
        cadastroCollection.insertOne(Document.parse(cadastro.toString()).append("_id", cadastro.getCpf()));
        Bson filter = new Document("nome", cadastro.getNome());
        Bson update = new Document("nome", newName);
        Bson updateOperationDocument = new Document("$set", update);
        cadastroCollection.updateOne(filter, updateOperationDocument);
        LOGGER.info("CADASTRO UPDATE: Entradas atualizadas do documento {} de {} para {} com sucesso",cadastroCollection.countDocuments(), oldName, newName);
    }
    
    public static void UpdateDocumentInFuncionario(Funcionario funcionario) {
        String oldName = funcionario.getNome();
        String newName = faker.name().fullName();
        MongoCollection<Document> funcionarioCollection = database.getCollection("Funcionario");
        funcionarioCollection.insertOne(Document.parse(funcionario.toString()).append("_id", funcionario.getCodigo()));
        Bson filter = new Document("nome", funcionario.getNome());
        Bson update = new Document("nome", newName);
        Bson updateOperationDocument = new Document("$set", update);
        funcionarioCollection.updateOne(filter, updateOperationDocument);
        LOGGER.info("FUNCIONARIO UPDATE: Entradas atualizadas do documento {} de {} para {} com sucesso",funcionarioCollection.countDocuments(), oldName, newName);
    }
    
    public static void FindDocumentInEmpresa(Empresa empresa) {
        MongoCollection<Document> empresaCollection = database.getCollection("Empresa");
        empresaCollection.insertOne(Document.parse(empresa.toString()).append("_id", empresa.getCnpj()));
        Bson filter = new Document("_id", empresa.getCnpj());
        FindIterable<Document> search = empresaCollection.find(filter);
        LOGGER.info("PROCURA EMPRESA: Documento {} encontrado com sucesso.", search.first().toJson());
    }
    
    public static void FindDocumentInCadastro(Cadastro cadastro) {
        MongoCollection<Document> empresaCollection = database.getCollection("Cadastro");
        empresaCollection.insertOne(Document.parse(cadastro.toString()).append("_id", cadastro.getCpf()));
        Bson filter = new Document("_id", cadastro.getCpf());
        FindIterable<Document> search = empresaCollection.find(filter);
        LOGGER.info("PROCURA CADASTRO: Documento {} encontrado com sucesso.", search.first().toJson());
    }
    
    public static void FindDocumentInFuncionario(Funcionario funcionario) {
        MongoCollection<Document> empresaCollection = database.getCollection("Funcionario");
        empresaCollection.insertOne(Document.parse(funcionario.toString()).append("_id", funcionario.getCodigo()));
        Bson filter = new Document("_id", funcionario.getCodigo());
        FindIterable<Document> search = empresaCollection.find(filter);
        LOGGER.info("PROCURA FUNCIONARIO: Documento {} encontrado com sucesso.", search.first().toJson());
    }
}

package br.com.contmatic.mongo.repository;

import java.io.IOException;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import br.com.contmatic.cliente.Cadastro;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Funcionario;

public class MongoRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger("MongoDbConnection");

    private static Faker faker = new Faker();

    private static final String HOST = "localhost";
    
    private static final String EMPRESA = "Empresa";
    
    private static final String FUNCIONARIO = "Funcionario";
    
    private static final String CADASTRO = "Cadastro";

    private static MongoClient mongoClient;

    private static MongoDatabase database = MongoRepository.getMongoDatabase();

    protected static MongoDatabase getMongoDatabase() {
            try {
                StartServer.start("mongod --dbpath C:\\data");
            } catch (IOException e) {
                if (database == null) {
                    mongoClient.getDatabase(EMPRESA);
                    database.createCollection(EMPRESA);
                    database.createCollection(FUNCIONARIO);
                    database.createCollection(CADASTRO);
                }
                LOGGER.info("Erro ao iniciar o servidor: {}", e.getMessage());
            }
        mongoClient = new MongoClient(HOST);
        return mongoClient.getDatabase(EMPRESA);
    }

    public static void sentToDatabaseEmpresa(Empresa empresa) {
        MongoCollection<Document> empresaCollection = database.getCollection(EMPRESA);
        empresaCollection.insertOne(Document.parse(empresa.toString()).append("_id", empresa.getCnpj()));
        LOGGER.info("EMPRESA ENVIA -> Documento nº {} Inserido com sucesso", empresa);
    }

    public static void sentoToDatabaseFuncionario(Funcionario funcionario) {
        MongoCollection<Document> funcionarioCollection = database.getCollection(FUNCIONARIO);
        funcionarioCollection.insertOne(Document.parse(funcionario.toString()).append("_id", funcionario.getCodigo()));
        LOGGER.info("FUNCIONARIO ENVIA-> Documento nº {} Inserido com sucesso", funcionario);
    }

    public static void sentToDatabaseCadastro(Cadastro cadastro) {
        MongoCollection<Document> cadastroCollection = database.getCollection(CADASTRO);
        cadastroCollection.insertOne(Document.parse(cadastro.toString()).append("_id", cadastro.getCpf()));
        LOGGER.info("CADASTRO ENVIA -> Documento nº {} Inserido com sucesso", cadastro);
    }

    public static void deleteDocumentInEmpresa(Empresa empresa) {
        MongoCollection<Document> empresaCollection = database.getCollection(EMPRESA);
        String cnpj = empresa.getCnpj();
        empresaCollection.insertOne(Document.parse(empresa.toString()).append("_id", cnpj));
        LOGGER.info("Documento {} inserido com sucesso.", empresaCollection.countDocuments());
        empresaCollection.deleteOne(new Document("_id", cnpj));
        LOGGER.info("EMPRESA DELETE -> Documento {} deletado com sucesso", empresaCollection.countDocuments());
    }

    public static void deleteDocumentInCadastro(Cadastro cadastro) {
        MongoCollection<Document> cadastroCollection = database.getCollection(CADASTRO);
        String cpf = cadastro.getCpf();
        cadastroCollection.insertOne(Document.parse(cadastro.toString()).append("_id", cpf));
        LOGGER.info("Documento {} inserido com sucesso", cadastroCollection.countDocuments());
        cadastroCollection.deleteOne(new Document("_id", cpf));
        LOGGER.info("CADASTRO DELETE -> Documento {} deletado com sucesso", cadastroCollection.countDocuments());
    }

    public static void deleteDocumentInFuncionario(Funcionario funcionario) {
        MongoCollection<Document> funcionarioCollection = database.getCollection(CADASTRO);
        int cod = funcionario.getCodigo();
        funcionarioCollection.insertOne(Document.parse(funcionario.toString()).append("_id", cod));
        LOGGER.info("Documento {} inserido com sucesso", funcionarioCollection.countDocuments());
        funcionarioCollection.deleteOne(new Document("_id", cod));
        LOGGER.info("FUNCIONARIO DELETE Documento {} deletado com sucesso", funcionarioCollection.countDocuments());
    }

    public static void updateDocumentInEmpresa(Empresa empresa) {
        String oldName = empresa.getNome();
        String newName = faker.leagueOfLegends().champion();
        MongoCollection<Document> empresaCollection = database.getCollection(EMPRESA);
        empresaCollection.insertOne(Document.parse(empresa.toString()).append("_id", empresa.getCnpj()));
        Bson filter = new Document("cnpj", empresa.getCnpj());
        Bson update = new Document("nome", newName);
        Bson updateOperationDocument = new Document("$set", update);
        empresaCollection.updateOne(filter, updateOperationDocument);
        LOGGER.info("EMPRESA UPDATE: Entradas atualizadas do documento {} de {} para {} com sucesso", empresaCollection.countDocuments(), oldName, newName);
    }

    public static void updateDocumentInCadastro(Cadastro cadastro) {
        String oldName = cadastro.getNome();
        String newName = faker.name().fullName();
        MongoCollection<Document> cadastroCollection = database.getCollection(CADASTRO);
        cadastroCollection.insertOne(Document.parse(cadastro.toString()).append("_id", cadastro.getCpf()));
        Bson filter = new Document("nome", cadastro.getNome());
        Bson update = new Document("nome", newName);
        Bson updateOperationDocument = new Document("$set", update);
        cadastroCollection.updateOne(filter, updateOperationDocument);
        LOGGER.info("CADASTRO UPDATE: Entradas atualizadas do documento {} de {} para {} com sucesso", cadastroCollection.countDocuments(), oldName, newName);
    }

    public static void updateDocumentInFuncionario(Funcionario funcionario) {
        String oldName = funcionario.getNome();
        String newName = faker.name().fullName();
        MongoCollection<Document> funcionarioCollection = database.getCollection(FUNCIONARIO);
        funcionarioCollection.insertOne(Document.parse(funcionario.toString()).append("_id", funcionario.getCodigo()));
        Bson filter = new Document("nome", funcionario.getNome());
        Bson update = new Document("nome", newName);
        Bson updateOperationDocument = new Document("$set", update);
        funcionarioCollection.updateOne(filter, updateOperationDocument);
        LOGGER.info("FUNCIONARIO UPDATE: Entradas atualizadas do documento {} de {} para {} com sucesso", funcionarioCollection.countDocuments(), oldName, newName);
    }

    public static void returnDocumentsInEmpresaCollection() {
        MongoCollection<Document> empresaCollection = database.getCollection(EMPRESA);
        MongoCursor<Document> cursor = empresaCollection.find().iterator();
        while (cursor.hasNext()) {
            LOGGER.info("DOCUMENTOS EMPRESA: Documento {} encontrado com sucesso", cursor.next());
        }
    }

    public static void returnDocumentsInCadastroCollection() {
        MongoCollection<Document> cadastroCollection = database.getCollection(EMPRESA);
        MongoCursor<Document> cursor = cadastroCollection.find().iterator();
        while (cursor.hasNext()) {
            LOGGER.info("DOCUMENTOS CADASTRO: Documento {} encontrado com sucesso", cursor.next());
        }
    }

    public static void returnDocumentsInFuncionarioCollection() {
        MongoCollection<Document> funcionarioCollection = database.getCollection(EMPRESA);
        MongoCursor<Document> cursor = funcionarioCollection.find().iterator();
        while (cursor.hasNext()) {
            LOGGER.info("DOCUMENTOS CADASTRO: Documento {} encontrado com sucesso", cursor.next());
        }
    }
}

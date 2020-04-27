package br.com.contmatic.mongo.repository;

import java.io.IOException;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoRepositoryReturn {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoRepositoryReturn.class);

    private static final String HOST = "localhost";
    
    private static final String EMPRESA = "Empresa";
    
    private static final String FUNCIONARIO = "Funcionario";
    
    private static final String CADASTRO = "Cadastro";

    private static MongoClient mongoClient;

    private static MongoDatabase database = MongoRepositoryReturn.getMongoDatabaseServer();

    protected static MongoDatabase getMongoDatabaseServer() {
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

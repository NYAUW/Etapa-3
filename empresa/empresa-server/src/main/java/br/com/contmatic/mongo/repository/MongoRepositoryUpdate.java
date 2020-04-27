package br.com.contmatic.mongo.repository;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.contmatic.cliente.Cadastro;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Funcionario;

public class MongoRepositoryUpdate {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoRepositoryUpdate.class);

    private static Faker faker = new Faker();

    private static final String EMPRESA = "Empresa";

    private static final String CADASTRO = "Cadastro";

    private static final String FUNCIONARIO = "Funcionario";

    private static MongoDatabase database = MongoRepositoryReturn.getMongoDatabaseServer();

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

}

package br.com.contmatic.mongo.repository;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.contmatic.cliente.Cadastro;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Funcionario;

public class MongoRepositoryDelete {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoRepositoryDelete.class);

    private static final String EMPRESA = "Empresa";

    private static final String CADASTRO = "Cadastro";

    private static MongoDatabase database = MongoRepositoryReturn.getMongoDatabaseServer();

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
}

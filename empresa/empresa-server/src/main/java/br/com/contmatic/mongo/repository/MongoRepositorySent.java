package br.com.contmatic.mongo.repository;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.contmatic.cliente.Cadastro;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Funcionario;

public class MongoRepositorySent {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoRepositorySent.class);

    private static final String EMPRESA = "Empresa";

    private static final String FUNCIONARIO = "Funcionario";

    private static final String CADASTRO = "Cadastro";

    private static MongoDatabase database = MongoRepositoryReturn.getMongoDatabaseServer();

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
}

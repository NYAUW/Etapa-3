package br.com.contmatic.mongo.repository;

import java.math.BigDecimal;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.contmatic.cliente.Cadastro;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Funcionario;
import br.com.contmatic.object.easy.EasyRandomClass;

public class MongoRepositoryFind {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoRepositoryFind.class);

    private static EasyRandomClass randomObject = EasyRandomClass.instanciaEasyRandomClass();

    private static final String EMPRESA = "Empresa";

    private static final String CADASTRO = "Cadastro";

    private static final String FUNCIONARIO = "Funcionario";

    private static MongoDatabase database = MongoRepositoryReturn.getMongoDatabaseServer();

    public static Empresa findDocumentInEmpresa() {
        MongoCollection<Document> empresaCollection = database.getCollection(EMPRESA);
        Empresa empresa = EasyRandomClass.instanciaEasyRandomClass().empresaRandomizer();
        empresaCollection.insertOne(Document.parse(empresa.toString()).append("_id", empresa.getCnpj()));
        Bson filter = new Document("_id", empresa.getCnpj());
        FindIterable<Document> search = empresaCollection.find(filter);
        empresa.setCnpj(search.first().getString("cnpj"));
        empresa.setNome(search.first().getString("nome"));
        empresa.setProprietarios(search.first().getString("proprietarios"));
        empresa.setRazaoSocial(search.first().getString("razaoSocial"));
        LOGGER.info("EMPRESA ENCONTRADA: O documento {} foi encontrado com sucesso", empresa);
        return empresa;
    }

    public static Cadastro findDocumentInCadastro() {
        Cadastro cadastro = randomObject.cadastroRandomizer();
        MongoCollection<Document> cadastroCollection = database.getCollection(CADASTRO);
        cadastroCollection.insertOne(Document.parse(cadastro.toString()).append("_id", cadastro.getCpf()));
        Bson filter = new Document("_id", cadastro.getCpf());
        FindIterable<Document> search = cadastroCollection.find(filter);
        cadastro.setCpf(search.first().getString("cpf"));
        cadastro.setEmail(search.first().getString("email"));
        cadastro.setNome(search.first().getString("nome"));
        cadastro.setRg(search.first().getString("rg"));
        cadastro.setSenha(search.first().getString("senha"));
        LOGGER.info("PROCURA CADASTRO: Documento {} encontrado com sucesso.", search.first());
        return cadastro;
    }

    public static Funcionario findDocumentInFuncionario() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        MongoCollection<Document> funcionarioCollection = database.getCollection(FUNCIONARIO);
        funcionarioCollection.insertOne(Document.parse(funcionario.toString()).append("_id", funcionario.getCodigo()));
        Bson filter = new Document("_id", funcionario.getCodigo());
        FindIterable<Document> search = funcionarioCollection.find(filter);
        funcionario.setNome(search.first().getString("nome"));
        funcionario.setCargo(search.first().getString("cargo"));
        funcionario.setCodigo(search.first().getInteger("codigo"));
        funcionario.setSalario(new BigDecimal(search.first().getDouble("salario")));
        LOGGER.info("PROCURA FUNCIONARIO: Documento {} encontrado com sucesso.", search.first());
        return funcionario;
    }
}

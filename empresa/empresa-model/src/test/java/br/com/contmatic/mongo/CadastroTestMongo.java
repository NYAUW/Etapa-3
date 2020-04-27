package br.com.contmatic.mongo;

import org.junit.AfterClass;

import br.com.contmatic.cliente.Cadastro;
import br.com.contmatic.mongo.server.MongoDbConnection;
import br.com.contmatic.object.easy.EasyRandomClass;

public class CadastroTestMongo {

    private static EasyRandomClass randomObject = EasyRandomClass.instanciaEasyRandomClass();

    @AfterClass
    public static void envia_para_banco_de_dados() {
        Cadastro cadastro = randomObject.cadastroRandomizer();
        MongoDbConnection.sentToDatabaseCadastro(cadastro);
    }

    @AfterClass
    public static void deve_enviar_e_deletar_do_banco_de_dados() {
        Cadastro cadastro = randomObject.cadastroRandomizer();
        MongoDbConnection.deleteDocumentInCadastro(cadastro);
    }

    @AfterClass
    public static void deve_enviar_e_atualizar_cadastro_banco_de_dados() {
        Cadastro cadastro = randomObject.cadastroRandomizer();
        MongoDbConnection.updateDocumentInCadastro(cadastro);
    }

    @AfterClass
    public static void deve_encontrar_documento_aleatorio_cadastro() {
        Cadastro cadastro = randomObject.cadastroRandomizer();
        MongoDbConnection.deleteDocumentInCadastro(cadastro);
        ;
    }

    @AfterClass
    public static void deve_retornar_todos_documentos_cadastro_em_json() {
        MongoDbConnection.returnDocumentsInCadastroCollection();
    }
}

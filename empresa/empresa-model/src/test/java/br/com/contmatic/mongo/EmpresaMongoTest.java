package br.com.contmatic.mongo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.mongo.repository.MongoRepository;
import br.com.contmatic.mongo.repository.MongoRepositoryFind;
import br.com.contmatic.object.easy.EasyRandomClass;

public class EmpresaMongoTest {

    private static EasyRandomClass randomObject = EasyRandomClass.instanciaEasyRandomClass();

    @Test
    public void deve_alterar_nome_empresa_mongodb_para_null() {
        Empresa empresaConsulta = MongoRepositoryFind.findDocumentInEmpresa();
        empresaConsulta.setCnpj(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresaConsulta));
    }

    @Test
    public void deve_verificar_nome_inserido_no_banco_de_dados_mongodb() {
        Empresa empresaConsulta = MongoRepositoryFind.findDocumentInEmpresa();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresaConsulta.getNome()));
    }

    @Test
    public void deve_verificar_cnpj_invalido_numeros_mongodb() {
        Empresa empresaConsulta = MongoRepositoryFind.findDocumentInEmpresa();
        empresaConsulta.setCnpj("458743");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresaConsulta));
    }

    @Test
    public void deve_verificar_cnpj_invalido_letras_mongodb() {
        Empresa empresaConsulta = MongoRepositoryFind.findDocumentInEmpresa();
        empresaConsulta.setCnpj("fdhjg");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresaConsulta));
    }

    @Test
    public void deve_verificar_cnpj_invalido_alfanumerico_mongodb() {
        Empresa empresaConsulta = MongoRepositoryFind.findDocumentInEmpresa();
        empresaConsulta.setCnpj("45874fdhjg3");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresaConsulta));
    }

    @Test
    public void deve_verificar_nome_invalido_null() {
        Empresa empresaConsulta = MongoRepositoryFind.findDocumentInEmpresa();
        empresaConsulta.setNome(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresaConsulta));
    }

    @Test
    public void deve_verificar_cnpj_invalido_letras_e_numeros_mongodb() {
        Empresa empresaConsulta = MongoRepositoryFind.findDocumentInEmpresa();
        empresaConsulta.setCnpj("45874fdhjg3");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresaConsulta));
    }

    @Test
    public void deve_verificar_nome_invalido_numerico_mongodb() {
        Empresa empresaConsulta = MongoRepositoryFind.findDocumentInEmpresa();
        empresaConsulta.setNome("98549");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresaConsulta));
    }

    @Test
    public void deve_verificar_nome_invalido_blank_mongodb() {
        Empresa empresaConsulta = MongoRepositoryFind.findDocumentInEmpresa();
        empresaConsulta.setNome("");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresaConsulta));
    }

    @AfterClass
    public static void deve_enviar_para_base_de_dados() {
        Empresa empresa = randomObject.empresaRandomizer();
        MongoRepository.sentToDatabaseEmpresa(empresa);
    }

    @AfterClass
    public static void deve_enviar_e_deletar_documento_da_collection() {
        Empresa empresa = randomObject.empresaRandomizer();
        MongoRepository.deleteDocumentInEmpresa(empresa);
    }

    @AfterClass
    public static void deve_atualizar_nome_empresa_banco_de_dados() {
        Empresa empresa = randomObject.empresaRandomizer();
        MongoRepository.updateDocumentInEmpresa(empresa);
    }

    @AfterClass
    public static void deve_retornar_todos_documentos_empresa() {
        MongoRepository.returnDocumentsInEmpresaCollection();
    }
}

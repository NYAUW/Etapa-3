package br.com.contmatic.mongo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.contmatic.cliente.Cadastro;
import br.com.contmatic.mongo.repository.MongoRepositoryReturn;
import br.com.contmatic.mongo.repository.MongoRepositorySent;
import br.com.contmatic.mongo.repository.MongoRepositoryDelete;
import br.com.contmatic.mongo.repository.MongoRepositoryFind;
import br.com.contmatic.mongo.repository.MongoRepositoryUpdate;
import br.com.contmatic.object.easy.EasyRandomClass;

public class CadastroMongoTest {

    private static EasyRandomClass randomObject = EasyRandomClass.instanciaEasyRandomClass();

    @Test
    public void deve_verificar_nome_cadastro() {
        Cadastro cadastro = MongoRepositoryFind.findDocumentInCadastro();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastro.getNome()));
    }
    
    @Test
    public void deve_verificar_nome_cadastro_null() {
        Cadastro cadastro = MongoRepositoryFind.findDocumentInCadastro();
        cadastro.setNome(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastro));
    }
    
    @Test
    public void deve_verificar_nome_cadastro_numerco() {
        Cadastro cadastro = MongoRepositoryFind.findDocumentInCadastro();
        cadastro.setNome("945905346504964");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastro));
    }
    
    @Test
    public void deve_verificar_nome_cadastro_alfanumerico() {
        Cadastro cadastro = MongoRepositoryFind.findDocumentInCadastro();
        cadastro.setNome("8756yu4un5yt754yht g45879 yt4");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastro));
    }
    
    @Test
    public void deve_verificar_nome_cadastro_blank() {
        Cadastro cadastro = MongoRepositoryFind.findDocumentInCadastro();
        cadastro.setNome(" ");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastro));
    }
    
    @Test
    public void deve_verificar_nome_cadastro_especial() {
        Cadastro cadastro = MongoRepositoryFind.findDocumentInCadastro();
        cadastro.setNome("!@#$");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastro));
    }
    
    @Test
    public void deve_verificar_cpf() {
        Cadastro cadastro = MongoRepositoryFind.findDocumentInCadastro();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastro.getCpf()));
    }
    
    @Test
    public void deve_verificar_cpf_null() {
        Cadastro cadastro = MongoRepositoryFind.findDocumentInCadastro();
        cadastro.setCpf(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastro));
    }
    
    @Test
    public void deve_verificar_cpf_invalido() {
        Cadastro cadastro = MongoRepositoryFind.findDocumentInCadastro();
        cadastro.setCpf("111.222.333.44");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastro));
    }
    
    @Test
    public void deve_verificar_cpf_alfa() {
        Cadastro cadastro = MongoRepositoryFind.findDocumentInCadastro();
        cadastro.setCpf("jsfhdihjshfgduisdfh");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastro));
    }
    
    @Test
    public void deve_verificar_cpf_alfanumerico() {
        Cadastro cadastro = MongoRepositoryFind.findDocumentInCadastro();
        cadastro.setCpf("jsfhdihjs495804538975496h");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastro));
    }
    
    @Test
    public void deve_verificar_cpf_blank() {
        Cadastro cadastro = MongoRepositoryFind.findDocumentInCadastro();
        cadastro.setCpf(" ");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastro));
    }
    
    @Test
    public void deve_verificar_email() {
        Cadastro cadastro = MongoRepositoryFind.findDocumentInCadastro();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastro.getEmail()));
    }
    
    @Test
    public void deve_verificar_email_nulo() {
        Cadastro cadastro = MongoRepositoryFind.findDocumentInCadastro();
        cadastro.setEmail(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastro));
    }
    
    @Test
    public void deve_verificar_email_sem_dominio() {
        Cadastro cadastro = MongoRepositoryFind.findDocumentInCadastro();
        cadastro.setEmail("teste.com");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastro));
    }
    
    @Test
    public void deve_verificar_email_sem_com_br() {
        Cadastro cadastro = MongoRepositoryFind.findDocumentInCadastro();
        cadastro.setEmail("teste@gmail");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastro));
    }

    @Test
    public void deve_verificar_email_apenas_com_domionio_com_br() {
        Cadastro cadastro = MongoRepositoryFind.findDocumentInCadastro();
        cadastro.setEmail("@gmail.com.br");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastro));
    }
    
    @AfterClass
    public static void envia_para_banco_de_dados() {
        Cadastro cadastro = randomObject.cadastroRandomizer();
        MongoRepositorySent.sentToDatabaseCadastro(cadastro);
    }

    @AfterClass
    public static void deve_enviar_e_deletar_do_banco_de_dados() {
        Cadastro cadastro = randomObject.cadastroRandomizer();
        MongoRepositoryDelete.deleteDocumentInCadastro(cadastro);
    }

    @AfterClass
    public static void deve_enviar_e_atualizar_cadastro_banco_de_dados() {
        Cadastro cadastro = randomObject.cadastroRandomizer();
        MongoRepositoryUpdate.updateDocumentInCadastro(cadastro);
    }

    @AfterClass
    public static void deve_encontrar_documento_aleatorio_cadastro() {
        Cadastro cadastro = randomObject.cadastroRandomizer();
        MongoRepositoryDelete.deleteDocumentInCadastro(cadastro);
        ;
    }

    @AfterClass
    public static void deve_retornar_todos_documentos_cadastro_em_json() {
        MongoRepositoryReturn.returnDocumentsInCadastroCollection();
    }
}

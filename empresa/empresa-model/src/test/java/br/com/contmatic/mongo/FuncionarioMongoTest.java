package br.com.contmatic.mongo;

import static java.math.BigDecimal.ZERO;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.contmatic.empresa.Funcionario;
import br.com.contmatic.mongo.repository.MongoRepository;
import br.com.contmatic.mongo.repository.MongoRepositoryFind;
import br.com.contmatic.object.easy.EasyRandomClass;

public class FuncionarioMongoTest {

    private static EasyRandomClass randomObject = EasyRandomClass.instanciaEasyRandomClass();

    @Test
    public void deve_verificar_nome() {
        Funcionario funcionario = MongoRepositoryFind.findDocumentInFuncionario();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario.getNome()));
    }

    @Test
    public void deve_verificar_nome_null() {
        Funcionario funcionario = MongoRepositoryFind.findDocumentInFuncionario();
        funcionario.setNome(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_nome_numerico() {
        Funcionario funcionario = MongoRepositoryFind.findDocumentInFuncionario();
        funcionario.setNome("92348598546584096");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_nome_especial() {
        Funcionario funcionario = MongoRepositoryFind.findDocumentInFuncionario();
        funcionario.setNome("!@#$%¨&*(");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_nome_alfanumerico() {
        Funcionario funcionario = MongoRepositoryFind.findDocumentInFuncionario();
        funcionario.setNome("fdogjd gjfd9234859feoidhjg8546584096");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_codigo() {
        Funcionario funcionario = MongoRepositoryFind.findDocumentInFuncionario();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario.getCodigo()));
    }

    @Test
    public void deve_verificar_codigo_invalido_zero() {
        Funcionario funcionario = MongoRepositoryFind.findDocumentInFuncionario();
        funcionario.setCodigo(0);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_codigo_invalido_menor_zero() {
        Funcionario funcionario = MongoRepositoryFind.findDocumentInFuncionario();
        funcionario.setCodigo(-10);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_salario() {
        Funcionario funcionario = MongoRepositoryFind.findDocumentInFuncionario();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario.getSalario()));
    }

    @Test
    public void deve_verificar_salario_zero() {
        Funcionario funcionario = MongoRepositoryFind.findDocumentInFuncionario();
        funcionario.setSalario(ZERO);
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario.getSalario()));
    }

    @Test
    public void deve_verificar_salario_nulo() {
        Funcionario funcionario = MongoRepositoryFind.findDocumentInFuncionario();
        funcionario.setSalario(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_cargo() {
        Funcionario funcionario = MongoRepositoryFind.findDocumentInFuncionario();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario.getCargo()));
    }

    @Test
    public void deve_verificar_cargo_nulo() {
        Funcionario funcionario = MongoRepositoryFind.findDocumentInFuncionario();
        funcionario.setCargo(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_cargo_blank() {
        Funcionario funcionario = MongoRepositoryFind.findDocumentInFuncionario();
        funcionario.setCargo("");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_cargo_numerico() {
        Funcionario funcionario = MongoRepositoryFind.findDocumentInFuncionario();
        funcionario.setCargo("98450968095648");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_cargo_alfanumerico() {
        Funcionario funcionario = MongoRepositoryFind.findDocumentInFuncionario();
        funcionario.setCargo("9845096809ryrtyrt5648");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @AfterClass
    public static void envia_para_banco_de_dados() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        MongoRepository.sentoToDatabaseFuncionario(funcionario);
    }

    @AfterClass
    public static void deve_enviar_e_deletar_banco_de_dados() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        MongoRepository.deleteDocumentInFuncionario(funcionario);
    }

    @AfterClass
    public static void deve_enviar_e_atualizar_banco_de_dados() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        MongoRepository.updateDocumentInFuncionario(funcionario);
    }

    @AfterClass
    public static void deve_encontrar_documento_aleatorio_funcionario() {
        MongoRepositoryFind.findDocumentInFuncionario();
    }

    @AfterClass
    public static void deve_retornar_todos_documentos_cadastro_em_json() {
        MongoRepository.returnDocumentsInFuncionarioCollection();
    }
}

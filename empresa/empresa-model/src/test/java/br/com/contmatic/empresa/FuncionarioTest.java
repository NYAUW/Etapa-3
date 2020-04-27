package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.AfterClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.contmatic.mongo.server.MongoDbConnection;
import br.com.contmatic.object.easy.EasyRandomClass;

/**
 * The Class FuncionarioTest.
 */
public class FuncionarioTest {

    private static EasyRandomClass randomObject = EasyRandomClass.instanciaEasyRandomClass();

    /**
     * Verifica classes iguais hashcode.
     */
    @Test
    public void verifica_classes_iguais_hashcode() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        assertEquals(funcionario.hashCode(), funcionario.hashCode());
    }

    @Test
    public void deve_verificar_nome_to_string() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        assertTrue(funcionario.toString().contains("nome"));
    }

    @Test
    public void deve_verificar_cargo_to_string() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        assertTrue(funcionario.toString().contains("cargo"));
    }

    @Test
    public void deve_verificar_codigo_to_string() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        assertTrue(funcionario.toString().contains("codigo"));
    }

    @Test
    public void deve_verificar_salario_to_string() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        assertTrue(funcionario.toString().contains("salario"));
    }

    @Test
    public void deve_comparar_dados_do_construtor() {
        Funcionario funcionario = new Funcionario("Lucas Alves Ribeiro", "Auxiliar", 234, new BigDecimal("3000.00"));
        assertEquals(funcionario, funcionario);
    }

    @Test
    public void deve_verificar_se_a_classe_contem_dados_nulos() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        assertFalse(funcionario.equals(null));
    }

    @Test
    public void deve_comparar_objetos_da_classe() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        assertFalse(funcionario.equals(new Object()));
    }

    @Test
    public void deve_verificar_classes_iguais() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        assertEquals(funcionario, funcionario);
    }

    @Test
    public void deve_verificar_classes_iguais_com_equals() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        Funcionario funcionario2 = randomObject.funcionarioRandomizer();
        assertNotEquals(funcionario, funcionario2);
    }

    @Test
    public void deve_verificar_objeto_das_classes() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        Funcionario funcionario2 = randomObject.funcionarioRandomizer();
        assertNotEquals(funcionario, funcionario2);
    }

    @Test
    public void deve_conferir_saida_nome_to_string() {
        Funcionario funcionario = new Funcionario("Lucas Alves Ribeiro", "Auxiliar", 234, new BigDecimal("3000.00"));
        assertEquals("Lucas Alves Ribeiro", funcionario.getNome());
    }

    @Test
    public void deve_conferir_saida_cargo_to_string() {
        Funcionario funcionario = new Funcionario("Lucas Alves Ribeiro", "Auxiliar", 234, new BigDecimal("3000.00"));
        assertEquals("Auxiliar", funcionario.getCargo());
    }

    @Test
    public void deve_conferir_saida_codigo_to_string() {
        Funcionario funcionario = new Funcionario("Lucas Alves Ribeiro", "Auxiliar", 234, new BigDecimal("3000.00"));
        assertEquals(234, funcionario.getCodigo());
    }

    @Test
    public void deve_conferir_saida_salario_to_string() {
        Funcionario funcionario = new Funcionario("Lucas Alves Ribeiro", "Auxiliar", 234, new BigDecimal("3000.00"));
        assertEquals(new BigDecimal("3000.00"), funcionario.getSalario());
    }

    /**
     * Deve verificar nome simulando entrada de dados do usuario.
     */
    @Test
    public void deve_verificar_nome_simulando_entrada_de_dados_do_usuario() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.setNome("Marcelao Alves");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario.getNome()));
    }

    @Test
    public void deve_verificar_nome_incompleto() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.setNome("M");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_nome_com_entrada_numerica() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.setNome("Marcel4o Alves");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_nome_com_entrada_blank() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.setNome("");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_nome_com_entrada_nula() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.setNome(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_nome_com_entrada_especial() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.setNome("$#@&*%$#@");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_nome_com_entrada_somente_numeros() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.setNome("39407894065");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar nome gerado com objetos fake.
     */
    @Test
    public void deve_verificar_nome_gerado_com_objetos_fake() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario.getNome()));
    }

    /**
     * Deve verificar cargo gerados com objetos fake.
     */
    @Test
    public void deve_verificar_cargo_gerados_com_objetos_fake() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario.getCargo()));
    }

    /**
     * Deve verificar cargo simulando entrada de dados do usuario.
     */
    @Test
    public void deve_verificar_cargo_tecnico_simulando_entrada_de_dados_do_usuario() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.setCargo("Tecnico");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario.getCargo()));
    }

    @Test
    public void deve_verificar_cargo_atendente_simulando_entrada_de_dados_do_usuario() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.setCargo("Atendente");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario.getCargo()));
    }

    @Test
    public void deve_verificar_cargo_auxiliar_simulando_entrada_de_dados_do_usuario() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.setCargo("Auxiliar");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario.getCargo()));
    }

    @Test
    public void deve_verificar_cargo_nuloo() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.setCargo(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_cargo_vazio() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.setCargo("");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_cargo_numerico() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.setCargo("9043879");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_cargo_especiais() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.setCargo("$#@!");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve armazenar codigo simulado com entrada de dados.
     */
    @Test
    public void deve_armazenar_codigo_simulado_com_entrada_de_dados() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.setCodigo(234);
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_codigo_0() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.setCodigo(0);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve armazenar codigo gerados aleatoriamente com objetos fake.
     */
    @Test
    public void deve_armazenar_codigo_gerados_aleatoriamente_com_objetos_fake() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario.getCodigo()));
    }

    /**
     * Deve armazenar salario gerado com objetos fake.
     */
    @Test
    public void deve_armazenar_salario_gerado_com_objetos_fake() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.getSalario();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario.getSalario()));
    }

    /**
     * Deve setar salario simulando entrada de dados.
     */
    @Test
    public void deve_setar_salario_simulando_entrada_de_dados() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.setSalario(new BigDecimal("5000.00"));
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario.getSalario()));
    }

    @Test
    public void deve_setar_salario_nulo() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        funcionario.setSalario(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }
    
    @AfterClass
    public static void envia_para_banco_de_dados() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        MongoDbConnection.sentoToDatabaseFuncionario(funcionario);
    }
    
    @AfterClass
    public static void deve_enviar_e_deletar_banco_de_dados() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        MongoDbConnection.deleteDocumentInFuncionario(funcionario);
    }
    
    @AfterClass
    public static void deve_enviar_e_atualizar_banco_de_dados() {
        Funcionario funcionario = randomObject.funcionarioRandomizer();
        MongoDbConnection.updateDocumentInFuncionario(funcionario);
    }
    
    @AfterClass
    public static void deve_encontrar_documento_aleatorio_funcionario() {
    	 Funcionario funcionario = randomObject.funcionarioRandomizer();
         MongoDbConnection.findDocumentInFuncionario(funcionario);
    }
    
    @AfterClass
    public static void deve_retornar_todos_documentos_cadastro_em_json() {
    	MongoDbConnection.returnDocumentsInFuncionarioCollection();
    }
}

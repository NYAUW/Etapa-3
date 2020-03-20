package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class FuncionarioTest.
 */
public class FuncionarioTest {

    /** The funcionario. */
    Funcionario funcionario;

    /** The valid. */
    ValidateAnnotations<Object> valid;

    /**
     * Set up.
     */
    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    /**
     * Verifica classes iguais hashcode.
     */
    @Test
    public void verifica_classes_iguais_hashcode() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        System.out.println(funcionario);
        assertEquals(funcionario.hashCode(), funcionario.hashCode());
    }

    @Test
    public void deve_mostrar_conteudo_da_classe() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        System.out.println(funcionario);
    }

    @Test
    public void deve_verificar_nome_to_string() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertTrue(funcionario.toString().contains("nome"));
    }

    @Test
    public void deve_verificar_cargo_to_string() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertTrue(funcionario.toString().contains("cargo"));
    }

    @Test
    public void deve_verificar_codigo_to_string() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertTrue(funcionario.toString().contains("codigo"));
    }

    @Test
    public void deve_verificar_salario_to_string() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertTrue(funcionario.toString().contains("salario"));
    }

    @Test
    public void deve_comparar_dados_do_construtor() {
        Funcionario funcionario = new Funcionario("Lucas Alves Ribeiro", "Auxiliar", 234, new BigDecimal("3000.00"));
        assertEquals(funcionario, funcionario);
    }

    @Test
    public void deve_verificar_se_a_classe_contem_dados_nulos() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertFalse(funcionario.equals(null));
    }

    @Test
    public void deve_comparar_objetos_da_classe() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertFalse(funcionario.equals(new Object()));
    }

    @Test
    public void deve_verificar_classes_iguais() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertEquals(funcionario, funcionario);
    }

    @Test
    public void deve_verificar_classes_iguais_com_equals() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        Funcionario funcionario2 = Fixture.from(Funcionario.class).gimme("funcionario");

        assertNotEquals(funcionario, funcionario2);
    }

    @Test
    public void deve_verificar_objeto_das_classes() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        Funcionario funcionario2 = Fixture.from(Funcionario.class).gimme("funcionario");
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
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setNome("Marcelao Alves");
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_nome_incompleto() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setNome("M");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_nome_com_entrada_numerica() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setNome("Marcel4o Alves");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_nome_com_entrada_blank() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setNome("");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_nome_com_entrada_nula() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setNome(null);
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_nome_com_entrada_especial() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setNome("$#@&*%$#@");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_nome_com_entrada_somente_numeros() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setNome("39407894065");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar nome gerado com objetos fake.
     */
    @Test
    public void deve_verificar_nome_gerado_com_objetos_fake() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.getNome();
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar cargo gerados com objetos fake.
     */
    @Test
    public void deve_verificar_cargo_gerados_com_objetos_fake() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.getCargo();
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar cargo simulando entrada de dados do usuario.
     */
    @Test
    public void deve_verificar_cargo_tecnico_simulando_entrada_de_dados_do_usuario() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo("Tecnico");
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_cargo_atendente_simulando_entrada_de_dados_do_usuario() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo("Atendente");
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_cargo_auxiliar_simulando_entrada_de_dados_do_usuario() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo("Auxiliar");
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_cargo_nuloo() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo(null);
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_cargo_vazio() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo("");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_cargo_numerico() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo("9043879");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_cargo_especiais() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo("$#@!");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve armazenar codigo simulado com entrada de dados.
     */
    @Test
    public void deve_armazenar_codigo_simulado_com_entrada_de_dados() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCodigo(234);
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_codigo_0() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCodigo(0);
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve armazenar codigo gerados aleatoriamente com objetos fake.
     */
    @Test
    public void deve_armazenar_codigo_gerados_aleatoriamente_com_objetos_fake() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.getCodigo();
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve armazenar salario gerado com objetos fake.
     */
    @Test
    public void deve_armazenar_salario_gerado_com_objetos_fake() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.getSalario();
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve setar salario simulando entrada de dados.
     */
    @Test
    public void deve_setar_salario_simulando_entrada_de_dados() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setSalario(new BigDecimal("5000.00"));
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_setar_salario_nulo() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setSalario(null);
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(funcionario));
    }
}

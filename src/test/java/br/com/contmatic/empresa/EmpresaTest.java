package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mongodb.Mongo;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class EmpresaTest.
 */
public class EmpresaTest {

    /** The empresa. */
    static Empresa empresa;

    /** The valid. */
    ValidateAnnotations<Object> valid;

    /**
     * Set up.
     */
    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    @Before
    public void deve_atribuir_valor_é_model_empresa_a_partir_do_fixture() {
        empresa = Fixture.from(Empresa.class).gimme("empresa");
    }
   
    @Test
    public void deve_verificar_construtor_com_dados_iguais() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        Empresa empresa = new Empresa("44268730000143", "Sim Tv Assistencia", "Servir nossos clientes de forma excepcional", "Luis Carlos Ribeiro", empresa1.getTelefones(), empresa1.getEndereco());
        assertNotEquals(empresa1, empresa);
    }

    /**
     * Deve comparar as classes diferentes.
     */
    @Test
    public void deve_comparar_as_classes_diferentes() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        Empresa empresa2 = Fixture.from(Empresa.class).gimme("empresa");
        assertNotEquals(empresa1.hashCode(), empresa2.hashCode());
        assertNotEquals(empresa1, empresa2);
    }

    @Test
    public void deve_verificar_construtor_da_classe_com_os_mesmos_dados() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        Empresa empresa = new Empresa("29685787000154", "Games Developer", "Razao Social Inserida Aqui", "Christian Schneider", telefone, endereco);
        assertEquals(empresa, empresa);
    }

    @Test
    public void deve_verificar_igualdade_de_classes_null() {
        assertFalse(empresa.equals(null));
    }

    /**
     * Deve comparar as classes e construtores.
     */
    @Test
    public void deve_mostrar_as_classes_e_construtores_to_string() {
        Empresa empresa = Fixture.from(Empresa.class).gimme("empresa");
        Set<Telefone> telefone = new HashSet<>();
        Set<Endereco> endereco = new HashSet<>();
        telefone.add(Fixture.from(Telefone.class).gimme("telefone"));
        endereco.add(Fixture.from(Endereco.class).gimme("endereco"));
        empresa.setTelefones(telefone);
        empresa.setEndereco(endereco);
        System.out.println(empresa);

    }

    @Test
    public void deve_conferir_saida_cnpj_to_string() {
        Empresa empresa = Fixture.from(Empresa.class).gimme("empresa");
        assertTrue(empresa.toString().contains("cnpj"));
    }

    @Test
    public void deve_conferir_saida_nome_to_string() {
        Empresa empresa = Fixture.from(Empresa.class).gimme("empresa");
        assertTrue(empresa.toString().contains("nome"));
    }

    @Test
    public void deve_conferir_saida_razao_social_to_string() {
        Empresa empresa = Fixture.from(Empresa.class).gimme("empresa");
        assertTrue(empresa.toString().contains("razaoSocial"));
    }

    @Test
    public void deve_conferir_saida_proprietarios_to_string() {
        Empresa empresa = Fixture.from(Empresa.class).gimme("empresa");
        assertTrue(empresa.toString().contains("proprietarios"));
    }

    @Test
    public void deve_conferir_saida_telefone_to_string() {
        Empresa empresa = Fixture.from(Empresa.class).gimme("empresa");
        assertTrue(empresa.toString().contains("telefones"));
    }

    @Test
    public void deve_conferir_saida_endereco_to_string() {
        Empresa empresa = Fixture.from(Empresa.class).gimme("empresa");
        assertTrue(empresa.toString().contains("endereco"));
    }

    @Test
    public void deve_validar_cnpj_iguais() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa.setCnpj(empresa1.getCnpj());
        assertTrue(empresa1.equals(empresa1));
    }

    @Test
    public void deve_verificar_cnpj_com_acentuação() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa.setCnpj("34.776.170/0001-84");
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_cnpj_empty() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa.setCnpj("");
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresa1.getCnpj()));
    }

    @Test
    public void deve_verificar_cnpj_nulo() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa.setCnpj(null);
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_classes_iguais_com_novo_objeto() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.equals(new Object());
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_nome_somente_letras() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setNome("GamesTorrent");
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_nome_com_numeros() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setNome("GamesT0rrent");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_nome_null() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setNome(null);
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_nome_blank() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setNome("");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_razao_social_completa() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setRazaoSocial("Trabalhar Pelo Bem Comum");
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_razao_social_com_especiais() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setRazaoSocial("@!#@%#@$");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_razao_social_com_especiais_e_numeros() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setRazaoSocial("@!#@%#@$8475869754");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_razao_social_com_numeros() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setRazaoSocial("sdjksd2903839042");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_razao_social_com_sem_espaco() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setRazaoSocial("Razaosocialsemespaco");
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_razao_social_incompleta() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setRazaoSocial("Trabalhar");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_razao_social_vazia() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setRazaoSocial("");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_razao_social_nula() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setRazaoSocial(null);
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_proprietarios_com_entrada_valida() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setProprietarios("Marcela Alvares Estebao");
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_proprietarios_vazioa() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setProprietarios("");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_proprietarios_nulo() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setProprietarios(null);
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_proprietarios_com_entrada_numerica() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setProprietarios("Marc3la Estebao");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_proprietarios_incompleto() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setProprietarios("M");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_telefone_correto() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        Set<Telefone> telefone = new HashSet<>();
        telefone.add(Fixture.from(Telefone.class).gimme("telefone"));
        empresa1.setTelefones(telefone);
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_telefone_nulo() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setTelefones(null);
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_endereco_correto() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        Set<Endereco> endereco = new HashSet<>();
        endereco.add(Fixture.from(Endereco.class).gimme("endereco"));
        empresa1.setEndereco(endereco);
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresa1));
    }

    @Test
    public void deve_verificar_endereco_nulo() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setEndereco(null);
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve armazenar entrada de dados telefones.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_telefones() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setTelefones(empresaValidator.getTelefones());
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve verificar cnpj valido gerado pelo objeto fake.
     */
    @Test
    public void deve_verificar_cnpj_valido_gerado_pelo_objeto_fake() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.getCnpj();
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_verificar_cnpj_invalido_com_especiais() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setCnpj("#@$¨&&(!##%");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_verificar_cnpj_invalido_com_letras_e_numeros() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setCnpj("875853dsjfhjsg");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_verificar_cnpj_invalido_com_numeros_incompletos() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setCnpj("875853");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve verificar cnpj valido simulado com entrada de dados.
     */
    @Test
    public void deve_verificar_cnpj_valido_simulado_com_entrada_de_dados() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setCnpj("56243436000166");
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve armazenar entrada nome empresa com objeto fake.
     */
    @Test
    public void deve_armazenar_entrada_nome_empresa_com_objeto_fake() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.getNome();
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_setar_entrada_nome_empresa_simulando_entrada_do_usuario() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setNome("Jogos HD Gratis Torrent");
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve armazenar entrada de dados razao social.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_razao_social() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setRazaoSocial("TRABALHAR PELO BEM COMUM DA SOCIEDADE");
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_razao_social_com_especiais() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setRazaoSocial("TRA@$#¨&@!$");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_razao_social_com_numeros_letras() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setRazaoSocial("TRA723675256745");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_razao_social_com_especos_apenas() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setRazaoSocial("                ");
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve aceitar entrada proprietario not null gerado com objeto fake.
     */
    @Test
    public void deve_aceitar_entrada_proprietario_not_null_gerado_com_objeto_fake() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        assertNotNull(empresaValidator.getProprietarios());
    }

    /**
     * Deve armazenar nome completo proprietario simulado com entrada de dados.
     */
    @Test
    public void deve_armazenar_nome_completo_proprietario_simulado_com_entrada_de_dados() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setProprietarios("Luis Carlos Ribeiro");
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_armazenar_nome_completo_proprietario_com_numeros() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setProprietarios("Luis Carl3os Ribeiro");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_armazenar_nome_completo_proprietario_com_especiais() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setProprietarios("Luis Carl#os Ribeiro");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_armazenar_nome_completo_proprietario_nulo() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setProprietarios(null);
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_armazenar_nome_completo_proprietario_vazio() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setProprietarios("");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve verificar dados gerados razao social com objetos fake.
     */
    @Test
    public void deve_verificar_dados_gerados_razao_social_com_objetos_fake() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.getRazaoSocial();
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve verificar endereco gerados com objetos fake.
     */
    @Test
    public void deve_verificar_endereco_gerados_com_objetos_fake() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.getEndereco();
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve setar endereco simulando entrada de dados com objetos fake.
     */
    @Test
    public void deve_setar_endereco_simulando_entrada_de_dados_com_objetos_fake() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setEndereco(empresaValidator.getEndereco());
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_armazenar_endereco_nulo() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setEndereco(null);
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(empresaValidator));
    }
}

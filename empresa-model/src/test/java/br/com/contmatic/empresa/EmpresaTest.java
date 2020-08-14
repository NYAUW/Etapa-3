package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.easyrandom.EasyRandomClass;
import br.com.contmatic.validator.ValidadorAnnotations;

/**
 * The Class EmpresaTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaTest {

    private static EasyRandomClass randomObject = EasyRandomClass.instanciaEasyRandomClass();

    @Test
    public void deve_verificar_construtor_com_dados_iguais() {
        Empresa empresa = randomObject.empresaRandomizer();
        Empresa comparator = randomObject.empresaRandomizer();
        assertNotEquals(empresa, comparator);
    }

    /**
     * Deve comparar as classes diferentes.
     */
    @Test
    public void deve_comparar_as_classes_diferentes_hashcode() {
        Empresa empresa = randomObject.empresaRandomizer();
        Empresa empresa2 = randomObject.empresaRandomizer();
        assertNotEquals(empresa.hashCode(), empresa2.hashCode());
    }

    @Test
    public void deve_comparar_as_classes_diferentes_equals() {
        Empresa empresa = randomObject.empresaRandomizer();
        Empresa empresa2 = randomObject.empresaRandomizer();
        assertNotEquals(empresa, empresa2);
    }

    @Test
    public void deve_verificar_construtor_da_classe_com_os_mesmos_dados() {
        Empresa empresa = randomObject.empresaRandomizer();
        assertEquals(empresa, empresa);
    }

    @Test
    public void deve_verificar_igualdade_de_classes_null() {
        Empresa empresa = randomObject.empresaRandomizer();
        assertFalse(empresa.equals(null));
    }

    @Test
    public void deve_conferir_saida_cnpj_to_string() {
        Empresa empresa = randomObject.empresaRandomizer();
        assertTrue(empresa.toString().contains("cnpj"));
    }

    @Test
    public void deve_conferir_saida_nome_to_string() {
        Empresa empresa = randomObject.empresaRandomizer();
        assertTrue(empresa.toString().contains("nome"));
    }

    @Test
    public void deve_conferir_saida_razao_social_to_string() {
        Empresa empresa = randomObject.empresaRandomizer();
        assertTrue(empresa.toString().contains("razaoSocial"));
    }

    @Test
    public void deve_conferir_saida_proprietarios_to_string() {
        Empresa empresa = randomObject.empresaRandomizer();
        assertTrue(empresa.toString().contains("proprietarios"));
    }

    @Test
    public void deve_conferir_saida_telefone_to_string() {
        Empresa empresa = randomObject.empresaRandomizer();
        assertTrue(empresa.toString().contains("telefones"));
    }

    @Test
    public void deve_conferir_saida_endereco_to_string() {
        Empresa empresa = randomObject.empresaRandomizer();
        assertTrue(empresa.toString().contains("endereco"));
    }

    @Test
    public void deve_validar_cnpj_iguais() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setCnpj(empresa.getCnpj());
        assertTrue(empresa.equals(empresa));
    }

    @Test
    public void deve_verificar_cnpj_com_acentuação() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setCnpj("34.776.170/0001-84");
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(empresa.getCnpj()));
    }

    @Test
    public void deve_verificar_cnpj_empty() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setCnpj("");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_cnpj_nulo() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setCnpj(null);
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_classes_iguais_com_novo_objeto() {
        Empresa empresa = randomObject.empresaRandomizer();
        assertFalse(empresa.equals(new Object()));
    }

    @Test
    public void deve_verificar_nome_somente_letras() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setNome("GamesTorrent");
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(empresa.getNome()));
    }

    @Test
    public void deve_verificar_nome_com_numeros() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setNome("GamesT0rrent");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_nome_null() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setNome(null);

        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_nome_blank() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setNome("");

        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_razao_social_completa() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setRazaoSocial("Trabalhar Pelo Bem Comum");
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(empresa.getRazaoSocial()));
    }

    @Test
    public void deve_verificar_razao_social_com_especiais() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setRazaoSocial("@!#@%#@$");

        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_razao_social_com_especiais_e_numeros() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setRazaoSocial("@!#@%#@$8475869754");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_razao_social_com_numeros() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setRazaoSocial("sdjksd2903839042");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_razao_social_com_sem_espaco() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setRazaoSocial("Razaosocialsemespaco");
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(empresa.getRazaoSocial()));
    }

    @Test
    public void deve_verificar_razao_social_incompleta() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setRazaoSocial("Trabalhar");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_razao_social_vazia() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setRazaoSocial("");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_razao_social_nula() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setRazaoSocial(null);
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_proprietarios_com_entrada_valida() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setProprietarios("Marcela Alvares Estebao");
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(empresa.getProprietarios()));
    }

    @Test
    public void deve_verificar_proprietarios_vazioa() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setProprietarios("");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_proprietarios_nulo() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setProprietarios(null);
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_proprietarios_com_entrada_numerica() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setProprietarios("Marc3la Estebao");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_proprietarios_incompleto() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setProprietarios("M");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_telefone_correto() {
        Empresa empresa = randomObject.empresaRandomizer();
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(empresa.getTelefones()));
    }

    @Test
    public void deve_verificar_endereco_correto() {
        Empresa empresa = randomObject.empresaRandomizer();
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(empresa.getEndereco()));
    }

    @Test
    public void deve_verificar_endereco_nulo() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setEndereco(null);
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    /**
     * Deve armazenar entrada de dados telefones.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_telefones() {
        Empresa empresa = randomObject.empresaRandomizer();
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(empresa.getTelefones()));
    }

    /**
     * Deve verificar cnpj valido gerado pelo objeto fake.
     */
    @Test
    public void deve_verificar_cnpj_valido_gerado_pelo_objeto_fake() {
        Empresa empresa = randomObject.empresaRandomizer();
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(empresa.getCnpj()));
    }

    @Test
    public void deve_verificar_cnpj_invalido_com_especiais() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setCnpj("#@$¨&&(!##%");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_cnpj_invalido_com_letras_e_numeros() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setCnpj("875853dsjfhjsg");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_cnpj_invalido_com_numeros_incompletos() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setCnpj("875853");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    /**
     * Deve verificar cnpj valido simulado com entrada de dados.
     */
    @Test
    public void deve_verificar_cnpj_valido_simulado_com_entrada_de_dados() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setCnpj("56243436000166");
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(empresa.getCnpj()));
    }

    /**
     * Deve armazenar entrada nome empresa com objeto fake.
     */
    @Test
    public void deve_armazenar_entrada_nome_empresa_com_objeto_fake() {
        Empresa empresa = randomObject.empresaRandomizer();
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(empresa.getNome()));
    }

    @Test
    public void deve_setar_entrada_nome_empresa_simulando_entrada_do_usuario() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setNome("Jogos HD Gratis Torrent");
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(empresa.getNome()));
    }

    /**
     * Deve armazenar entrada de dados razao social.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_razao_social() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setRazaoSocial("TRABALHAR PELO BEM COMUM DA SOCIEDADE");
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(empresa.getRazaoSocial()));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_razao_social_com_especiais() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setRazaoSocial("TRA@$#¨&@!$");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_razao_social_com_numeros_letras() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setRazaoSocial("TRA723675256745");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_razao_social_com_especos_apenas() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setRazaoSocial("                ");
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(empresa.getRazaoSocial()));
    }

    /**
     * Deve aceitar entrada proprietario not null gerado com objeto fake.
     */
    @Test
    public void deve_aceitar_entrada_proprietario_not_null_gerado_com_objeto_fake() {
        Empresa empresa = randomObject.empresaRandomizer();
        assertNotNull(empresa.getProprietarios());
    }

    /**
     * Deve armazenar nome completo proprietario simulado com entrada de dados.
     */
    @Test
    public void deve_armazenar_nome_completo_proprietario_simulado_com_entrada_de_dados() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setProprietarios("Luis Carlos Ribeiro");
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(empresa.getProprietarios()));
    }

    @Test
    public void deve_armazenar_nome_completo_proprietario_com_numeros() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setProprietarios("Luis Carl3os Ribeiro");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_armazenar_nome_completo_proprietario_com_especiais() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setProprietarios("Luis Carl#os Ribeiro");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_armazenar_nome_completo_proprietario_nulo() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setProprietarios(null);
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_armazenar_nome_completo_proprietario_vazio() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setProprietarios("");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }

    /**
     * Deve verificar dados gerados razao social com objetos fake.
     */
    @Test
    public void deve_verificar_dados_gerados_razao_social_com_objetos_fake() {
        Empresa empresa = randomObject.empresaRandomizer();
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(empresa.getRazaoSocial()));
    }

    /**
     * Deve verificar endereco gerados com objetos fake.
     */
    @Test
    public void deve_verificar_endereco_gerados_com_objetos_fake() {
        Empresa empresa = randomObject.empresaRandomizer();
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(empresa.getEndereco()));
    }

    @Test
    public void deve_armazenar_endereco_nulo() {
        Empresa empresa = randomObject.empresaRandomizer();
        empresa.setEndereco(null);
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(empresa));
    }
}
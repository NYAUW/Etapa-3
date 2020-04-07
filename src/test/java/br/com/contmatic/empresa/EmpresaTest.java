package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.contmatic.connectionMongoDB.MongoDbConnection;
import br.com.contmatic.easyRandomizer.EasyRandomClass;
import br.com.contmatic.endereco.Endereco;

/**
 * The Class EmpresaTest.
 */
public class EmpresaTest {
    
    private static EasyRandomClass randomObject = EasyRandomClass.InstanciaEasyRandomClass();

    @Test
    public void deve_verificar_construtor_com_dados_iguais() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        Empresa comparator = randomObject.EmpresaRandomizer();
        assertNotEquals(empresa, comparator);
    }

    /**
     * Deve comparar as classes diferentes.
     */
    @Test
    public void deve_comparar_as_classes_diferentes_hashcode() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        Empresa empresa2 = randomObject.EmpresaRandomizer();
        assertNotEquals(empresa.hashCode(), empresa2.hashCode());
    }

    @Test
    public void deve_comparar_as_classes_diferentes_equals() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        Empresa empresa2 = randomObject.EmpresaRandomizer();
        assertNotEquals(empresa, empresa2);
    }

    @Test
    public void deve_verificar_construtor_da_classe_com_os_mesmos_dados() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        assertEquals(empresa, empresa);
    }

    @Test
    public void deve_verificar_igualdade_de_classes_null() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        assertFalse(empresa.equals(null));
    }

    @Test
    public void deve_conferir_saida_cnpj_to_string() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        assertTrue(empresa.toString().contains("cnpj"));
    }

    @Test
    public void deve_conferir_saida_nome_to_string() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        assertTrue(empresa.toString().contains("nome"));
    }

    @Test
    public void deve_conferir_saida_razao_social_to_string() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        assertTrue(empresa.toString().contains("razaoSocial"));
    }

    @Test
    public void deve_conferir_saida_proprietarios_to_string() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        assertTrue(empresa.toString().contains("proprietarios"));
    }

    @Test
    public void deve_conferir_saida_telefone_to_string() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        assertTrue(empresa.toString().contains("telefones"));
    }

    @Test
    public void deve_conferir_saida_endereco_to_string() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        assertTrue(empresa.toString().contains("endereco"));
    }

    @Test
    public void deve_validar_cnpj_iguais() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setCnpj(empresa.getCnpj());
        assertTrue(empresa.equals(empresa));
    }

    @Test
    public void deve_verificar_cnpj_com_acentuação() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setCnpj("34.776.170/0001-84");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa.getCnpj()));
    }

    @Test
    public void deve_verificar_cnpj_empty() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setCnpj("");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_cnpj_nulo() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setCnpj(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_classes_iguais_com_novo_objeto() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        assertFalse(empresa.equals(new Object()));
    }

    @Test
    public void deve_verificar_nome_somente_letras() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setNome("GamesTorrent");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa.getNome()));
    }

    @Test
    public void deve_verificar_nome_com_numeros() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setNome("GamesT0rrent");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_nome_null() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setNome(null);

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_nome_blank() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setNome("");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_razao_social_completa() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setRazaoSocial("Trabalhar Pelo Bem Comum");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa.getRazaoSocial()));
    }

    @Test
    public void deve_verificar_razao_social_com_especiais() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setRazaoSocial("@!#@%#@$");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_razao_social_com_especiais_e_numeros() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setRazaoSocial("@!#@%#@$8475869754");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_razao_social_com_numeros() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setRazaoSocial("sdjksd2903839042");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_razao_social_com_sem_espaco() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setRazaoSocial("Razaosocialsemespaco");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa.getRazaoSocial()));
    }

    @Test
    public void deve_verificar_razao_social_incompleta() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setRazaoSocial("Trabalhar");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_razao_social_vazia() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setRazaoSocial("");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_razao_social_nula() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setRazaoSocial(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_proprietarios_com_entrada_valida() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setProprietarios("Marcela Alvares Estebao");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa.getProprietarios()));
    }

    @Test
    public void deve_verificar_proprietarios_vazioa() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setProprietarios("");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_proprietarios_nulo() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setProprietarios(null);

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_proprietarios_com_entrada_numerica() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setProprietarios("Marc3la Estebao");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_proprietarios_incompleto() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setProprietarios("M");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_telefone_correto() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa.getTelefones()));
    }

    @Test
    public void deve_verificar_endereco_correto() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa.getEndereco()));
    }

    @Test
    public void deve_verificar_endereco_nulo() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setEndereco(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    /**
     * Deve armazenar entrada de dados telefones.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_telefones() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa.getTelefones()));
    }

    /**
     * Deve verificar cnpj valido gerado pelo objeto fake.
     */
    @Test
    public void deve_verificar_cnpj_valido_gerado_pelo_objeto_fake() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa.getCnpj()));
    }

    @Test
    public void deve_verificar_cnpj_invalido_com_especiais() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setCnpj("#@$¨&&(!##%");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_cnpj_invalido_com_letras_e_numeros() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setCnpj("875853dsjfhjsg");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_verificar_cnpj_invalido_com_numeros_incompletos() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setCnpj("875853");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    /**
     * Deve verificar cnpj valido simulado com entrada de dados.
     */
    @Test
    public void deve_verificar_cnpj_valido_simulado_com_entrada_de_dados() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setCnpj("56243436000166");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa.getCnpj()));
    }

    /**
     * Deve armazenar entrada nome empresa com objeto fake.
     */
    @Test
    public void deve_armazenar_entrada_nome_empresa_com_objeto_fake() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa.getNome()));
    }

    @Test
    public void deve_setar_entrada_nome_empresa_simulando_entrada_do_usuario() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setNome("Jogos HD Gratis Torrent");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa.getNome()));
    }

    /**
     * Deve armazenar entrada de dados razao social.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_razao_social() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setRazaoSocial("TRABALHAR PELO BEM COMUM DA SOCIEDADE");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa.getRazaoSocial()));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_razao_social_com_especiais() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setRazaoSocial("TRA@$#¨&@!$");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_razao_social_com_numeros_letras() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setRazaoSocial("TRA723675256745");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_razao_social_com_especos_apenas() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setRazaoSocial("                ");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa.getRazaoSocial()));
    }

    /**
     * Deve aceitar entrada proprietario not null gerado com objeto fake.
     */
    @Test
    public void deve_aceitar_entrada_proprietario_not_null_gerado_com_objeto_fake() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        assertNotNull(empresa.getProprietarios());
    }

    /**
     * Deve armazenar nome completo proprietario simulado com entrada de dados.
     */
    @Test
    public void deve_armazenar_nome_completo_proprietario_simulado_com_entrada_de_dados() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setProprietarios("Luis Carlos Ribeiro");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa.getProprietarios()));
    }

    @Test
    public void deve_armazenar_nome_completo_proprietario_com_numeros() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setProprietarios("Luis Carl3os Ribeiro");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_armazenar_nome_completo_proprietario_com_especiais() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setProprietarios("Luis Carl#os Ribeiro");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_armazenar_nome_completo_proprietario_nulo() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setProprietarios(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    @Test
    public void deve_armazenar_nome_completo_proprietario_vazio() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setProprietarios("");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }

    /**
     * Deve verificar dados gerados razao social com objetos fake.
     */
    @Test
    public void deve_verificar_dados_gerados_razao_social_com_objetos_fake() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa.getRazaoSocial()));
    }

    /**
     * Deve verificar endereco gerados com objetos fake.
     */
    @Test
    public void deve_verificar_endereco_gerados_com_objetos_fake() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa.getEndereco()));
    }

    /**
     * Deve setar endereco simulando entrada de dados com objetos fake.
     */
    @Test
    public void deve_setar_endereco_simulando_entrada_de_dados_com_objetos_fake() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        Endereco endereco = randomObject.EnderecoRandomizer();
        empresa.setEndereco(endereco);
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa.getEndereco()));
    }

    @Test
    public void deve_armazenar_endereco_nulo() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        empresa.setEndereco(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa));
    }
    
    @AfterClass
    public static void deve_enviar_para_base_de_dados() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        MongoDbConnection.SentToDatabaseEmpresa(empresa);
    }
    
    @AfterClass
    public static void deve_enviar_e_deletar_documento_da_collection() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        MongoDbConnection.DeleteDocumentInEmpresa(empresa);
    }
    
    @AfterClass
    public static void deve_atualizar_nome_empresa_banco_de_dados() {
        Empresa empresa = randomObject.EmpresaRandomizer();
        MongoDbConnection.UpdateDocumentInEmpresa(empresa);
    }
}

package br.com.contmatic.cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.contmatic.connectionMongoDB.MongoDbConnection;
import br.com.contmatic.easyRandomizer.EasyRandomClass;

/**
 * The Class CadastroTest.
 */
public class CadastroTest {

    private static EasyRandomClass randomObject = EasyRandomClass.InstanciaEasyRandomClass();

    @Test
    public void deve_verificar_construtor_da_classe_com_os_mesmos_dados() {
        Cadastro cadastro = randomObject.CadastroRandomizer();
        assertEquals(cadastro, cadastro);
    }

    /**
     * Deve verificar igualdade de classes com hashcode.
     */
    @Test
    public void deve_verificar_igualdade_de_classes_hashcode() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        Cadastro cadastroValidator2 = randomObject.CadastroRandomizer();
        assertEquals(cadastroValidator.hashCode(), cadastroValidator.hashCode());
        cadastroValidator2.setCpf("50740457896");
        assertNotEquals(cadastroValidator, cadastroValidator2);
    }

    @Test
    public void deve_verificar_igualdade_de_classes() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        assertEquals(cadastroValidator, cadastroValidator);
    }

    @Test
    public void deve_verificar_igualdade_de_classes_ocm_novo_objeto() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        assertFalse(cadastroValidator.equals(new Object()));
    }

    @Test
    public void deve_verificar_igualdade_de_classes_null() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        assertFalse(cadastroValidator.equals(null));
    }

    @Test
    public void deve_verificar_desigualdade_de_classes() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        Cadastro cadastro2 = randomObject.CadastroRandomizer();
        cadastro2.setCpf("50740457896");
        assertNotEquals(cadastroValidator, cadastro2);
    }

    @Test
    public void deve_conferir_saida_nome_to_string() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        assertTrue(cadastroValidator.toString().contains("nome"));
    }

    @Test
    public void deve_conferir_saida_email_to_string() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        assertTrue(cadastroValidator.toString().contains("email"));
    }

    @Test
    public void deve_conferir_saida_senha_to_string() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        assertTrue(cadastroValidator.toString().contains("senha"));
    }

    @Test
    public void deve_conferir_saida_cpf_to_string() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        assertTrue(cadastroValidator.toString().contains("cpf"));
    }

    @Test
    public void deve_conferir_saida_rg_to_string() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        assertTrue(cadastroValidator.toString().contains("rg"));
    }

    /**
     * Deve armazenar entrada de dados de nome correto simulando o comportamento do usuario.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_de_nome_correto_simulando_o_comportamento_do_usuario() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setNome("Marcelo Celao");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getNome()));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_de_nome_incorreto_blank_simulando_o_comportamento_do_usuario() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setNome("Marcelo");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getNome()));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_de_nome_com_caracteres_especiais() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setNome("Marc$elo");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getNome()));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_de_nome_com_caracteres_especiais_e_numeros() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setNome("Marc$elo509834");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getNome()));
    }

    @Test
    public void deve_verificar_entrada_senha() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getSenha()));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_de_nome_correto_com_no_minimo_2_letras_simulando_o_comportamento_do_usuario() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setNome("Mar");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getNome()));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_de_nome_incorreto_menor_que_2_simulando_o_comportamento_do_usuario() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setNome("Ma");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getNome()));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_de_nome_correto_menor_que_50_simulando_o_comportamento_do_usuario() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setNome("Marcelo O Loko");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getNome()));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_de_nome_incorreto_maior_que_50_simulando_o_comportamento_do_usuario() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setNome("Cheiro De Pneu Queimado Carburador Furado O X9 foi");
        assertFalse(Boolean.TRUE.equals(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getNome())));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_de_email_correto_simulando_o_comportamento_do_usuario() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setEmail("lucas2001_789@gmail.com");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getEmail()));
    }

    /**
     * Deve invalidar caso nome null.
     */
    @Test
    public void deve_invalidar_caso_nome_null() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setNome("Lucas Alves");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getNome()));
    }

    /**
     * Deve verificar se nome contem numerico.
     */
    @Test
    public void deve_verificar_se_nome_contem_numerico() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        assertFalse(StringUtils.isNumeric(cadastroValidator.getNome()));
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getNome()));
    }

    /**
     * Deve armazenar entrada de dados de email.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_de_email() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.getEmail();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getEmail()));
    }

    @Test
    public void deve_simuloar_entrada_usuario_no_email() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setEmail("lucas2001.789@gmail.com.br");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getEmail()));
    }

    @Test
    public void deve_simuloar_entrada_usuario_no_email_sem_dominio() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setEmail("lucas2001.789@.com.br");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_simuloar_entrada_usuario_no_email_com_caracteres_especiais() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setEmail("lucas2001.789!@#$#$@@.com.br");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_simuloar_entrada_usuario_no_email_com_dominio_numerico() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setEmail("lucas2001.789@1899.com.br");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_simuloar_entrada_usuario_no_email_com_dominio_especial() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setEmail("lucas2001.789@1899!@#$#%.com.br");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_simuloar_entrada_usuario_no_email_sem_com_br() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setEmail("lucas2001.789@1899");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_simuloar_entrada_usuario_no_email_sem_user() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setEmail("@1899.com.br");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_simuloar_entrada_usuario_no_email_com_espaço() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setEmail("lucas ribeiro@gmail.com.br");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_simuloar_entrada_usuario_no_email_sem_o_com() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setEmail("lucas ribeiro@gmail.");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_simuloar_entrada_usuario_no_email_sem_o_ponto() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setEmail("lucas ribeiro@gmailcombr");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_simuloar_entrada_usuario_no_email_vazio() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setEmail("");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_simuloar_entrada_usuario_no_email_nulo() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setEmail(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_simuloar_entrada_usuario_no_email_maiusculo() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setEmail("LucasAlves@gmail.com");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de senha.
     */
    @Test
    public void deve_armazenar_entrada_de_senha() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getSenha()));
    }

    @Test
    public void deve_armazenar_entrada_de_senha_somente_numeros() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setSenha("123");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getSenha()));
    }

    @Test
    public void deve_armazenar_entrada_de_senha_somente_letras() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setSenha("sapinho");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getSenha()));
    }

    @Test
    public void deve_armazenar_entrada_de_senha_somente_especiais() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setSenha("!@$%%$&%");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getSenha()));
    }

    @Test
    public void deve_armazenar_entrada_de_senha_vazia() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setSenha("");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_armazenar_entrada_de_senha_nula() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setSenha(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados cpf.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_cpf() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getCpf()));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_cpf_com_acentuação() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setCpf("017.226.970-91");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getCpf()));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_cpf_com_especiais() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setCpf("@$@#@");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_cpf_com_letras() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setCpf("dsjfhdsjfg");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_cpf_sem_os_digitos_verificadores() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setCpf("017.226.970-");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_cpf_com_os_digitos_verificadores_incorretos() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setCpf("017.226.970-96");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_cpf_empty() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setCpf("");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_armazenar_entrada_de_dados_cpf_nulo() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setCpf(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve verificar cpf not null.
     */
    @Test
    public void deve_verificar_cpf_not_null() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        assertNotNull(cadastroValidator.getCpf());
        cadastroValidator.setCpf("50740457896");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getCpf()));
    }

    /**
     * Deve armazenar entrada de dados rg.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_rg() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setRg("4.881.786-78");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getRg()));
    }

    @Test
    public void deve_verificar_rg_correto() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.getRg();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator.getRg()));
    }

    /**
     * Deve verificar rg not null.
     */
    @Test
    public void deve_verificar_rg_nulo() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setRg(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_verificar_rg_sem_acentuação() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setRg("488178678");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_verificar_rg_incompleto() {
        Cadastro cadastroValidator = randomObject.CadastroRandomizer();
        cadastroValidator.setRg("4881");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }
    
    @AfterClass
    public static void envia_para_banco_de_dados() {
        Cadastro cadastro = randomObject.CadastroRandomizer();
        MongoDbConnection.SentToDatabaseCadastro(cadastro);
    }
}

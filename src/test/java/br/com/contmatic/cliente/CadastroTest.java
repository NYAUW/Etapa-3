package br.com.contmatic.cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.EasyRandomizer.EasyRandomClass;
import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class CadastroTest.
 */
public class CadastroTest {

	/** The cadastro. */
	static Cadastro cadastro;

	/** The valid. */
	ValidateAnnotations<Object> valid;

	EasyRandomClass randomObject = new EasyRandomClass();

	/**
	 * Set up.
	 */
	@BeforeClass
	public static void setUp() {
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
	}

	@Before
	public void deve_atribuir_valores_do_fixture_para_a_classe_vazia() {
		cadastro = Fixture.from(Cadastro.class).gimme("cadastro");
	}

	@Test
	public void deve_verificar_construtor_da_classe_com_os_mesmos_dados() {
		Cadastro cadastro = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "467.202.765-39",
				"6.578.498-75");
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
		Cadastro cadastro2 = Fixture.from(Cadastro.class).gimme("cadastro");
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
	 * Deve armazenar entrada de dados de nome correto simulando o comportamento do
	 * usuario.
	 */
	@Test
	public void deve_armazenar_entrada_de_dados_de_nome_correto_simulando_o_comportamento_do_usuario() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setNome("Marcelo Celao");
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getNome()));
	}

	@Test
	public void deve_armazenar_entrada_de_dados_de_nome_incorreto_blank_simulando_o_comportamento_do_usuario() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setNome("Marcelo");
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getNome()));
	}

	@Test
	public void deve_armazenar_entrada_de_dados_de_nome_com_caracteres_especiais() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setNome("Marc$elo");
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getNome()));
	}

	@Test
	public void deve_armazenar_entrada_de_dados_de_nome_com_caracteres_especiais_e_numeros() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setNome("Marc$elo509834");
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getNome()));
	}

	@Test
	public void deve_verificar_entrada_senha() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getSenha()));
	}

	@Test
	public void deve_armazenar_entrada_de_dados_de_nome_correto_com_no_minimo_2_letras_simulando_o_comportamento_do_usuario() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setNome("Mar");
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getNome()));
	}

	@Test
	public void deve_armazenar_entrada_de_dados_de_nome_incorreto_menor_que_2_simulando_o_comportamento_do_usuario() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setNome("Ma");
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getNome()));
	}

	@Test
	public void deve_armazenar_entrada_de_dados_de_nome_correto_menor_que_50_simulando_o_comportamento_do_usuario() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setNome("Marcelo O Loko");
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getNome()));
	}

	@Test
	public void deve_armazenar_entrada_de_dados_de_nome_incorreto_maior_que_50_simulando_o_comportamento_do_usuario() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setNome("Cheiro De Pneu Queimado Carburador Furado O X9 foi");
		valid = new ValidateAnnotations<>();
		assertFalse(Boolean.TRUE.equals(valid.returnAnnotationMsgError(cadastroValidator.getNome())));
	}

	@Test
	public void deve_armazenar_entrada_de_dados_de_email_correto_simulando_o_comportamento_do_usuario() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setEmail("lucas2001_789@gmail.com");
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getEmail()));
	}

	/**
	 * Deve invalidar caso nome null.
	 */
	@Test
	public void deve_invalidar_caso_nome_null() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setNome("Lucas Alves");
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getNome()));
	}

	/**
	 * Deve verificar se nome contem numerico.
	 */
	@Test
	public void deve_verificar_se_nome_contem_numerico() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		assertFalse(StringUtils.isNumeric(cadastroValidator.getNome()));
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getNome()));
	}

	/**
	 * Deve armazenar entrada de dados de email.
	 */
	@Test
	public void deve_armazenar_entrada_de_dados_de_email() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.getEmail();
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getEmail()));
	}

	@Test
	public void deve_simuloar_entrada_usuario_no_email() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setEmail("lucas2001.789@gmail.com.br");
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getEmail()));
	}

	@Test
	public void deve_simuloar_entrada_usuario_no_email_sem_dominio() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setEmail("lucas2001.789@.com.br");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_simuloar_entrada_usuario_no_email_com_caracteres_especiais() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setEmail("lucas2001.789!@#$#$@@.com.br");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_simuloar_entrada_usuario_no_email_com_dominio_numerico() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setEmail("lucas2001.789@1899.com.br");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_simuloar_entrada_usuario_no_email_com_dominio_especial() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setEmail("lucas2001.789@1899!@#$#%.com.br");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_simuloar_entrada_usuario_no_email_sem_com_br() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setEmail("lucas2001.789@1899");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_simuloar_entrada_usuario_no_email_sem_user() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setEmail("@1899.com.br");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_simuloar_entrada_usuario_no_email_com_espaço() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setEmail("lucas ribeiro@gmail.com.br");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_simuloar_entrada_usuario_no_email_sem_o_com() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setEmail("lucas ribeiro@gmail.");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_simuloar_entrada_usuario_no_email_sem_o_ponto() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setEmail("lucas ribeiro@gmailcombr");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_simuloar_entrada_usuario_no_email_vazio() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setEmail("");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_simuloar_entrada_usuario_no_email_nulo() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setEmail(null);
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_simuloar_entrada_usuario_no_email_maiusculo() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setEmail("LucasAlves@gmail.com");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	/**
	 * Deve armazenar entrada de senha.
	 */
	@Test
	public void deve_armazenar_entrada_de_senha() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getSenha()));
	}

	@Test
	public void deve_armazenar_entrada_de_senha_somente_numeros() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setSenha("123");
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getSenha()));
	}

	@Test
	public void deve_armazenar_entrada_de_senha_somente_letras() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setSenha("sapinho");
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getSenha()));
	}

	@Test
	public void deve_armazenar_entrada_de_senha_somente_especiais() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setSenha("!@$%%$&%");
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getSenha()));
	}

	@Test
	public void deve_armazenar_entrada_de_senha_vazia() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setSenha("");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_armazenar_entrada_de_senha_nula() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setSenha(null);
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	/**
	 * Deve armazenar entrada de dados cpf.
	 */
	@Test
	public void deve_armazenar_entrada_de_dados_cpf() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getCpf()));
	}

	@Test
	public void deve_armazenar_entrada_de_dados_cpf_com_acentuação() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setCpf("017.226.970-91");
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getCpf()));
	}

	@Test
	public void deve_armazenar_entrada_de_dados_cpf_com_especiais() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setCpf("@$@#@");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_armazenar_entrada_de_dados_cpf_com_letras() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setCpf("dsjfhdsjfg");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_armazenar_entrada_de_dados_cpf_sem_os_digitos_verificadores() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setCpf("017.226.970-");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_armazenar_entrada_de_dados_cpf_com_os_digitos_verificadores_incorretos() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setCpf("017.226.970-96");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_armazenar_entrada_de_dados_cpf_empty() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setCpf("");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_armazenar_entrada_de_dados_cpf_nulo() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setCpf(null);
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	/**
	 * Deve verificar cpf not null.
	 */
	@Test
	public void deve_verificar_cpf_not_null() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		assertNotNull(cadastroValidator.getCpf());
		cadastroValidator.setCpf("50740457896");
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getCpf()));
	}

	/**
	 * Deve armazenar entrada de dados rg.
	 */
	@Test
	public void deve_armazenar_entrada_de_dados_rg() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setRg("4.881.786-78");
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getRg()));
	}

	@Test
	public void deve_verificar_rg_correto() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.getRg();
		valid = new ValidateAnnotations<>();
		assertFalse(valid.returnAnnotationMsgError(cadastroValidator.getRg()));
	}

	/**
	 * Deve verificar rg not null.
	 */
	@Test
	public void deve_verificar_rg_nulo() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setRg(null);
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_verificar_rg_sem_acentuação() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setRg("488178678");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}

	@Test
	public void deve_verificar_rg_incompleto() {
		Cadastro cadastroValidator = randomObject.CadastroRandomizer();
		cadastroValidator.setRg("4881");
		valid = new ValidateAnnotations<>();
		assertTrue(valid.returnAnnotationMsgError(cadastroValidator));
	}
}

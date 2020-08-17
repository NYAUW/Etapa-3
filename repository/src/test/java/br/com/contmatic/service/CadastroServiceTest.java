package br.com.contmatic.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.contmatic.cliente.Cadastro;
import br.com.contmatic.easyrandom.EasyRandomClass;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CadastroServiceTest {

	private static CadastroService cadastroService;

	private static Cadastro cadastro;

	private static EasyRandomClass random = EasyRandomClass.instanciaEasyRandomClass();

	private static final Logger LOGGER = LoggerFactory.getLogger(CadastroServiceTest.class);

	@BeforeClass
	public static void easyRandomDados() {
		cadastroService = new CadastroService();
		cadastro = random.cadastroRandomizer();
		cadastroService.save(cadastro);
	}

	@Test
	public void deve_salvar_cadastro() {
		try {
			cadastroService.save(cadastro);
			assertEquals(cadastro, cadastroService.findById(cadastro.getCpf()));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Test
	public void deve_atualizar_cadastro() {
		cadastro.setNome("Teste");
		cadastroService.update(cadastro);
		assertEquals(cadastroService.findById(cadastro.getCpf()).getNome(), cadastro.getNome());
	}

	@Test
	public void deve_deletar_cadastro() {
		try {
			EasyRandomClass random = EasyRandomClass.instanciaEasyRandomClass();
			cadastro = random.cadastroRandomizer();
			cadastroService.save(cadastro);
			cadastroService.deleteById(cadastro.getCpf());
			assertEquals(null, cadastroService.findById(cadastro.getCpf()));
			cadastroService.save(cadastro);
		} catch (IllegalAccessException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Test
	public void deve_retornar_todos_cadastros() {
		assertFalse(cadastroService.findAll().isEmpty());
	}
}

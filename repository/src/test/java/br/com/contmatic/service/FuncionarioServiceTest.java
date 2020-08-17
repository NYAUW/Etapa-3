package br.com.contmatic.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.contmatic.easyrandom.EasyRandomClass;
import br.com.contmatic.empresa.Funcionario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FuncionarioServiceTest {
	private static FuncionarioService funcionarioService;

    private static Funcionario funcionario;
    
    private static EasyRandomClass random = EasyRandomClass.instanciaEasyRandomClass();
    
    private static final Logger LOGGER = LoggerFactory.getLogger(FuncionarioServiceTest.class);
    

    @BeforeClass
    public static void easyRandomDados() {
    	funcionarioService = new FuncionarioService();
    	funcionario = random.funcionarioRandomizer();
        funcionarioService.save(funcionario);
    }
	
    @Test
    public void deve_salvar_empresa() {
        try {
            funcionarioService.save(funcionario);
            assertEquals(funcionario, funcionarioService.findById(funcionario.getCodigo()));
        } catch (Exception e) {
        	LOGGER.error(e.getMessage(), e);
        }
    }

    @Test
    public void deve_atualizar_empresa() {
        funcionario.setNome("Teste");
        funcionarioService.update(funcionario);
        assertEquals(funcionarioService.findById(funcionario.getCodigo()).getNome(), funcionario.getNome());
    }
    
    @Test
    public void deve_deletar_empresa() {
    	EasyRandomClass random = EasyRandomClass.instanciaEasyRandomClass();
    	funcionario = random.funcionarioRandomizer();
    	try {
    		funcionarioService.save(funcionario);
			funcionarioService.deleteById(funcionario.getCodigo());
			assertNull(funcionarioService.findById(funcionario.getCodigo()));
			funcionarioService.save(funcionario);
		} catch (IllegalAccessException e) {
			LOGGER.error(e.getMessage(), e);
		}
    }
    
    @Test
    public void deve_retornar_todas_empresas() {
    	assertFalse(funcionarioService.findAll().isEmpty());
    }

}

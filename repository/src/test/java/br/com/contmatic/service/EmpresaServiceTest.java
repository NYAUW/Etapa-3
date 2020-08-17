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
import br.com.contmatic.empresa.Empresa;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaServiceTest {
	
    private static EmpresaService empresaService;

    private static Empresa empresa;
    
    private static EasyRandomClass random = EasyRandomClass.instanciaEasyRandomClass();
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CadastroServiceTest.class);
    

    @BeforeClass
    public static void easyRandomDados() {
    	empresaService = new EmpresaService();
    	empresa = random.empresaRandomizer();
        empresaService.save(empresa);
    }
	
    @Test
    public void deve_salvar_empresa() {
        try {
            empresaService.save(empresa);
            assertEquals(empresa, empresaService.findById(empresa.getCnpj()));
        } catch (Exception e) {
        	LOGGER.error(e.getMessage(), e);
        }
    }

    @Test
    public void deve_atualizar_empresa() {
        empresa.setNome("Teste");
        empresaService.update(empresa);
        assertEquals(empresaService.findById(empresa.getCnpj()).getNome(), empresa.getNome());
    }
    
    @Test
    public void deve_deletar_empresa() {
    	EasyRandomClass random = EasyRandomClass.instanciaEasyRandomClass();
    	empresa = random.empresaRandomizer();
    	empresaService.save(empresa);
    	empresaService.deleteById(empresa.getCnpj());
    	assertNull(empresaService.findById(empresa.getCnpj()));
    	empresaService.save(empresa);
    }
    
    @Test
    public void deve_retornar_todas_empresas() {
    	assertFalse(empresaService.findAll().isEmpty());
    }

}

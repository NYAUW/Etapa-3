package br.com.contmatic.service;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.easyrandom.EasyRandomClass;
import br.com.contmatic.empresa.Empresa;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaServiceTest {
	
    private static EmpresaService empresaService = new EmpresaService();

    private static Empresa empresa;
    
    private static EasyRandomClass random = EasyRandomClass.instanciaEasyRandomClass();
    

    @BeforeClass
    public static void easyRandomDados() {
    	empresa = random.empresaRandomizer();
        empresaService.save(empresa);
    }
	
    @Test
    public void deve_salvar_empresa() {
        try {
            empresaService.save(empresa);
            assertEquals(empresa, empresaService.findById(empresa.getCnpj()));
        } catch (Exception e) {
            e.printStackTrace();
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
    	assertEquals(null, empresaService.findById(empresa.getCnpj()));
    	empresaService.save(empresa);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_ao_tentar_deletar_empresa_que_nao_existe() {
    	empresaService.deleteById("1");
    }

}

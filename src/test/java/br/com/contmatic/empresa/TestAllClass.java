package br.com.contmatic.empresa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.FixtureFactory.FixtureFactoryTest;
import br.com.contmatic.cliente.CadastroTest;
import br.com.contmatic.endereco.EnderecoTest;
import br.com.contmatic.telefone.TelefoneTest;

/**
 * The Class TestAllClass.
 */
@RunWith(Suite.class)
@SuiteClasses({ EmpresaTest.class, FuncionarioTest.class, CadastroTest.class, TelefoneTest.class, EnderecoTest.class, FixtureFactoryTest.class })
public class TestAllClass {

}

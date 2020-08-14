package br.com.contmatic.empresa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.cadastro.CadastroTest;
import br.com.contmatic.endereco.EnderecoTest;
import br.com.contmatic.telefone.TelefoneTest;

/**
 * The Class TestAllClasses.
 */
@RunWith(Suite.class)
@SuiteClasses({ EmpresaTest.class, FuncionarioTest.class, EnderecoTest.class, EnderecoTest.class, TelefoneTest.class, CadastroTest.class })
public class TestAll {

}

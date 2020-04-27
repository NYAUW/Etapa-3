package br.com.contmatic.empresa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.cliente.CadastroTest;
import br.com.contmatic.endereco.EnderecoTest;
import br.com.contmatic.mongo.CadastroMongoTest;
import br.com.contmatic.mongo.EmpresaMongoTest;
import br.com.contmatic.mongo.FuncionarioMongoTest;
import br.com.contmatic.telefone.TelefoneTest;

/**
 * The Class TestAllClass.
 */
@RunWith(Suite.class)
@SuiteClasses({ EmpresaTest.class, FuncionarioTest.class, CadastroTest.class, TelefoneTest.class, EnderecoTest.class, EmpresaMongoTest.class, FuncionarioMongoTest.class, CadastroMongoTest.class })
public class TestAllClass {
}

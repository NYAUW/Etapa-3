package br.com.contmatic.run;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.cadastro.CadastroTest;
import br.com.contmatic.empresa.EmpresaTest;
import br.com.contmatic.empresa.FuncionarioTest;
import br.com.contmatic.endereco.EnderecoTest;
import br.com.contmatic.service.CadastroServiceTest;
import br.com.contmatic.service.EmpresaServiceTest;
import br.com.contmatic.service.FuncionarioServiceTest;
import br.com.contmatic.service.MongoEmbedded;
import br.com.contmatic.telefone.TelefoneTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	EmpresaTest.class, 
	FuncionarioTest.class, 
	EnderecoTest.class, 
	EnderecoTest.class, 
	TelefoneTest.class,
	CadastroTest.class, 
	EmpresaServiceTest.class, 
	CadastroServiceTest.class, 
	FuncionarioServiceTest.class,
	MongoEmbedded.class })
public class RunProjectTest {

}
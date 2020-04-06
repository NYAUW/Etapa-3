package br.com.contmatic.easyRandomizer;

import java.math.BigDecimal;
import java.util.Random;

import org.jeasy.random.EasyRandom;

import com.github.javafaker.Faker;

import br.com.contmatic.cliente.Cadastro;
import br.com.contmatic.constante.ConstanteRegex;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Funcionario;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.enums.EnumBairros;
import br.com.contmatic.enums.EnumCargoFuncionarios;
import br.com.contmatic.enums.EnumDddsTelefone;
import br.com.contmatic.enums.EnumTipoTelefone;
import br.com.contmatic.telefone.Telefone;

public class EasyRandomClass {
    
    public static EasyRandom easy = new EasyRandom();

    public Cadastro CadastroRandomizer() {
        Faker faker = new Faker();
        EasyRandom easyFakeObject = new EasyRandom();
        Cadastro cadastro = easyFakeObject.nextObject(Cadastro.class);
        cadastro.setNome(faker.name().fullName());
        cadastro.setCpf(GeraCpf.GeraCpf());
        cadastro.setEmail(faker.funnyName().name().replace(" ", "").replace("'", "") + DominioEmail());
        cadastro.setRg(faker.regexify("[0-9]{7}-[0-9]{2}"));
        return cadastro;
    }

    public Empresa EmpresaRandomizer() {
        Faker faker = new Faker();
        EasyRandom easyFakeObject = new EasyRandom();
        Empresa empresa = easyFakeObject.nextObject(Empresa.class);
        empresa.setCnpj(GeraCnpj());
        empresa.setNome(faker.leagueOfLegends().champion());
        empresa.setRazaoSocial(faker.lorem().sentence());
        empresa.setProprietarios(faker.funnyName().name());
        empresa.setTelefones(TelefoneRandomizer());
        empresa.setEndereco( EnderecoRandomizer());
        return empresa;
    }

    /**
     * 
     */

    public Telefone TelefoneRandomizer() {
        Faker faker = new Faker();
        EasyRandom easyRandomObject = new EasyRandom();
        Telefone telefone = easyRandomObject.nextObject(Telefone.class);
        telefone.setDdd((EnumDddsTelefone.values()[Double.valueOf(Math.random() * EnumDddsTelefone.values().length).intValue()]).getDdd());
        telefone.setNumero(faker.regexify(ConstanteRegex.NUMERO_TELEFONE));
        telefone.setRamal(faker.regexify(ConstanteRegex.RAMAL));
        telefone.setTipo((EnumTipoTelefone.values()[Double.valueOf(Math.random() * EnumTipoTelefone.values().length).intValue()]).getTipo());
        return telefone;
    }

    public Endereco EnderecoRandomizer() {
        Faker faker = new Faker();
        EasyRandom easyRandomObject = new EasyRandom();
        Endereco endereco = easyRandomObject.nextObject(Endereco.class);
        endereco.setBairro((EnumBairros.values()[Double.valueOf(Math.random() * EnumBairros.values().length).intValue()]).getBairro());
        endereco.setCep(faker.regexify("[0-9]{8}"));
        endereco.setRua(faker.address().streetName());
        endereco.setRegiao(faker.address().country().replace("(", "").replace(")", ""));
        endereco.setNumero(Integer.parseInt(faker.regexify(ConstanteRegex.NUMERO_TELEFONE)));
        return endereco;
    }
    
    public Funcionario FuncionarioRandomizer() {
        Faker fakeObject = new Faker();
        EasyRandom easyFakeObject = new EasyRandom();
        Funcionario funcionario = easyFakeObject.nextObject(Funcionario.class);
        funcionario.setCargo((EnumCargoFuncionarios.values()[Double.valueOf(Math.random() * EnumCargoFuncionarios.values().length).intValue()]).getCargo());
        funcionario.setCodigo(Integer.parseInt(fakeObject.regexify("[0-9]{9}")));
        funcionario.setNome(fakeObject.name().fullName());
        funcionario.setSalario(new BigDecimal(fakeObject.regexify("[0-9]{4}").concat("." + fakeObject.regexify("[0-9]{2}"))));
        return funcionario;
    }

    private String GeraCnpj() {
        String iniciais = "";
        Integer numero;
        for(int i = 0 ; i < 14 ; i++) {
            numero = new Integer((int) (Math.random() * 10));
            iniciais += numero.toString();
        }
        return iniciais;
    }
    
    public static EasyRandomClass InstanciaEasyRandomClass() {
        EasyRandomClass easyRandom = new EasyRandomClass();
        return easyRandom;
    }

    private String DominioEmail() {
        Random random = new Random();
        Integer numero = random.nextInt(3);
        String dominio = null;
        switch (numero) {
            case 0:
                dominio = "gmail";
                break;
            case 1:
                dominio = "hotmail";
                break;
            case 2:
                dominio = "yahoo";
                break;
        }
        return "@" + dominio + ".com.br";
    }
}

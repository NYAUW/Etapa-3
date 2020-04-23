package br.com.contmatic.object.easy;

import static org.apache.commons.lang3.StringUtils.EMPTY;

import java.math.BigDecimal;
import java.util.Arrays;
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
        cadastro.setCpf(GeraCpf());
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
        empresa.setEndereco(EnderecoRandomizer());
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
        String iniciais = EMPTY;
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
    
    public static String GeraCpf() {
        Random random = new Random();
        int numeros[] = new int[9];
        for(int i = 0 ; i < numeros.length ; i++) {
            numeros[i] = random.nextInt(9);
        }
        int calculoDigito1 = (((numeros[0] * 10) + (numeros[1] * 9) + (numeros[2] * 8) + (numeros[3] * 7) + (numeros[4] * 6) + (numeros[5] * 5) + (numeros[6] * 4) + (numeros[7] * 3) +
            (numeros[8] * 2)));
        int divisaoDigito1 = calculoDigito1 / 11;
        int multiplicacaoDigito1 = 11 * divisaoDigito1;
        int subtracaoDigito1 = calculoDigito1 - multiplicacaoDigito1;
        int Digito1 = 11 - subtracaoDigito1;
        String aux = Integer.toString(Digito1);

        if (Digito1 >= 11) {
            Digito1 += -Digito1;
        } else if (aux.length() >= 2) {
            Digito1 += -10;
        }
        int calculoDigito2 = (((numeros[0] * 11) + (numeros[1] * 10) + (numeros[2] * 9) + (numeros[3] * 8) + (numeros[4] * 7) + (numeros[5] * 6) + (numeros[6] * 5) + (numeros[7] * 4) +
            (numeros[8] * 3) + (Digito1 * 2)));
        int divisaoDigito2 = calculoDigito2 / 11;
        int multiplicacaoDigito2 = 11 * divisaoDigito2;
        int subtracaoDigito2 = calculoDigito2 - multiplicacaoDigito2;
        int Digito2 = 11 - subtracaoDigito2;
        String aux2 = Integer.toString(Digito2);

        if (Digito2 >= 11) {
            Digito2 += -Digito2;
        } else if (aux2.length() >= 2) {
            Digito2 += -10;
        }

        return Arrays.toString(numeros).replace("[", "").replace(",", "").replace("]", "").replace(" ", "") + Digito1 + Digito2;
    }
}

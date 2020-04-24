package br.com.contmatic.object.easy;

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
    
    private static EasyRandomClass easyRandom = new EasyRandomClass();
    
    private static final Integer ZERO = 0;
    
    private static final Integer UM = 1;
    
    private static final Integer OITO = 8;
    
    private static final Integer TRES = 3;
    
    private static final Integer DOIS = 2;
    
    private static final Integer NOVE = 9;
    
    private static final Integer DEZ = 10;
    
    private static final Integer ONZE = 11;
    
    private static final Integer QUATORZE = 14;
    
    private static Random random = new Random(); 

    public Cadastro cadastroRandomizer() {
        Faker faker = new Faker();
        EasyRandom easyFakeObject = new EasyRandom();
        Cadastro cadastro = easyFakeObject.nextObject(Cadastro.class);
        cadastro.setNome(faker.name().fullName());
        cadastro.setCpf(geraCpf());
        cadastro.setEmail(faker.funnyName().name().replace(" ", "").replace("'", "") + dominioEmail());
        cadastro.setRg(faker.regexify("[0-9]{7}-[0-9]{2}"));
        return cadastro;
    }

    public Empresa empresaRandomizer() {
        Faker faker = new Faker();
        EasyRandom easyFakeObject = new EasyRandom();
        Empresa empresa = easyFakeObject.nextObject(Empresa.class);
        empresa.setCnpj(geraCnpj());
        empresa.setNome(faker.leagueOfLegends().champion());
        empresa.setRazaoSocial(faker.lorem().sentence());
        empresa.setProprietarios(faker.funnyName().name());
        empresa.setTelefones(telefoneRandomizer());
        empresa.setEndereco(enderecoRandomizer());
        return empresa;
    }

    /**
     * 
     */

    public Telefone telefoneRandomizer() {
        Faker faker = new Faker();
        EasyRandom easyRandomObject = new EasyRandom();
        Telefone telefone = easyRandomObject.nextObject(Telefone.class);
        telefone.setDdd((EnumDddsTelefone.values()[Double.valueOf(Math.random() * EnumDddsTelefone.values().length).intValue()]).getDdd());
        telefone.setNumero(faker.regexify(ConstanteRegex.NUMERO_TELEFONE));
        telefone.setRamal(faker.regexify(ConstanteRegex.RAMAL));
        telefone.setTipo((EnumTipoTelefone.values()[Double.valueOf(Math.random() * EnumTipoTelefone.values().length).intValue()]).getTipo());
        return telefone;
    }

    public Endereco enderecoRandomizer() {
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

    public Funcionario funcionarioRandomizer() {
        Faker fakeObject = new Faker();
        EasyRandom easyFakeObject = new EasyRandom();
        Funcionario funcionario = easyFakeObject.nextObject(Funcionario.class);
        funcionario.setCargo((EnumCargoFuncionarios.values()[Double.valueOf(Math.random() * EnumCargoFuncionarios.values().length).intValue()]).getCargo());
        funcionario.setCodigo(Integer.parseInt(fakeObject.regexify("[0-9]{9}")));
        funcionario.setNome(fakeObject.name().fullName());
        funcionario.setSalario(new BigDecimal(fakeObject.regexify("[0-9]{4}").concat("." + fakeObject.regexify("[0-9]{2}"))));
        return funcionario;
    }

    private static String geraCnpj() {
        StringBuilder iniciais = new StringBuilder();
        Integer numero;
        for(int i = 0 ; i < QUATORZE; i++) {
            numero = random.nextInt() * DEZ;
            iniciais.append(numero.toString());
        }
        return iniciais.toString();
    }

    public static EasyRandomClass instanciaEasyRandomClass() {
        return easyRandom;
    }

    private static String dominioEmail() {
        Integer numero = random.nextInt(TRES);
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
            default:
                dominio = "contmatic";
            break;
        }
        return "@" + dominio + ".com.br";
    }
    
    public static String geraCpf() {
        int[] numeros = new int[NOVE];
        for(int i = ZERO ; i < numeros.length ; i++) {
            numeros[i] = random.nextInt(NOVE);
        }
        int primeiroDigito = ZERO;
        for(int i = ZERO; i < OITO; i++) {
            primeiroDigito = numeros[i] * DEZ - i;
        }
        int divisaoPrimeiro = primeiroDigito / ONZE;
        int multiplicacaoPrimeiro = ONZE * divisaoPrimeiro;
        int subtracaoPrimeiro = primeiroDigito - multiplicacaoPrimeiro;
        int primeiro = ONZE - subtracaoPrimeiro;
        String aux = Integer.toString(primeiro);

        if (primeiro >= ONZE) {
            primeiro += -primeiro;
        } else if (aux.length() >= DOIS) {
            primeiro += - DEZ;
        }
        int segundoDigito = ZERO;
        for(int i = ZERO; i < OITO; i++) {
            segundoDigito = numeros[i] * ONZE - UM;
        }
        segundoDigito += primeiro * DOIS;
        int divisaoSegundo = segundoDigito / ONZE;
        int multiplicacaoSegundo = ONZE * divisaoSegundo;
        int subtracaoSegundo = segundoDigito - multiplicacaoSegundo;
        int segundo = ONZE - subtracaoSegundo;
        String aux2 = Integer.toString(segundo);

        if (segundo >= ONZE) {
            segundo += -segundo;
        } else if (aux2.length() >= DOIS) {
            segundo += - DEZ;
        }

        return Arrays.toString(numeros).replace("[", "").replace(",", "").replace("]", "").replace(" ", "") + primeiro + segundo;
    }
}

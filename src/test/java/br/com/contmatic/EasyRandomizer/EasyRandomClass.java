package br.com.contmatic.EasyRandomizer;

import java.util.Random;

import org.jeasy.random.EasyRandom;
import org.junit.Test;

import com.github.javafaker.Faker;

import br.com.contmatic.cliente.Cadastro;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.telefone.DddsTelefone;
import br.com.contmatic.telefone.Telefone;

public class EasyRandomClass {

    public Cadastro CadastroRandomizer() {
        Faker faker = new Faker();
        String rg = faker.regexify("[0-9]{7}-[0-9]{2}");
        EasyRandom random = new EasyRandom();
        Cadastro cadastro = random.nextObject(Cadastro.class);
        cadastro.setNome(faker.name().fullName());
        cadastro.setCpf(GeraCpf.GeraCpf());
        String email = (faker.funnyName().name()).replace(" ", "").replace("'", "");
        cadastro.setEmail(email + DominioEmail());
        cadastro.setRg(rg);
        return cadastro;
    }

    public Empresa EmpresaRandomizer() {
        Faker faker = new Faker();
        EasyRandom random = new EasyRandom();
        Empresa empresa = random.nextObject(Empresa.class);
        empresa.setCnpj(GeraCnpj());
        empresa.setNome(faker.leagueOfLegends().champion());
        empresa.setRazaoSocial(faker.lorem().sentence());
        empresa.setProprietarios(faker.funnyName().name());
        return empresa;
    }
    
    @Test
    public void TelefoneRandomizer() {
        Faker faker = new Faker();
        DddsTelefone ddds;
        EasyRandom random = new EasyRandom();
        Telefone telefone = random.nextObject(Telefone.class);
        telefone.setDdd(faker.);
        System.out.println(telefone);
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

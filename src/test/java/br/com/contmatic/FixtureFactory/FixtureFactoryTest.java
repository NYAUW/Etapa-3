package br.com.contmatic.FixtureFactory;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Random;

import org.junit.Test;

import br.com.contmatic.EasyRandomizer.GeraCpf;
import br.com.contmatic.cliente.Cadastro;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Funcionario;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.endereco.TipoEndereco;
import br.com.contmatic.telefone.DddsTelefone;
import br.com.contmatic.telefone.Telefone;
import br.com.contmatic.telefone.TipoTelefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * The Class FixtureFactoryTest.
 * 
 * @param <E>
 */
public class FixtureFactoryTest<E> implements TemplateLoader {

    /**
     * Load.
     */
    @Test
    @Override
    public void load() {
        Fixture.of(Cadastro.class).addTemplate("cadastro", new Rule() {
            {
                add("nome", name());
                add("email", regex("[a-z]{8}@gmail.com"));
                add("senha", regex("[a-zA-Z0-9]{5}"));
                add("cpf", GeraCpf.GeraCpf());
                add("rg", regex("[0-9]{1}.[0-9]{3}.[0-9]{3}-[0-9]{2}"));
            }
        });

        Fixture.of(Telefone.class).addTemplate("telefone", new Rule() {
            {
                add("ddd", random(DddsTelefone.values()[(new Random().nextInt(DddsTelefone.values().length))]));
                add("numero", regex("([0-9]{8})|([0-9]{9})"));
                add("ramal", regex("[0-9]{3}"));
                add("tipo", random(TipoTelefone.CELULAR, TipoTelefone.FIXO));
            }
        });

        Fixture.of(Endereco.class).addTemplate("endereco", new Rule() {
            {
                add("rua", name());
                add("bairro", random("Mascarenhas de Morais", "Sao Matheus", "Santa Adélia"));
                add("numero", new Random().nextInt(9999));
                add("regiao", random("Zona Leste", "Zona Sul", "Zona Norte", "Sudeste"));
                add("cep", regex("[0-9]{8}"));
                add("tipo", random(TipoEndereco.APARTAMENTO, TipoEndereco.CASA, TipoEndereco.CONDOMINIO, TipoEndereco.EMPRESARIAL));
            }
        });

        Fixture.of(Empresa.class).addTemplate("empresa", new Rule() {
            {
                add("cnpj", cnpj());
                add("nome", name());
                add("razaoSocial", regex("[a-z]{7} [a-z]{15}"));
                add("proprietarios", name());
                add("telefones", new HashSet<>());
                add("endereco", new HashSet<>());
            }
        });

        Fixture.of(Funcionario.class).addTemplate("funcionario", new Rule() {
            {
                add("nome", name());
                add("cargo", random("Atendente", "Tecnico", "Auxiliar"));
                add("codigo", random(Integer.class, range(100, 500)));
                add("salario", random(BigDecimal.class, range(1045, 5000)));
            }
        });

    }
}

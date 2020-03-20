package br.com.contmatic.empresa;

import static br.com.contmatic.constante.Constante.ENTRADA_INVALIDA;
import static br.com.contmatic.constante.Constante.ENTRADA_NULA;
import static br.com.contmatic.constante.ConstanteRegex.SOMENTE_ALFA;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.telefone.Telefone;

/**
 * The Class Empresa.
 */
public class Empresa {

    /** The cnpj. */

    @NotEmpty(message = ENTRADA_NULA)
    @CNPJ(message = "Cnpj Inválido")
    private String cnpj;

    /** The nome. */
    @NotBlank(message = ENTRADA_NULA)
    @NotEmpty(message = ENTRADA_NULA)
    @Pattern(regexp = SOMENTE_ALFA, message = ENTRADA_INVALIDA)
    private String nome;

    /** The razao social. */
    @NotNull(message = ENTRADA_NULA)
    @Length(min = 10, message = ENTRADA_INVALIDA)
    @Pattern(regexp = SOMENTE_ALFA, message = ENTRADA_INVALIDA)
    private String razaoSocial;

    /** The proprietarios. */
    @NotNull(message = ENTRADA_NULA)
    @NotBlank(message = ENTRADA_NULA)
    @Pattern(regexp = SOMENTE_ALFA, message = ENTRADA_INVALIDA)
    @Length(min = 2, max = 50, message = ENTRADA_INVALIDA)
    private String proprietarios;

    /** The telefones. */
    @NotNull(message = ENTRADA_NULA)
    private Set<Telefone> telefones;

    /** The endereco. */
    @NotNull(message = ENTRADA_NULA)
    private Set<Endereco> endereco;

    /**
     * Instantiates a new empresa.
     */
    public Empresa() {

    }

    /**
     * Instantiates a new empresa.
     *
     * @param cnpj the cnpj
     * @param nome the nome
     * @param razaoSocial the razao social
     * @param proprietarios the proprietarios
     * @param telefones the telefones
     * @param endereco the endereco
     */
    public Empresa(String cnpj, String nome, String razaoSocial, String proprietarios, Set<Telefone> telefones, Set<Endereco> endereco) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.proprietarios = proprietarios;
        this.telefones = telefones;
        this.endereco = endereco;
    }

    /**
     * Instantiates a new empresa.
     *
     * @param cnpj the cnpj
     * @param nome the nome
     * @param razaoSocial the razao social
     * @param proprietarios the proprietarios
     * @param telefones the telefones
     * @param endereco the endereco
     */
    public Empresa(String cnpj, String nome, String razaoSocial, String proprietarios, Telefone telefones, Endereco endereco) {
        this.telefones = new HashSet<>();
        this.endereco = new HashSet<>();
        this.cnpj = cnpj;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.proprietarios = proprietarios;
        this.telefones.add(telefones);
        this.endereco.add(endereco);
    }

    /**
     * Gets the cnpj.
     *
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Gets the razao social.
     *
     * @return the razao social
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * Gets the proprietarios.
     *
     * @return the proprietarios
     */
    public String getProprietarios() {
        return proprietarios;
    }

    /**
     * Gets the telefones.
     *
     * @return the telefones
     */
    public Set<Telefone> getTelefones() {
        return telefones;
    }

    /**
     * Gets the endereco.
     *
     * @return the endereco
     */
    public Set<Endereco> getEndereco() {
        return endereco;
    }

    /**
     * Sets the cnpj.
     *
     * @param cnpj the new cnpj
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Sets the nome.
     *
     * @param nome the new nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Sets the razao social.
     *
     * @param razaoSocial the new razao social
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * Sets the proprietarios.
     *
     * @param proprietarios the new proprietarios
     */
    public void setProprietarios(String proprietarios) {
        this.proprietarios = proprietarios;
    }

    /**
     * Sets the telefones.
     *
     * @param telefones the new telefones
     */
    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }

    /**
     * Sets the endereco.
     *
     * @param endereco the new endereco
     */
    public void setEndereco(Set<Endereco> endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(cnpj);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empresa other = (Empresa) obj;
        return new EqualsBuilder().append(cnpj, other.cnpj).isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }

}

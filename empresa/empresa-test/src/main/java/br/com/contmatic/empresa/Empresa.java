package br.com.contmatic.empresa;

import static br.com.contmatic.constante.Constante.ENTRADA_INVALIDA;
import static br.com.contmatic.constante.Constante.ENTRADA_NULA;
import static br.com.contmatic.constante.ConstanteRegex.SOMENTE_ALFA;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.telefone.Telefone;

/**
 * The Class Empresa.
 */
public class Empresa {

    /** The cnpj. */

    @NotBlank(message = ENTRADA_NULA)
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
    private Telefone telefones;

    /** The endereco. */
    @NotNull(message = ENTRADA_NULA)
    private Endereco endereco;


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
    public Telefone getTelefones() {
        return telefones;
    }

    /**
     * Gets the endereco.
     *
     * @return the endereco
     */
    public Endereco getEndereco() {
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
     * @param telefone the new telefones
     */
    public void setTelefones(Telefone telefone) {
        this.telefones = telefone;
    }

    /**
     * Sets the endereco.
     *
     * @param endereco the new endereco
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        return org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode(cnpj);
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
        return new org.apache.commons.lang3.builder.EqualsBuilder().append(cnpj, other.cnpj).isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }

}

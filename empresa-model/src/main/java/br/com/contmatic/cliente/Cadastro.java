package br.com.contmatic.cliente;

import static br.com.contmatic.constante.Constante.ENTRADA_INVALIDA;
import static br.com.contmatic.constante.Constante.ENTRADA_NULA;
import static br.com.contmatic.constante.Regex.EMAIL;
import static br.com.contmatic.constante.Regex.RG;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

/**
 * The Class Cliente.
 */
public class Cadastro {

    /** The nome. */
    @NotBlank(message = ENTRADA_NULA)
    @Length(min = 2, max = 50, message = "Quantidade de caracteres invalida")
    private String nome;

    /** The email. */
    @NotBlank(message = ENTRADA_NULA)
    @Email(message = ENTRADA_INVALIDA)
    @Pattern(regexp = EMAIL, message = ENTRADA_INVALIDA)
    private String email;

    /** The senha. */
    @NotEmpty(message = ENTRADA_NULA)
    private String senha;

    /** The cpf. */
    @NotEmpty(message = ENTRADA_NULA)
    @CPF(message = ENTRADA_INVALIDA)
    private String cpf;

    /** The rg. */
    @NotEmpty(message = ENTRADA_NULA)
    @Pattern(regexp = RG, message = "Rg Inválido")
    private String rg;

    /**
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {

        return nome;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the senha.
     *
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Gets the cpf.
     *
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Gets the rg.
     *
     * @return the rg
     */
    public String getRg() {
        return rg;
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
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the senha.
     *
     * @param senha the new senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Sets the cpf.
     *
     * @param cpf the new cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Sets the rg.
     *
     * @param rg the new rg
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(cpf);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Cadastro other = (Cadastro) obj;
        return new EqualsBuilder().append(cpf, other.cpf).isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
}

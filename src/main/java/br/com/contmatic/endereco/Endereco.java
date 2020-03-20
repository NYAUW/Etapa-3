package br.com.contmatic.endereco;

import static br.com.contmatic.constante.Constante.ENTRADA_INVALIDA;
import static br.com.contmatic.constante.Constante.ENTRADA_NULA;
import static br.com.contmatic.constante.ConstanteRegex.SOMENTE_ALFA;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;

/**
 * The Class Endereco.
 */
public class Endereco {

    /** The rua. */
    @NotBlank(message = ENTRADA_NULA)
    @Pattern(regexp = SOMENTE_ALFA, message = ENTRADA_INVALIDA)
    private String rua;

    /** The bairro. */
    @NotEmpty(message = ENTRADA_NULA)
    @Pattern(regexp = SOMENTE_ALFA, message = ENTRADA_INVALIDA)
    private String bairro;

    /** The numero. */
    @Min(value = 1)
    private int numero;

    /** The regiao. */
    @NotEmpty(message = ENTRADA_NULA)
    @Pattern(regexp = SOMENTE_ALFA, message = ENTRADA_INVALIDA)
    private String regiao;

    /** The cep. */
    @NotEmpty(message = ENTRADA_NULA)
    @NotBlank(message = ENTRADA_INVALIDA)
    @Length(max = 8, min = 8, message = ENTRADA_INVALIDA)
    @Pattern(regexp = "[0-9]{8}", message = ENTRADA_INVALIDA)
    private String cep;

    /** The tipo. */
    @NotNull(message = ENTRADA_NULA)
    private TipoEndereco tipo;

    /**
     * Instantiates a new endereco.
     */
    public Endereco() {
    }

    /**
     * Instantiates a new endereco.
     *
     * @param rua the rua
     * @param numero the numero
     * @param bairro the bairro
     * @param regiao the regiao
     * @param cep the cep
     * @param tipo the tipo
     */
    public Endereco(String rua, int numero, String bairro, String regiao, String cep, TipoEndereco tipo) {
        super();
        this.bairro = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.regiao = regiao;
        this.cep = cep;
        this.tipo = tipo;
    }

    /**
     * Gets the rua.
     *
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * Gets the numero.
     *
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Gets the bairro.
     *
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Gets the regiao.
     *
     * @return the regiao
     */
    public String getRegiao() {
        return regiao;
    }

    /**
     * Gets the cep.
     *
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public TipoEndereco getTipo() {
        return tipo;
    }

    /**
     * Sets the rua.
     *
     * @param rua the new rua
     */
    public void setRua(String rua) {
        this.bairro = rua;
    }

    /**
     * Sets the numero.
     *
     * @param numero the new numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Sets the bairro.
     *
     * @param bairro the new bairro
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Sets the regiao.
     *
     * @param regiao the new regiao
     */
    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    /**
     * Sets the cep.
     *
     * @param cep the new cep
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Sets the tipo.
     *
     * @param tipo the new tipo
     */
    public void setTipo(TipoEndereco tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }

}

package br.com.contmatic.telefone;

import static br.com.contmatic.constante.Constante.ENTRADA_INVALIDA;
import static br.com.contmatic.constante.Constante.ENTRADA_NULA;
import static br.com.contmatic.constante.ConstanteRegex.NUMERO_TELEFONE;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The Class Telefone.
 */
public class Telefone {

    @NotNull(message = ENTRADA_NULA)
    private DddsTelefone ddd;

    /** The numero. */
    @NotEmpty(message = ENTRADA_NULA)
    @Pattern(regexp = NUMERO_TELEFONE, message = "Numero Inválido")
    private String numero;

    /** The ramal. */
    @NotEmpty(message = ENTRADA_NULA)
    @Pattern(regexp = "^[0-9]{3}$*", message = ENTRADA_INVALIDA)
    private String ramal;

    /** The tipo. */
    @NotNull(message = ENTRADA_NULA)
    private TipoTelefone tipo;

    /**
     * Instantiates a new telefone.
     */
    public Telefone() {

    }

    /**
     * Instantiates a new telefone.
     *
     * @param numero the numero
     * @param ramal the ramal
     * @param tipo the tipo
     */
    public Telefone(DddsTelefone ddd, String numero, String ramal, TipoTelefone tipo) {
        this.ddd = ddd;
        this.numero = numero;
        this.ramal = ramal;
        this.tipo = tipo;
    }

    public DddsTelefone getDdd() {
        return ddd;
    }

    /**
     * Gets the numero.
     *
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Gets the ramal.
     *
     * @return the ramal
     */
    public String getRamal() {
        return ramal;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public TipoTelefone getTipo() {
        return tipo;
    }

    public void setDdd(DddsTelefone ddd) {
        this.ddd = ddd;
    }

    /**
     * Sets the numero.
     *
     * @param numero the new numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Sets the ramal.
     *
     * @param ramal the new ramal
     */
    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    /**
     * Sets the tipo.
     *
     * @param tipo the new tipo
     */
    public void setTipo(TipoTelefone tipo) {
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

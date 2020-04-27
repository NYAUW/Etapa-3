package br.com.contmatic.empresa;

import static br.com.contmatic.constante.Constante.ENTRADA_INVALIDA;
import static br.com.contmatic.constante.Constante.ENTRADA_NULA;
import static br.com.contmatic.constante.ConstanteRegex.SOMENTE_ALFA;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;

/**
 * The Class Funcionario.
 */
public class Funcionario {

    /** The nome. */
    @NotNull(message = ENTRADA_NULA)
    @NotBlank(message = ENTRADA_INVALIDA)
    @Pattern(regexp = SOMENTE_ALFA, message = ENTRADA_INVALIDA)
    @Length(min = 2, max = 50, message = ENTRADA_INVALIDA)
    private String nome;

    /** The cargo. */
    @NotEmpty(message = ENTRADA_NULA)
    @Pattern(regexp = SOMENTE_ALFA, message = ENTRADA_INVALIDA)
    private String cargo;

    /** The codigo. */
    @NotNull(message = ENTRADA_NULA)
    @Min(value = 1)
    @Max(value = 9999)
    private int codigo;

    /** The salario. */
    @NotNull(message = ENTRADA_NULA)
    private BigDecimal salario;

    /**
     * Instantiates a new funcionario.
     *
     * @param nome the nome
     * @param cargo the cargo
     * @param codigo the codigo
     * @param salario the salario
     */
    public Funcionario(String nome, String cargo, int codigo, BigDecimal salario) {
        super();
        this.nome = nome;
        this.cargo = cargo;
        this.codigo = codigo;
        this.salario = salario;
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
     * Gets the cargo.
     *
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Gets the codigo.
     *
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Gets the salario.
     *
     * @return the salario
     */
    public BigDecimal getSalario() {
        return salario;
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
     * Sets the cargo.
     *
     * @param cargo the new cargo
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Sets the codigo.
     *
     * @param codigo the new codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Sets the salario.
     *
     * @param salario the new salario
     */
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    /**
     * Hash code.
     *
     * @return the int
     */

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(codigo);
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
        Funcionario other = (Funcionario) obj;
        return new EqualsBuilder().append(codigo, other.codigo).isEquals();
    }
}

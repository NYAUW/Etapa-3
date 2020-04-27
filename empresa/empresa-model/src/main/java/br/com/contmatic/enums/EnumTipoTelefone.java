package br.com.contmatic.enums;

/**
 * The Enum TipoTelefone.
 */
public enum EnumTipoTelefone {

                          /** The fixo. */
                          FIXO("Fixo"),

                          /** The celular. */
                          CELULAR("Celular");

    /** The tipo. */
    private String tipo;

    /**
     * Instantiates a new tipo telefone.
     *
     * @param tipo the tipo
     */
    private EnumTipoTelefone(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}

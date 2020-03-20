package br.com.contmatic.telefone;

/**
 * The Enum TipoTelefone.
 */
public enum TipoTelefone {

                          /** The fixo. */
                          FIXO("Fixo"),

                          /** The celular. */
                          CELULAR("Celular");

    /** The tipo. */
    String tipo;

    /**
     * Instantiates a new tipo telefone.
     *
     * @param tipo the tipo
     */
    private TipoTelefone(String tipo) {
        this.tipo = tipo;
    }
}

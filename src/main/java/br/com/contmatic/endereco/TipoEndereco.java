package br.com.contmatic.endereco;

/**
 * The Enum TipoEndereco.
 */
public enum TipoEndereco {

                          /** The casa. */
                          CASA("Casa"),

                          /** The apartamento. */
                          APARTAMENTO("Apartamento"),

                          /** The condominio. */
                          CONDOMINIO("Condominio"),

                          /** The empresarial. */
                          EMPRESARIAL("Empresarial");

    /** The tipo. */
    String tipo;

    /**
     * Instantiates a new tipo endereco.
     *
     * @param tipo the tipo
     */
    private TipoEndereco(String tipo) {
        this.tipo = tipo;
    }
}

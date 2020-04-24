package br.com.contmatic.enums;

/**
 * The Enum TipoEndereco.
 */
public enum EnumTipoEndereco {

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
    private EnumTipoEndereco(String tipo) {
        this.tipo = tipo;
    }
}

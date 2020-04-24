package br.com.contmatic.constante;

public final class ConstanteRegex {
    public static final String EMAIL = "^[_a-z0-9-\\+]+(\\.[_a-z0-9-]+)*@" + "[a-z]{1,10}+(\\.[a-z]{1,5}+)*(\\.[a-z]{2,})$";

    public static final String SOMENTE_ALFA = "^[a-zA-Z a-zA-Z.áàâãéèêíïóôõöúçñ]*$";

    /** The Constant SOMENTE_NUMEROS. */
    public static final String SOMENTE_NUMEROS = "^[0-9]$*";

    /** The Constant RG. */
    public static final String RG = "[0-9]{1}.[0-9]{3}.[0-9]{3}-[0-9]{2}";

    /** The Constant SERIAL. */
    public static final String SERIAL = "[A-Z]{3}[0-9]{3}";

    /** The Constant NUMERO_TEEFONE. */
    public static final String NUMERO_TELEFONE = "([0-9]{8}|[0-9]{9})";

    /** The Constant RAMAL. */
    public static final String RAMAL = ("[0-9]{3}");

    private ConstanteRegex() {

    }
}

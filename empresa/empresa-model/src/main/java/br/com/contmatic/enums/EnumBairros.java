package br.com.contmatic.enums;

public enum EnumBairros {
                         SAPOPEMBA("Sapopemba"),
                         SAO_MATEUS("São Mateus"),
                         SAO_LUIS("São Luis"),
                         SANTA_CECILIA("Santa Cecília"),
                         SANTO_ANDRE("Santo André");

    private String bairro;

    private EnumBairros(String bairro) {
        this.bairro = bairro;
    }
//Teste
    public String getBairro() {
        return bairro;
    }  
}

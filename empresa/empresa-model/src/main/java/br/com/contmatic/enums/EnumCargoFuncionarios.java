package br.com.contmatic.enums;

public enum EnumCargoFuncionarios {
    ATENDENTE("Atendente"),
    TECNICO("Técnico"),
    AUXILIAR("Auxiliar");
    
    String cargo;

    private EnumCargoFuncionarios(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }     
}

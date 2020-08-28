package net.projetoreviver.sgp.models;

public enum EstadoCivil {
    SOLTEIRO("Solteiro(a)"),
    CASADO("Casado(a)"),
    DIVORCIADO("Divorciado(a)"),
    VIÚVO("Viúvo(a)");

    private final String displayValue;

    private EstadoCivil(String displayValue){
        this.displayValue = displayValue;
    }

    private String getDisplayValue(){
        return displayValue;
    }
}
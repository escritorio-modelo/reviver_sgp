package net.projetoreviver.sgp.models;

public enum StatusChamada {
    ABERTA("Aberta"),
    EMANDAMENTO("Em andamento"),
    FECHADO("Fechado");

    private final String displayValue;

    private StatusChamada(String displayValue){
        this.displayValue = displayValue;
    }

    public String getDisplayValue(){
        return displayValue;
    } 
}

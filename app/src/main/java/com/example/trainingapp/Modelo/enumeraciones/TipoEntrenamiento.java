package com.example.trainingapp.Modelo.enumeraciones;

public enum TipoEntrenamiento {
    NONE("No válido"),
    OBLIGATORIO("Obligatorio"),
    OPTATIVO("Optativo");

    private String nombre;
    private TipoEntrenamiento(String nombre){
        this.nombre = nombre;

    }
}

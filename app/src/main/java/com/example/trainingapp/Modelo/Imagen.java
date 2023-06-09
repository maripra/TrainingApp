package com.example.trainingapp.Modelo;

public class Imagen {

    //Propiedades
    private String id;
    private String Titulo;
    private String ImagenURL;

    //Constructores
    public Imagen(String id, String titulo, String imagenURL) {
        this.id = id;
        this.Titulo = titulo;
        this.ImagenURL = imagenURL;
    }

    public Imagen() {
    }

    //Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        this.Titulo = titulo;
    }

    public String getRuta() {
        return ImagenURL;
    }

    public void setRuta(String ruta) {
        this.ImagenURL = ruta;
    }
}

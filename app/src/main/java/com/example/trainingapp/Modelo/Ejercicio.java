package com.example.trainingapp.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio {

    //Propiedades
    private String id;
    private String titulo;
    private int series;
    private int duracionSeg;
    private int repeticiones;
    private List<String> imagenesId = new ArrayList<>();


    //Contructor
    public Ejercicio(String id, String titulo, int series, int duracionSeg, int repeticiones, List<String> imagenesId) {
        this.id = id;
        this.titulo = titulo;
        this.series = series;
        this.duracionSeg = duracionSeg;
        this.repeticiones = repeticiones;
        this.imagenesId = imagenesId;

    }

    //Constructor por defecto
    public Ejercicio() {}


    @Override
    public String toString() {
        return "Ejercicio{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", series=" + series +
                ", duracionSeg=" + duracionSeg +
                ", repeticiones=" + repeticiones +
                ", imagenesId=" + imagenesId +
                '}';
    }

    //Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getDuracionSeg() {
        return duracionSeg;
    }

    public void setDuracionSeg(int duracionSeg) {
        this.duracionSeg = duracionSeg;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public List<String> getImagenesId() {
        return imagenesId;
    }

    public void setImagenesId(List<String> imagenesId) {
        this.imagenesId = imagenesId;
    }


}

package com.example.trainingapp.Modelo;

import com.google.firebase.Timestamp;

import java.util.ArrayList;
import java.util.List;

public class Entrenamiento {

    //Propiedades
    private String id;
    private String Titulo;
    private Timestamp Fecha;
    private String youtubeURL;
    private String pdfURL;
    private List<String> ejerciciosId = new ArrayList<>();


    public Entrenamiento(String id, String titulo, Timestamp fecha,String youtubeURL, String pdfURL, List<String> ejerciciosId) {
        this.id = id;
        this.Titulo = titulo;
        this.Fecha = fecha;
        this.youtubeURL = youtubeURL;
        this.pdfURL = pdfURL;
        this.ejerciciosId = ejerciciosId;
    }

    public Entrenamiento() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public List<String> getEjerciciosId() {
        return ejerciciosId;
    }

    public void setEjerciciosId(List<String> ejerciciosId) {
        this.ejerciciosId = ejerciciosId;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getYoutubeURL() {
        return youtubeURL;
    }

    public void setYoutubeURL(String youtubeURL) {
        this.youtubeURL = youtubeURL;
    }

    public String getPdfURL() {
        return pdfURL;
    }

    public void setPdfURL(String pdfURL) {
        this.pdfURL = pdfURL;
    }

    public Timestamp getFecha() {
        return Fecha;
    }

    public void setFecha(Timestamp fecha) {
        Fecha = fecha;
    }
}

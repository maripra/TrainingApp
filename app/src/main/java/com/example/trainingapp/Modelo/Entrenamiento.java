package com.example.trainingapp.Modelo;


import com.google.firebase.Timestamp;


public class Entrenamiento {

        private  String TrainingURL;
        private Timestamp fecha;

        private String descripcion;



    public Entrenamiento(String trainingURL, Timestamp fecha, String descripcion) {
        this.TrainingURL = trainingURL;
        this.fecha = fecha;
        this.descripcion= descripcion;
    }
    public Entrenamiento(){

    }

    public  String getTrainingURL() {
        return TrainingURL;
    }

    public void setTrainingURL(String trainingURL) {
        TrainingURL = trainingURL;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}



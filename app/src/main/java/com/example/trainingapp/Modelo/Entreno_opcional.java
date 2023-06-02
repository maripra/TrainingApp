package com.example.trainingapp.Modelo;

import com.google.firebase.Timestamp;

public class Entreno_opcional {

    private  String TrainingURL;
    private Timestamp fecha;



    public Entreno_opcional(String trainingURL, Timestamp fecha) {
        TrainingURL = trainingURL;
        this.fecha = fecha;

    }

   public Entreno_opcional()
   {

   }

    public String getTrainingURL() {
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




}

package com.example.trainingapp.Modelo;


public class ModelIdioma {

    private String id;
    private String countryCode;
    private String description;



    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ModelIdioma(String id, String countryCode, String description){
        this.id= id;
        this.countryCode=countryCode;
        this.description=description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

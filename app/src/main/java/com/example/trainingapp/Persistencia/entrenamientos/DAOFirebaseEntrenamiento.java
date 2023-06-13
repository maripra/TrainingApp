package com.example.trainingapp.Persistencia.entrenamientos;

import com.example.trainingapp.Modelo.Entrenamiento;

import java.util.List;

public class DAOFirebaseEntrenamiento extends  IDAOEntrenamiento{


    public DAOFirebaseEntrenamiento() {
    }

    @Override
    public Entrenamiento getById(String id) {
        return null;
    }

    @Override
    public List<Entrenamiento> getAll() {
        return null;
    }

    @Override
    public boolean update(Entrenamiento model) {
        return false;
    }

    @Override
    public boolean delete(Entrenamiento model) {
        return false;
    }

    @Override
    public boolean add(Entrenamiento model) {
        return false;
    }

    @Override
    public List<Entrenamiento> getEntrenamientosByUsuarioId(String userId) {
        return null;
    }

    @Override
    public List<Entrenamiento> getEntrenamientosDeHoyByUsuarioId(String userId) {
        return null;
    }
}

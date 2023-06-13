package com.example.trainingapp.Persistencia.entrenamientos;

import com.example.trainingapp.Modelo.Entrenamiento;
import com.example.trainingapp.Persistencia.contexto.AppConfig;
import com.example.trainingapp.Persistencia.contexto.IDAOBase;
import com.example.trainingapp.Persistencia.contexto.ModoPersistencia;

import java.util.List;

public abstract class IDAOEntrenamiento implements IDAOBase<Entrenamiento> {
    public static IDAOEntrenamiento getInstance()
    {
        if (AppConfig.Modo == ModoPersistencia.MEMORIA)
        {
            return new DAOMemoryEntrenamiento();
        }
        if (AppConfig.Modo == ModoPersistencia.FIREBASE)
        {
            return new DAOFirebaseEntrenamiento();
        }
        return null;
    }


    public abstract List<Entrenamiento> getEntrenamientosByUsuarioId(String userId );
    public abstract List<Entrenamiento> getEntrenamientosDeHoyByUsuarioId(String userId );

}

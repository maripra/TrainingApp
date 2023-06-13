package com.example.trainingapp.Persistencia.ejercicios;

import com.example.trainingapp.Modelo.Ejercicio;
import com.example.trainingapp.Persistencia.contexto.AppConfig;
import com.example.trainingapp.Persistencia.contexto.IDAOBase;
import com.example.trainingapp.Persistencia.contexto.ModoPersistencia;

public abstract class IDAOEjercicio implements IDAOBase<Ejercicio> {
    public static IDAOEjercicio getInstance()
    {

        if (AppConfig.Modo == ModoPersistencia.MEMORIA)
        {
            return new DAOMemoryEjercicio();
        }
        if (AppConfig.Modo == ModoPersistencia.FIREBASE)
        {
            return new DAOFirebaseEjercicio();
        }
        return null;
    }

}

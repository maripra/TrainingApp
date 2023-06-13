package com.example.trainingapp.Persistencia.imagenes;

import com.example.trainingapp.Modelo.Imagen;
import com.example.trainingapp.Persistencia.contexto.AppConfig;
import com.example.trainingapp.Persistencia.contexto.IDAOBase;
import com.example.trainingapp.Persistencia.contexto.ModoPersistencia;

public abstract class IDAOImagen implements IDAOBase<Imagen> {
    public static IDAOImagen getInstance()
    {
        if (AppConfig.Modo == ModoPersistencia.MEMORIA)
        {
            return new DAOMemoryImagen();
        }
        if (AppConfig.Modo == ModoPersistencia.FIREBASE)
        {
            return new DAOFirebaseImagen();
        }
        return null;
    }
}

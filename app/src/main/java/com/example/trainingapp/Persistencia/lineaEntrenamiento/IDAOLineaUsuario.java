package com.example.trainingapp.Persistencia.lineaEntrenamiento;

import com.example.trainingapp.Modelo.LineaUsuario;
import com.example.trainingapp.Persistencia.contexto.AppConfig;
import com.example.trainingapp.Persistencia.contexto.IDAOBase;
import com.example.trainingapp.Persistencia.contexto.ModoPersistencia;

import java.util.List;

public abstract class IDAOLineaUsuario implements IDAOBase<LineaUsuario> {

    public static IDAOLineaUsuario getInstance()
    {
        if (AppConfig.Modo == ModoPersistencia.MEMORIA)
        {
            return new DAOMemoryLineaUsuario();
        }
        if (AppConfig.Modo == ModoPersistencia.FIREBASE)
        {
            return new DAOFirebaseLineaUsuario();
        }
        return null;
    }

    public abstract List<LineaUsuario> getByUsuarioId(String userId );


}
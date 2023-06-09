package com.example.trainingapp.Persistencia.usuarios;

import com.google.android.gms.tasks.Task;
import com.example.trainingapp.Modelo.Usuario;
import com.example.trainingapp.Persistencia.contexto.AppConfig;
import com.example.trainingapp.Persistencia.contexto.IDAOBase;
import com.example.trainingapp.Persistencia.contexto.ModoPersistencia;

public abstract class IDAOUsuario implements IDAOBase<Usuario>{

    public static IDAOUsuario getInstance()
    {
        if (AppConfig.Modo == ModoPersistencia.MEMORIA)
        {
            return new DAOMemoryUsuario();
        }
        if (AppConfig.Modo == ModoPersistencia.FIREBASE)
        {
            return new DAOFirebaseUsuario();
        }
        return null;
    }
    public abstract Task<Usuario> getUserByEmail(String email);
}


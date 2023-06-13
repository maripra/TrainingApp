package com.example.trainingapp.Persistencia.imagenes;

import com.example.trainingapp.Modelo.Imagen;
import com.example.trainingapp.Persistencia.contexto.DataMemory;

import java.util.List;

public class DAOMemoryImagen extends IDAOImagen{

    private DataMemory context;
    public DAOMemoryImagen() {
        this.context =DataMemory.getInstance();
    }


    @Override
    public Imagen getById(String id) {
        Imagen result = null;
        for (Imagen imagen : context.Imagenes) {
            if (imagen.getId().equals(id)) {
                result = imagen;
            }
        }
        return result;
    }

    @Override
    public List<Imagen> getAll() {
        return null;
    }

    @Override
    public boolean update(Imagen model) {
        return false;
    }

    @Override
    public boolean delete(Imagen model) {
        return false;
    }

    @Override
    public boolean add(Imagen model) {
        return false;
    }
}


package com.example.trainingapp.Persistencia.lineaEntrenamiento;

import com.example.trainingapp.Modelo.LineaUsuario;
import com.example.trainingapp.Persistencia.contexto.DataMemory;

import java.util.ArrayList;
import java.util.List;

public class DAOMemoryLineaUsuario extends IDAOLineaUsuario {

    private DataMemory context;
    public DAOMemoryLineaUsuario() {
        this.context =DataMemory.getInstance();
    }

    @Override
    public LineaUsuario getById(String id) {
        LineaUsuario result = null;
        for (LineaUsuario lineaUsuario : context.LineasUsuario) {
            if (lineaUsuario.getUsuarioId().equals(id)) {
                result = lineaUsuario;
            }
        }
        return result;
    }

    @Override
    public List<LineaUsuario> getAll() {
        return null;
    }

    @Override
    public boolean update(LineaUsuario model) {
        return false;
    }

    @Override
    public boolean delete(LineaUsuario model) {
        return false;
    }

    @Override
    public boolean add(LineaUsuario model) {
        return false;
    }

    @Override
    public List<LineaUsuario> getByUsuarioId(String userId) {
        List<LineaUsuario> result = new ArrayList<>();

        for (LineaUsuario linea: context.LineasUsuario) {

            if(linea.getUsuarioId().equals(userId)){
                result.add(linea);
            }
        }
        return result;

    }
}


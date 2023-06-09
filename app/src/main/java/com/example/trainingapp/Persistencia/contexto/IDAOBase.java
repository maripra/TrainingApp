package com.example.trainingapp.Persistencia.contexto;

import java.util.List;

//Interfaz que obliga a que todas las implementaciones concretas contengan las operación CRUD (Create,Read,Update,Delete)

public interface IDAOBase<T> {
    T getById(String id);
    List<T> getAll();
    boolean update(T model);
    boolean delete(T model);
    boolean add(T model);

}

package com.example.trainingapp.Modelo;

public class Usuario {
    //Propiedades
    private String id;
    private String Email;
    private String Contrasena;
    private String Nombre;
    private String Apellido;
    private String telefono;
    private String Genero;

    //Constructor
    public Usuario (String id, String Email, String Contrasena, String Nombre, String Apellido, String telefono, String Genero){
        this.id = id;
        this.Email= Email;
        this.Contrasena = Contrasena;
        this.Nombre= Nombre;
        this.Apellido = Apellido;
        this.Genero = Genero;
        this.telefono = telefono;
    }
    public Usuario() {}

    //Métodos
    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", Email='" + Email + '\'' +
                ", Contrasena='" + Contrasena + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", teléfono='" + telefono + '\'' +
                ", Genero='" + Genero + '\''+
                '}';
    }
    //Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        telefono = telefono;
    }
}

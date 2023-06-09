package com.example.trainingapp.Modelo;

import com.google.firebase.Timestamp;
import com.example.trainingapp.Modelo.enumeraciones.TipoEntrenamiento;

public class LineaUsuario {

    private String id;
    private String usuarioId;
    private String nombreEntrenamiento;
    private int duracionTotalAproxMin;
    private Timestamp fechaInicio;
    private boolean completado;
    private TipoEntrenamiento tipoEntrenamiento = TipoEntrenamiento.OBLIGATORIO;


    public LineaUsuario(String id, String usuarioId, String nombreEntrenamiento, int duracionTotalAproxMin, Timestamp fechaInicio, boolean completado, TipoEntrenamiento tipoEntrenamiento) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nombreEntrenamiento = nombreEntrenamiento;
        this.duracionTotalAproxMin = duracionTotalAproxMin;
        this.fechaInicio = fechaInicio;
        this.completado = completado;
        this.tipoEntrenamiento = tipoEntrenamiento;
    }

    public LineaUsuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getDuracionTotalAproxMin() {
        return duracionTotalAproxMin;
    }

    public void setDuracionTotalAproxMin(int duracionTotalAproxMin) {
        this.duracionTotalAproxMin = duracionTotalAproxMin;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public TipoEntrenamiento getTipoEntrenamiento() {
        return tipoEntrenamiento;
    }

    public void setTipoEntrenamiento(TipoEntrenamiento tipoEntrenamiento) {
        this.tipoEntrenamiento = tipoEntrenamiento;
    }

    public String getNombreEntrenamiento() {
        return nombreEntrenamiento;
    }

    public void setNombreEntrenamiento(String nombreEntrenamiento) {
        this.nombreEntrenamiento = nombreEntrenamiento;
    }
}

package com.example.trainingapp.Adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.example.trainingapp.Modelo.Historial;

public class Historial_Adapter extends ArrayAdapter<Historial> {


    public Historial_Adapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}

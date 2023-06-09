package com.example.trainingapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.trainingapp.Modelo.Ejercicio;
import com.example.trainingapp.Modelo.Entrenamiento;
import com.example.trainingapp.Modelo.ModelIdioma;
import com.example.trainingapp.R;

import java.util.List;

public class DashboardListviewAdapter extends BaseAdapter {


    private Context _context;
    private final List<Ejercicio> _items;


    public DashboardListviewAdapter(Context context, List<Ejercicio> items) {
        _context = context;
        _items = items;
    }

    @Override
    public int getCount(){
        return _items.size();
    }
    //devuelve el elemeneto en la posicion especificada
    @Override
    public Object getItem(int position){
        Ejercicio ejercicio = _items.get(position);
        return ejercicio;
    }
    //devuelve la posicion del elemento
    @Override
    public long getItemId(int position){
        return position;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(_context);
            view = inflater.inflate(R.layout.adapter_listview_dashboard, viewGroup, false);
        }
        Ejercicio ejercicio = _items.get(i);
        view.setTag(ejercicio);

        TextView Nombrelbl = view.findViewById(R.id.lblNombre);
        Nombrelbl.setText(ejercicio.getTitulo());


        return view;
    }
}

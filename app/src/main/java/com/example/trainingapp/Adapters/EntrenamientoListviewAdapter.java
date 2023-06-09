package com.example.trainingapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;


import com.example.trainingapp.Modelo.LineaUsuario;
import com.example.trainingapp.R;

import java.util.List;

public class EntrenamientoListviewAdapter extends BaseAdapter {
    private Context _context;
    private final List<LineaUsuario> _items;


    public EntrenamientoListviewAdapter(Context context, List<LineaUsuario> items) {
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
        LineaUsuario lineaUsuario = _items.get(position);
        return lineaUsuario;
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
            view = inflater.inflate(R.layout.adapter_listview_entrenamientos, viewGroup, false);
        }
        /*LineaUsuario lineaUsuario = _items.get(i);
        view.setTag(lineaUsuario);*/
        CheckBox incompletadoCheckBox = view.findViewById(R.id.incompletadoCheckbox);

        // Obtener el objeto LineaUsuario correspondiente a esta posición
        LineaUsuario lineaUsuario = _items.get(i);

        // Establecer el estado de marcado del checkbox
        incompletadoCheckBox.setChecked(lineaUsuario.isCompletado());

        return view;
    }
}

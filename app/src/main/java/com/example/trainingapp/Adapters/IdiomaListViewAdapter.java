package com.example.trainingapp.Adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

//import com.example.trainingapp.Persistencia.usuarios.contexto.AppConfig;
import com.example.trainingapp.Persistencia.contexto.AppConfig;
import com.example.trainingapp.MainActivity;
import com.example.trainingapp.Modelo.ModelIdioma;
import com.example.trainingapp.R;

import java.util.List;
import java.util.Locale;

public class IdiomaListViewAdapter extends BaseAdapter {
    private Context _context;
    private final List<ModelIdioma> _items;

    public IdiomaListViewAdapter(@NonNull Context context, @NonNull List<ModelIdioma>items){
        _items=items;
        _context=context;
    }
    //El metodo getCount devuelve el numero de elementos en la lista
    @Override
    public int getCount(){
        return _items.size();
    }
    //devuelve el elemeneto en la posicion especificada
    @Override
    public Object getItem(int position){
        ModelIdioma idioma = _items.get(position);
        return idioma;
    }
    //devuelve la posicion del elemento
    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(_context);
            convertView = inflater.inflate(R.layout.adapter_listview_idioma, parent, false);
        }

        ModelIdioma idioma = _items.get(position);
        convertView.setTag(idioma);

        TextView lblText = convertView.findViewById(R.id.lblText);
        lblText.setText(idioma.getDescription());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    ModelIdioma idioma = ((ModelIdioma) view.getTag());
                    //INICIA LA APP EN ESPAÑOL (AppConfig)
                    AppConfig.IDIOMA_ACTUAL = idioma.getCountryCode();

                    MainActivity mainActivity = (MainActivity) _context;

                    Configuration config = mainActivity.getBaseContext().getResources().getConfiguration();
                    if(!"".equals(AppConfig.IDIOMA_ACTUAL) && !config.locale.getLanguage().equals(AppConfig.IDIOMA_ACTUAL)){
                        mainActivity.recreate();
                        Locale locale = new Locale(AppConfig.IDIOMA_ACTUAL);
                        Locale.setDefault(locale);
                        config.locale=locale;
                        mainActivity.getBaseContext().getResources().updateConfiguration(config, mainActivity.getBaseContext().getResources().getDisplayMetrics());
                        mainActivity.recreate();
                        Log.d("CLICK: ", idioma.getDescription());
                        Toast.makeText(mainActivity, idioma.getDescription(), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(mainActivity, "El lenguaje seleccionado ya está en uso", Toast.LENGTH_SHORT).show();
                    }

            }
        });
        return convertView;
    }
}

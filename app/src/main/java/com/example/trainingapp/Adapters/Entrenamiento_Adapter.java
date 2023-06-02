package com.example.trainingapp.Adapters;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.trainingapp.CrearEntreno;
import com.example.trainingapp.Modelo.Entrenamiento;
import com.example.trainingapp.R;

import java.util.List;




public class Entrenamiento_Adapter extends ArrayAdapter<Entrenamiento>{

        private Context mContext;
        private int mResource;


        public Entrenamiento_Adapter(Context context, int resource, List<Entrenamiento> objects) {
            super(context, resource, objects);
            mContext = context;
            mResource = resource;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View view, @NonNull ViewGroup viewGroup) {

            if (view == null) {
                LayoutInflater inflater = LayoutInflater.from(mContext);
                view = inflater.inflate(R.layout.activity_lista_entrenamientos,viewGroup, false);
            }

            Entrenamiento entreno = getItem(position);


            TextView textViewDate = view.findViewById(R.id.Opcional_date_textview);
            TextView textViewdes = view.findViewById(R.id.training_Descripción);
            Button textViewPdf = view.findViewById(R.id.training_file_button);
            Button btn_create= view.findViewById(R.id.btn_add);
            Button btn_delete = view.findViewById(R.id.btn_delete);

            textViewPdf.setText(entreno.getTrainingURL());
            textViewdes.setText(entreno.getDescripcion());
            textViewDate.setText(entreno.getFecha().toString());


           /* btn_create.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Entrenamiento_Adapter.this, CrearEntreno.class));
                }

            });*/




            return view;
        }

}


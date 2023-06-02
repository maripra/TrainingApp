package com.example.trainingapp.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.trainingapp.Modelo.Entreno_opcional;
import com.example.trainingapp.R;

import com.google.firebase.Timestamp;
import java.util.Date;
import java.util.List;

public class EntrenoOpcional_Adapter extends ArrayAdapter<Entreno_opcional> {

    private Context mContext;
    private int mResource;

    public EntrenoOpcional_Adapter(Context context, int resource, List<Entreno_opcional> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(mResource, parent, false);
        }

        Entreno_opcional opcional = getItem(position);


        TextView textViewDate = view.findViewById(R.id.Opcional_date_textview);
        Button textViewPdf = view.findViewById(R.id.button_entreno_option);

        textViewPdf.setText(opcional.getTrainingURL());
        textViewDate.setText(opcional.getFecha().toString());


        return view;
    }



}
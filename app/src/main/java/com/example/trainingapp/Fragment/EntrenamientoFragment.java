package com.example.trainingapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.trainingapp.Adapters.Entrenamiento_Adapter;
import com.example.trainingapp.Modelo.Entrenamiento;
import com.example.trainingapp.R;



public class EntrenamientoFragment extends Fragment {

   private ListView listView;
   private ImageView training_photo;
   private TextView training_date;
   private TextView opcional_date_textview;
   private TextView training_descripcion;
   private Button training_file_button;
   private Button button_add;
   private Button button_delete;
   private ImageButton boton_resultados;

   private Entrenamiento_Adapter _adapter;
   private Entrenamiento _entreno;

    public EntrenamientoFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static EntrenamientoFragment newInstance(String param1, String param2) {
        EntrenamientoFragment fragment = new EntrenamientoFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_entrenamiento, container, false);
    }
}
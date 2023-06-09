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

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

//import com.example.trainingapp.Adapters.Entrenamiento_Adapter;
import com.example.trainingapp.Modelo.Entrenamiento;
import com.example.trainingapp.Modelo.LineaUsuario;
import com.example.trainingapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class EntrenamientoFragment extends Fragment {



  // private Entrenamiento_Adapter _adapter;
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
    /*public void getAll() {

        FirebaseFirestore db;
        CollectionReference lineaUsuarioCollecion;
        db = FirebaseFirestore.getInstance();
        lineaUsuarioCollecion = db.collection("linea usuario");
        List<LineaUsuario> lineaUsuarios = new ArrayList<>();
        lineaUsuarioCollecion.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {

                            LineaUsuario linea_usuario = new LineaUsuario();
                            linea_usuario.setUsuarioId(document.getString("UserID"));
                            lineaUsuarios.add(linea_usuario);

                    }
                }
            }
        });
    }*/
}
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
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


import com.example.trainingapp.Adapters.EntrenamientoListviewAdapter;

import com.example.trainingapp.Modelo.LineaUsuario;
import com.example.trainingapp.Modelo.enumeraciones.TipoEntrenamiento;
import com.example.trainingapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class EntrenamientoFragment extends Fragment {


    private List<LineaUsuario>_lineaUsuarios= new ArrayList<>();
   private EntrenamientoListviewAdapter _adapter;
    private View _view;
    private FragmentActivity _context;
    private ListView _listView;

    public EntrenamientoFragment() {
        // Required empty public constructor
    }



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
        _view = inflater.inflate(R.layout.fragment_entrenamiento, container, false);

        return _view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        _context = getActivity();
        _listView = (ListView) _view.findViewById(R.id.listViewLineaUsuario);



        // Crea la lista de LineaUsuario
        List<LineaUsuario> lineaUsuarios = new ArrayList<>();
        lineaUsuarios.add(new LineaUsuario("1", "1","Cirucito", 45, Timestamp.now(), true, TipoEntrenamiento.OBLIGATORIO));
        lineaUsuarios.add(new LineaUsuario("2", "1","Tabata", 20, Timestamp.now(), true, TipoEntrenamiento.OBLIGATORIO));
        lineaUsuarios.add(new LineaUsuario("3", "1","GAP", 50, Timestamp.now(), true, TipoEntrenamiento.OBLIGATORIO));
        lineaUsuarios.add(new LineaUsuario("4", "1","CORE", 30, Timestamp.now(), true, TipoEntrenamiento.OBLIGATORIO));
        lineaUsuarios.add(new LineaUsuario("5", "1","Tonificación", 40, Timestamp.now(), false, TipoEntrenamiento.OBLIGATORIO));
        lineaUsuarios.add(new LineaUsuario("6", "1","Carrera", 60, Timestamp.now(), false, TipoEntrenamiento.OBLIGATORIO));
        lineaUsuarios.add(new LineaUsuario("7", "1","Full Body", 50, Timestamp.now(), false, TipoEntrenamiento.OBLIGATORIO));
        lineaUsuarios.add(new LineaUsuario("8", "1","YOGA", 24, Timestamp.now(), false, TipoEntrenamiento.OBLIGATORIO));

        //getAll();
        List<LineaUsuario> lineaUsuariosCompletados = new ArrayList<>();
        for (LineaUsuario lineaUsuario : lineaUsuarios) {
            if (!lineaUsuario.isCompletado()) {
                lineaUsuariosCompletados.add(lineaUsuario);
            }
        }
        EntrenamientoListviewAdapter adapter = new EntrenamientoListviewAdapter(_context, lineaUsuariosCompletados);
        _listView.setAdapter(adapter);

    }
    public void getAll() {

        FirebaseFirestore db;
        CollectionReference lineaUsuarioCollecion;
        db = FirebaseFirestore.getInstance();
        lineaUsuarioCollecion = db.collection("linea usuario");

        lineaUsuarioCollecion.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<LineaUsuario>lineaUsuarios= new ArrayList<>();
                    for (QueryDocumentSnapshot document : task.getResult()) {

                            LineaUsuario linea_usuario = new LineaUsuario();
                            linea_usuario.setUsuarioId(document.getString("UserID"));
                            linea_usuario.setNombreEntrenamiento(document.getString("Nombre Entrenamiento"));
                            linea_usuario.setDuracionTotalAproxMin(Integer.parseInt(document.getString("DuraciónTotalMin")));
                            linea_usuario.setFechaInicio(document.getTimestamp("Fecha"));
                            linea_usuario.setCompletado(document.getBoolean("Completado"));
                            linea_usuario.setTipoEntrenamiento(TipoEntrenamiento.valueOf(document.getString("Tipo Entrenamiento")));
                            lineaUsuarios.add(linea_usuario);

                    }
                    //EntrenamientoListviewAdapter adapter = new EntrenamientoListviewAdapter(_context, lineaUsuarios);
                    //_listView.setAdapter(adapter);
                }
            }
        });
    }
}
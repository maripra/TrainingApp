package com.example.trainingapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.trainingapp.Adapters.EntrenamientoListviewAdapter;
import com.example.trainingapp.Adapters.HistorialListviewAdapter;
import com.example.trainingapp.Modelo.LineaUsuario;
import com.example.trainingapp.Modelo.enumeraciones.TipoEntrenamiento;
import com.example.trainingapp.R;
import com.google.firebase.Timestamp;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistorialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistorialFragment extends Fragment {

    private HistorialListviewAdapter _adapter;
    private View _view;
    private FragmentActivity _context;
    private ListView _listView;

    public HistorialFragment() {
        // Required empty public constructor
    }


    public static HistorialFragment newInstance(String param1, String param2) {
        HistorialFragment fragment = new HistorialFragment();
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
        _view = inflater.inflate(R.layout.fragment_historial, container, false);
        _context = getActivity();
        _listView = (ListView) _view.findViewById(R.id.listViewHistorial);

        List<LineaUsuario> lineaUsuarios = new ArrayList<>();
        lineaUsuarios.add(new LineaUsuario("1", "1","Cirucito", 45, Timestamp.now(), true, TipoEntrenamiento.OBLIGATORIO));
        lineaUsuarios.add(new LineaUsuario("2", "1","Tabata", 20, Timestamp.now(), true, TipoEntrenamiento.OBLIGATORIO));
        lineaUsuarios.add(new LineaUsuario("3", "1","GAP", 50, Timestamp.now(), true, TipoEntrenamiento.OBLIGATORIO));
        lineaUsuarios.add(new LineaUsuario("4", "1","CORE", 30, Timestamp.now(), true, TipoEntrenamiento.OBLIGATORIO));
        lineaUsuarios.add(new LineaUsuario("5", "1","Tonificación", 40, Timestamp.now(), false, TipoEntrenamiento.OBLIGATORIO));
        lineaUsuarios.add(new LineaUsuario("6", "1","Carrera", 60, Timestamp.now(), false, TipoEntrenamiento.OBLIGATORIO));
        lineaUsuarios.add(new LineaUsuario("7", "1","Full Body", 50, Timestamp.now(), false, TipoEntrenamiento.OBLIGATORIO));
        lineaUsuarios.add(new LineaUsuario("8", "1","YOGA", 24, Timestamp.now(), false, TipoEntrenamiento.OBLIGATORIO));

        List<LineaUsuario> lineaUsuariosCompletados = new ArrayList<>();
        for (LineaUsuario lineaUsuario : lineaUsuarios) {
            if (lineaUsuario.isCompletado()) {
                lineaUsuariosCompletados.add(lineaUsuario);
            }
        }
        EntrenamientoListviewAdapter adapter = new EntrenamientoListviewAdapter(_context, lineaUsuariosCompletados);
        _listView.setAdapter(adapter);

        return _view;
    }
}
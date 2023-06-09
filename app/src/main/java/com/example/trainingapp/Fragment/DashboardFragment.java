package com.example.trainingapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.trainingapp.Adapters.DashboardListviewAdapter;
import com.example.trainingapp.Modelo.Ejercicio;
import com.example.trainingapp.Modelo.Entrenamiento;
import com.example.trainingapp.Modelo.ModelIdioma;
import com.example.trainingapp.R;
import com.google.firebase.Timestamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {

    private View _view;
    private FragmentActivity _context;
    private ListView _listView;
    private DashboardListviewAdapter _adapter;


    public DashboardFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
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
         _view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        _context = getActivity();
        _listView = (ListView) _view.findViewById(R.id.listViewEjercicios);

        List<Ejercicio> ejercicios = new ArrayList<>();
        ejercicios.add(new Ejercicio("1", "Peso muerto", 3, 0, 15, new ArrayList<String>(Arrays.asList("1","2"))));
        ejercicios.add(new Ejercicio("2", "Abdominales", 3, 0, 15, new ArrayList<String>(Arrays.asList("1","2"))));
        ejercicios.add(new Ejercicio("3", "Sentadilla", 3, 0, 15, new ArrayList<String>(Arrays.asList("1","2"))));

        _listView.setAdapter(new DashboardListviewAdapter(_context,ejercicios));

        return _view;
    }
}
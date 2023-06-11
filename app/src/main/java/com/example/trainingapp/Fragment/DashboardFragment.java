package com.example.trainingapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.trainingapp.Adapters.DashboardListviewAdapter;

import com.example.trainingapp.Modelo.Ejercicio;

import com.example.trainingapp.R;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DashboardFragment extends Fragment {

    private View _view;
    private FragmentActivity _context;
    private ListView _listView;
    private DashboardListviewAdapter _adapter;


    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         _view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        return _view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        _context = getActivity();
        _listView = (ListView) _view.findViewById(R.id.listViewEjercicios);

        List<Ejercicio> ejercicios = new ArrayList<>();
        ejercicios.add(new Ejercicio("1", "Peso muerto", 3, 0, 15, new ArrayList<String>(Arrays.asList("1","2"))));
        ejercicios.add(new Ejercicio("2", "Abdominales", 3, 30, 0, new ArrayList<String>(Arrays.asList("1","2"))));
        ejercicios.add(new Ejercicio("3", "Sentadilla", 3, 0, 15, new ArrayList<String>(Arrays.asList("1","2"))));

        _listView.setAdapter(new DashboardListviewAdapter(_context,ejercicios));

    }
}
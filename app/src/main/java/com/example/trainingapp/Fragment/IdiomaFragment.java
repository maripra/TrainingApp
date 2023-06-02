package com.example.trainingapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.trainingapp.Adapters.IdiomaListViewAdapter;
import com.example.trainingapp.Modelo.ModelIdioma;
import com.example.trainingapp.R;

import java.util.Arrays;
import java.util.List;

public class IdiomaFragment extends Fragment {

    private View _view;
    private FragmentActivity _context;
    private ListView _listView;
    private IdiomaListViewAdapter _adapter;
    public IdiomaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        _view = inflater.inflate(R.layout.fragment_idioma,container, false);
        return _view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        _context = getActivity();
        _listView = (ListView) _view.findViewById(R.id.listView);

        List<ModelIdioma> idiomas = Arrays.asList(
                new ModelIdioma(1,"es",getString(R.string.espanol)),
                new ModelIdioma(2, "en",getString(R.string.ingles)));
        _adapter = new IdiomaListViewAdapter(_context,idiomas);
        _listView.setAdapter(_adapter);
    }
}
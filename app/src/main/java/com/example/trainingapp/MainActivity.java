package com.example.trainingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Process;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.trainingapp.Fragment.DiarioFragment;
import com.example.trainingapp.Fragment.EntrenamientoFragment;
import com.example.trainingapp.Fragment.EntrenoOpcionalFragment;
import com.example.trainingapp.Fragment.HistorialFragment;
import com.example.trainingapp.Fragment.IdiomaFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private View _headerLayout;
    private TextView _lblUser;

    private DrawerLayout _drawerLayout;

    private NavigationView _navView;

    private Toolbar _toolbar;

    private FragmentManager fragmentManager;

    List<Fragment> fragments= new ArrayList<>();
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(_toolbar);
        //gestionar la navegación entre los fragmentos
        fragmentManager = getSupportFragmentManager();
        //añadir fragmentos a la lista
        fragments.add(new DiarioFragment());
        fragments.add(new HistorialFragment());
        fragments.add(new EntrenoOpcionalFragment());
        fragments.add(new EntrenamientoFragment());
        fragments.add(new IdiomaFragment());

        displayFragment(0);
        getSupportActionBar().setTitle("");

        FirebaseUser user = mAuth.getInstance().getCurrentUser();
        String nameUser = user.getDisplayName();


        //getLayouts
        _navView = (NavigationView) findViewById(R.id.nav_view);
        _navView.setNavigationItemSelectedListener(new NavView_OnNavigationItemSelectedListener());
        _headerLayout= _navView.getHeaderView(0);

        //para pintar al usuario
        _lblUser = _headerLayout.findViewById(R.id.lblUser);
        _lblUser.setText("Bienvenido: " + nameUser);

        _drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                _drawerLayout,
                _toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        _drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }

    private void displayFragment(int posicion) {
        Fragment fragment = fragments.get(posicion);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_frame,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    private class NavView_OnNavigationItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.string.menu_historial:
                    getSupportActionBar().setTitle("HISTORIAL");
                    displayFragment(1);
                    break;
                case R.string.menu_entrenoOpcional:
                    getSupportActionBar().setTitle("ENTRENAMIENTOS OPCIONALES");
                    displayFragment(2);
                    break;
                case R.string.menu_entrenamientos:
                    getSupportActionBar().setTitle("ENTRENAMIENTOS");
                    displayFragment(3);
                    break;
                case R.string.menu_idioma:
                    getSupportActionBar().setTitle("IDIOMAS");
                    displayFragment(4);
                    break;
                case R.string.menu_salir:
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                    break;
            }
            _drawerLayout.closeDrawers();
            return true;
        }
    }
}
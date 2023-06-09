package com.example.trainingapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.trainingapp.Fragment.DashboardFragment;
import com.example.trainingapp.Fragment.IdiomaFragment;
import com.example.trainingapp.Fragment.EntrenamientoFragment;
import com.example.trainingapp.Fragment.HistorialFragment;
import com.example.trainingapp.Modelo.Usuario;
import com.example.trainingapp.managers.DisplayFragmentManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

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

    private DisplayFragmentManager _displayFragmentManager;

    private Usuario _currentUser = null;

    //Argumentos que se le van a pasar a los fragments
    private Bundle _bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Recuperamos la Toolbar del layout en dunción del ID que se le ha puesto en el xml
        _toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(_toolbar);
        //gestionar la navegación entre los fragmentos
        fragmentManager = getSupportFragmentManager();
        //añadir fragmentos a la lista
        fragments.add(new DashboardFragment());
        fragments.add(new EntrenamientoFragment());
        fragments.add(new HistorialFragment());
        fragments.add(new IdiomaFragment());
        //inicializamos la clase que gestiona la navegación entre fragments
       _displayFragmentManager = new DisplayFragmentManager(getSupportFragmentManager());

       _displayFragmentManager.displayFragment(fragments.get(0),R.id.content_frame);

        FirebaseUser user = mAuth.getInstance().getCurrentUser();
        String nameUser = user.getDisplayName();

        //Obtenemos el usuario que se ha pasado como argumento(Bundle) desde el LoginActivity
        String userId =  (String) getIntent().getSerializableExtra("userId");


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

        getUserData(userId);
        _bundle = new Bundle();
        _bundle.putString("userId",userId);
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
            switch (item.getItemId()) {
                case R.id.menu_dashboard:

                    getSupportActionBar().setTitle("Dashboard");
                    _displayFragmentManager.displayFragment(fragments.get(0),R.id.content_frame,_bundle);
                    break;
                case R.id.menu_entrenamientos:
                    _displayFragmentManager.displayFragment(fragments.get(1),R.id.content_frame,_bundle);
                    getSupportActionBar().setTitle("Entrenamientos");
                    break;
                case R.id.menu_historial:
                    _displayFragmentManager.displayFragment(fragments.get(2),R.id.content_frame,_bundle);
                    getSupportActionBar().setTitle("Historial");
                    break;
                case R.id.menu_idioma:
                    _displayFragmentManager.displayFragment(fragments.get(3),R.id.content_frame);
                    getSupportActionBar().setTitle("Idioma");
                    break;
                case R.id.menu_salir:
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                    break;
            }
            _drawerLayout.closeDrawers();
            return true;
        }
    }
    public void getUserData(String id) {

        FirebaseFirestore db;
        CollectionReference userCollection;

        db = FirebaseFirestore.getInstance();
        userCollection = db.collection("usuario");

        DocumentReference docRef = userCollection.document(id);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {

                        _currentUser = new Usuario();
                        _currentUser.setNombre(document.getString("Nombre"));
                        _currentUser.setId(document.getId());


                        _lblUser.setText("Bienvenido/a: " + _currentUser.getNombre());

                    }
                }
            }
        });

    }
}
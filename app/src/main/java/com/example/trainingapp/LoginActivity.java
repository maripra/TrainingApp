package com.example.trainingapp;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button btnLogin;
    private TextView regis;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        email= findViewById(R.id.txtEmail);
        password=findViewById(R.id.txtContrasena);
        btnLogin=findViewById(R.id.btnLogin);
        regis=findViewById(R.id.singUptxt);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailUser= email.getText().toString().trim();
                String passwordUser= password.getText().toString().trim();

                if(emailUser.isEmpty()&& passwordUser.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Ingresa los datos", Toast.LENGTH_SHORT).show();
                }else{
                    loginUser(emailUser,passwordUser);
                }

            }
        });
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegistroActivity.class));
            }
        });
    }

    private void loginUser(String emailUser, String passwordUser) {
            mAuth.signInWithEmailAndPassword(emailUser,passwordUser).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        //finish();
                        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                        //Creamos una intención para navegar al MainActivity pasandole el contexto actual de la aplicación
                        Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);

                        //Añadimos el usuario al intent para poder acceder a el desde la otra actividad
                        mainIntent.putExtra("userId", userId);
                        startActivity(mainIntent);

                        Toast.makeText(LoginActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(LoginActivity.this, "Error al iniciar sesión", Toast.LENGTH_SHORT).show();
                }
            });

    }
}
package com.example.trainingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.firestore.FirebaseFirestore;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity {

    private EditText name;
    private EditText surname;
    private RadioGroup radioGroupGenero;
    private RadioButton radioButtonGenero;

    private EditText phone;
    private EditText email;
    private EditText password;
    private Button btn_Registro;
    private FirebaseFirestore db;
    private FirebaseAuth  mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        name= findViewById(R.id.txtName);
        surname = findViewById(R.id.txtApellido);
        phone = findViewById(R.id.txtPhone);
        email = findViewById(R.id.txtEmail);
        password =findViewById(R.id.txtContrasena);
        radioGroupGenero= findViewById(R.id.radioSexo);
        radioGroupGenero.clearCheck();
        btn_Registro = findViewById(R.id.btnRegistro);
        btn_Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedGeneroID= radioGroupGenero.getCheckedRadioButtonId();
                radioButtonGenero= findViewById(selectedGeneroID);
                //capturamos los valores ingresados por el usuario en variables de tipo String
                String nameUser = name.getText().toString().trim();
                String surnameUser = surname.getText().toString().trim();
                String phoneUser= phone.getText().toString().trim();
                String emailUser= email.getText().toString().trim();
                String passwordUser= password.getText().toString().trim();
                String hashedPassword = hashearContrasena(passwordUser);
                String textGenero;

                if(validarLetras(nameUser)) {
                    Toast.makeText(RegistroActivity.this, "Introduce el nombre ", Toast.LENGTH_SHORT).show();
                    name.setError("El nombre no puede tener números ni estar vacio");
                    name.requestFocus();
                }else if(validarLetras(surnameUser)){
                    Toast.makeText(RegistroActivity.this, "Introduce el apellido ", Toast.LENGTH_SHORT).show();
                    name.setError("El apellido no puede tener números ni estar vacio");
                    name.requestFocus();
                } else if (phoneUser.isEmpty()) {
                    Toast.makeText(RegistroActivity.this, "Introduce el número de teléfono", Toast.LENGTH_SHORT).show();
                    phone.setError("El teléfono es requerido");
                    phone.requestFocus();
                } else if (!validarNumeroTelefono(phoneUser)) {
                    Toast.makeText(RegistroActivity.this, "Por favor introduce un número de teléfono válido", Toast.LENGTH_SHORT).show();
                    phone.setError("El número de teléfono debe tener 9 dígitos y no contener letras");
                    phone.requestFocus();
                } else if (phoneUser.length() != 9) {
                    Toast.makeText(RegistroActivity.this, "Por favor introduce un número de teléfono válido", Toast.LENGTH_SHORT).show();
                    phone.setError("El número de teléfono debe tener 9 dígitos");
                    phone.requestFocus();
                } else if(TextUtils.isEmpty(emailUser)){
                    Toast.makeText(RegistroActivity.this, "Introduce el email", Toast.LENGTH_SHORT).show();
                    email.setError("el email es requerido");
                    email.requestFocus();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(emailUser).matches()){
                    Toast.makeText(RegistroActivity.this, "Por favor introduce el email", Toast.LENGTH_SHORT).show();
                    email.setError("se requiere un email válido");
                    email.requestFocus();
                }else if(radioGroupGenero.getCheckedRadioButtonId()== -1) {
                    Toast.makeText(RegistroActivity.this, "Por favor seleccione vuestro género", Toast.LENGTH_SHORT).show();
                    radioButtonGenero.setError("el género es requerido");
                    radioButtonGenero.requestFocus();
                }else if(validarContrasena(passwordUser)){
                    Toast.makeText(RegistroActivity.this, "Por favor introduce la contraseña", Toast.LENGTH_SHORT).show();
                    password.setError("Contraseña puede tener números y letras");
                    password.requestFocus();
                }else if(hashedPassword.length()<8){
                    Toast.makeText(RegistroActivity.this, "La contraseña debería tener al menos 8 dígitos", Toast.LENGTH_SHORT).show();
                    password.setError("Contraseña demasiado débil");
                    password.requestFocus();
                }else{
                    textGenero=radioButtonGenero.getText().toString().trim();
                    registroUser(nameUser,surnameUser,phoneUser,emailUser,hashedPassword,textGenero);
                }

            }
        });

    }

    private void registroUser(String nameUser,String surnameUser, String phoneUser, String emailUser, String hashedPassword, String textGenero) {

        mAuth.createUserWithEmailAndPassword(emailUser,hashedPassword).addOnCompleteListener(RegistroActivity.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String id= mAuth.getCurrentUser().getUid();
                        Map<String, Object> map= new HashMap<>();
                        map.put("id", id);
                        map.put("Nombre ", nameUser);
                        map.put("Apellido",surnameUser);
                        map.put("Teléfono", phoneUser);
                        map.put("Género", textGenero);
                        map.put("Email", emailUser);
                        map.put("Contraseña", hashedPassword);


                        db.collection("usuario").document(id).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                finish();
                                startActivity(new Intent(RegistroActivity.this, LoginActivity.class));
                                Toast.makeText(RegistroActivity.this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(RegistroActivity.this, "Error al guardar", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegistroActivity.this, "Error al registrarte", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public boolean validarNumeroTelefono(String numero) {
        //String patron = "^[0-9]{9}$";
        String patron = "^\\d{9}$";

        return !numero.isEmpty() && Pattern.matches(patron, numero)&& !numero.matches(".*[a-zA-Z]+.*");
    };
    public  boolean validarContrasena(String contrasena) {
        // Expresión regular para validar una contraseña con letras y números
        String patron = "^(?=.*[a-zA-Z])(?=.*\\d).+$";

        return contrasena != null && !contrasena.isEmpty() && Pattern.matches(patron, contrasena);
    }

    public boolean validarLetras(String texto) {
        return texto.isEmpty() || !texto.matches("[a-zA-Z]+");
    }
    public  String hashearContrasena(String contrasena) {
        try {
            // Crear instancia del algoritmo de hash SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Obtener el arreglo de bytes de la contraseña en UTF-8
            byte[] bytes = contrasena.getBytes(StandardCharsets.UTF_8);

            // Aplicar el algoritmo de hash a los bytes de la contraseña
            byte[] hashBytes = digest.digest(bytes);

            // Convertir el arreglo de bytes del hash a una representación en hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            // Devolver el hash de la contraseña en formato hexadecimal
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            // Manejo del error en caso de algoritmo de hash no encontrado
        }

        return null;
    }


}

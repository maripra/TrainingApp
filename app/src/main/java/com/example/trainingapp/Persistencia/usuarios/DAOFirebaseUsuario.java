package com.example.trainingapp.Persistencia.usuarios;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.example.trainingapp.Modelo.Usuario;


import java.util.List;

public class DAOFirebaseUsuario extends IDAOUsuario {

    private FirebaseAuth _mAuth;
    private FirebaseFirestore _db;
    private CollectionReference _userCollection;


    public DAOFirebaseUsuario() {
        _mAuth = FirebaseAuth.getInstance();
        _db = FirebaseFirestore.getInstance();
        _userCollection = _db.collection("usuario");
    }

    @Override
    public Usuario getById(String id) {
        Usuario usuario = null;
        DocumentReference docRef = _userCollection.document(id);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        mapearDocumentoAIdioma(document, usuario);
                    }
                }
            }
        });
        return usuario;
    }

    private void mapearDocumentoAIdioma(DocumentSnapshot document, Usuario usuario) {
        usuario.setId(document.getId());
        usuario.setEmail(document.getString("Email"));
        usuario.setContrasena(document.getString("Contraseña"));
        usuario.setGenero(document.getString("Género"));
        usuario.setNombre(document.getString("Nombre"));
        usuario.setApellido(document.getString("Apellido"));
        usuario.setTelefono(document.getString("teléfono"));
    }

    @Override
    public List<Usuario> getAll() {
        return null;
    }

    @Override
    public boolean update(Usuario model) {
        return false;
    }

    @Override
    public boolean delete(Usuario model) {
        return false;
    }

    @Override
    public boolean add(Usuario model) {
        return false;
    }



    @Override
    public Task<Usuario> getUserByEmail(String email) {
        final String documentName = email;
        DocumentReference documentReference = _userCollection.document(documentName);


        return documentReference.get().continueWith(new Continuation<DocumentSnapshot, Usuario>() {
            @Override
            public Usuario then(@NonNull Task<DocumentSnapshot> task) throws Exception {
                DocumentSnapshot documentSnapshot = task.getResult();
                if (documentSnapshot.exists()) {
                    return documentSnapshot.toObject(Usuario.class);
                } else {

                    return new Usuario();
                }
            }
        });
    }

}

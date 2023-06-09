package com.example.trainingapp.managers;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


/***
 * Clase que se encarga de orquestar la navegación entre fragments
 */
public class DisplayFragmentManager {

    private FragmentManager _fragmentManager;

    public DisplayFragmentManager(FragmentManager fragmentManager) {
        _fragmentManager = fragmentManager;
    }



    public void displayFragment(Fragment fragment,int contentFrameId) {

        //Para gestionar la transacción entre fragments necesitamos crear una instancia de la clase
        //FragmentTransacion en función del fragmentManager
        FragmentTransaction transaction = _fragmentManager.beginTransaction();

        //Sustituye el fragment del el container especificado como parámetro por otro fragment que también se le
        //pasa como parámetro
        transaction.replace(contentFrameId, fragment);

        //Confirmamos los cambios y se ejecuta la transacción
        transaction.commit();

    }

    public void displayFragment(Fragment fragment, int contentFrameId, Bundle args) {

        fragment.setArguments(args);

        //Para gestionar la transacción entre fragments necesitamos crear una instancia de la clase
        //FragmentTransacion en función del fragmentManager
        FragmentTransaction transaction = _fragmentManager.beginTransaction();

        //Sustituye el fragment del el container especificado como parámetro por otro fragment que también se le
        //pasa como parámetro
        transaction.replace(contentFrameId, fragment);

        //Confirmamos los cambios y se ejecuta la transacción
        transaction.commit();

    }
    public void goBack() {
        _fragmentManager.popBackStack();
    }
}

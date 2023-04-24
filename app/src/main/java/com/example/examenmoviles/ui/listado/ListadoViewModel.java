package com.example.examenmoviles.ui.listado;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examenmoviles.MainActivity;

import java.util.ArrayList;

public class ListadoViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<String>> notas = new MutableLiveData<>();;
    private ArrayList<String> listado;
    private Context context;

    public ListadoViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }


    public LiveData<ArrayList<String>> getNotas() {
        return notas;
    }

    public void cargarNotas(){
        listado = (ArrayList<String>) MainActivity.ListaNotas.clone();
        this.notas.setValue(listado);
    }

    public void crearNota(String s) {
        if(s.length()>0){
            MainActivity.ListaNotas.add(s);
            cargarNotas();
        }else{
            Toast.makeText(context, "No hay nota que guardar", Toast.LENGTH_SHORT).show();
        }

    }
}
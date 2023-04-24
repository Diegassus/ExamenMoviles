package com.example.examenmoviles.ui.item;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import com.example.examenmoviles.MainActivity;
import com.example.examenmoviles.R;

public class ItemViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<String> nota = new MutableLiveData<>();

    public ItemViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<String> getNota() {
        return nota;
    }

    public void cargarInput(int position){
        String n = MainActivity.ListaNotas.get(position);
        nota.setValue(n);
    }

    public void guardarNota(String nota, int position){
        if(nota.length()>0){
            MainActivity.ListaNotas.set(position, nota);
        }else{
            Toast.makeText(context, "No se puede guardar una nota vacia", Toast.LENGTH_SHORT).show();
        }
    }
}
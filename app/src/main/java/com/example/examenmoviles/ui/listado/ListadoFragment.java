package com.example.examenmoviles.ui.listado;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenmoviles.Alertas;
import com.example.examenmoviles.databinding.FragmentListadoBinding;

public class ListadoFragment extends Fragment {
    private ListadoViewModel vm;
    private FragmentListadoBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(ListadoViewModel.class);

        binding = FragmentListadoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView rv = binding.rvListaNotas;
        GridLayoutManager grilla = new GridLayoutManager(getContext(), 1,GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(grilla);

        vm.getNotas().observe(getViewLifecycleOwner(), notas -> {
            NotaAdapter adapter = new NotaAdapter(getContext(),notas,getLayoutInflater());
            rv.setAdapter(adapter);
        });

        binding.btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // acomodar item vista y edit
                vm.crearNota(binding.etNota.getText().toString());
                binding.etNota.setText("");
            }
        });

        vm.cargarNotas();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
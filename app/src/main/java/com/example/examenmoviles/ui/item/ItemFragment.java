package com.example.examenmoviles.ui.item;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examenmoviles.R;
import com.example.examenmoviles.databinding.FragmentItemBinding;

public class ItemFragment extends Fragment {

    private ItemViewModel vm;
    private FragmentItemBinding binding;

    public static ItemFragment newInstance() {
        return new ItemFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(ItemViewModel.class);
        binding = FragmentItemBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Bundle recuperado = getArguments();

        vm.getNota().observe(getViewLifecycleOwner(), nota -> binding.etNota.setText(nota));

        binding.btnGuardar.setOnClickListener(v -> vm.guardarNota(binding.etNota.getText().toString(), recuperado.getInt("nota")));

        vm.cargarInput(recuperado.getInt("nota"));

        //binding.etNota.setText(recuperado.getInt("nota")+"");

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vm = new ViewModelProvider(this).get(ItemViewModel.class);
        // TODO: Use the ViewModel
    }

}
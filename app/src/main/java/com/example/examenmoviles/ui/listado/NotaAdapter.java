package com.example.examenmoviles.ui.listado;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenmoviles.R;
import com.example.examenmoviles.ui.item.ItemFragment;

import java.util.ArrayList;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> notas;
    private LayoutInflater li;

    public NotaAdapter(Context context, ArrayList<String> notas, LayoutInflater li) {
        this.context = context;
        this.notas = notas;
        this.li = li;
    }

    @NonNull
    @Override
    public NotaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = li.inflate(R.layout.item_nota, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull NotaAdapter.ViewHolder holder, int position) {
        holder.nota.setText(notas.get(position));
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nota;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nota = itemView.findViewById(R.id.tvNota);
            nota.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("nota", notas.indexOf(nota.getText().toString()));
                    NavOptions op = new NavOptions.Builder()
                            .setLaunchSingleTop(true)
                            .setPopUpTo(R.id.itemFragment, true)
                            .build();
                    Navigation.findNavController((Activity) context , R.id.nav_host_fragment_content_main).navigate(R.id.itemFragment, bundle, op);
                }
            });
        }
    }
}

package com.example.appmudanza.CamionAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmudanza.R;

import java.util.List;

public class Camion1Adaptador extends RecyclerView.Adapter<Camion1Adaptador.RecyclerHolder> {

    private List<Camion1> items;

    public Camion1Adaptador(List<Camion1> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.camion1, parent,false );
        return new RecyclerHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull  Camion1Adaptador.RecyclerHolder holder, int position) {
        Camion1 item = items.get( position );
        holder.imagen.setImageResource( item.getPerfil() );
        holder.Nombre.setText( item.getNombre() );
        holder.Contenido.setText( item.getContenido() );
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class RecyclerHolder extends RecyclerView.ViewHolder  {
        private ImageView imagen;
        private TextView Nombre;
        private TextView Contenido;

        public RecyclerHolder(@NonNull View itemView){
            super(itemView);
            imagen = itemView.findViewById( R.id.imagenCamioenta );
            Nombre = itemView.findViewById( R.id.txtNombreCamioneta );
            Contenido = itemView.findViewById( R.id.txtContendoCamioneta );
        }

    }
}


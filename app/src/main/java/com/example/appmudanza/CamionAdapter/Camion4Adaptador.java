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

public class Camion4Adaptador extends RecyclerView.Adapter<Camion4Adaptador.RecyclerHolder> {

    private List<Camion4> items;
    public Camion4Adaptador(List<Camion4>items){this.items = items;}

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.camion4, parent,false );
        return new RecyclerHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull  Camion4Adaptador.RecyclerHolder holder, int position) {
        Camion4 item = items.get( position );
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
            imagen = itemView.findViewById( R.id.imagenCamion_cuatro );
            Nombre = itemView.findViewById( R.id.txtNombreCamion_cuatro );
            Contenido = itemView.findViewById( R.id.txtContendoCamion_cuatro );
        }

    }
}

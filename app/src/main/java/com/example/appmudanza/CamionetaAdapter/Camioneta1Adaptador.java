package com.example.appmudanza.CamionetaAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmudanza.CamionetaAdapter.Camioneta1;
import com.example.appmudanza.R;

import java.util.List;

public class Camioneta1Adaptador extends RecyclerView.Adapter<com.example.appmudanza.CamionetaAdapter.Camioneta1Adaptador.RecyclerHolder> {

    private List<Camioneta1> items;
    public Camioneta1Adaptador(List<Camioneta1>items){this.items = items;}

    @NonNull
    @Override
    public com.example.appmudanza.CamionetaAdapter.Camioneta1Adaptador.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.camioneta1, parent,false );
        return new com.example.appmudanza.CamionetaAdapter.Camioneta1Adaptador.RecyclerHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull  com.example.appmudanza.CamionetaAdapter.Camioneta1Adaptador.RecyclerHolder holder, int position) {
        Camioneta1 item = items.get( position );
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
            imagen = itemView.findViewById( R.id.imagenCamioneta_uno );
            Nombre = itemView.findViewById( R.id.txtNombreCamioneta_uno );
            Contenido = itemView.findViewById( R.id.txtContendoCamioneta_uno );
        }

    }
}


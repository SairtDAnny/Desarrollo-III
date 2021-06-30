package com.example.appmudanza.CamionetaAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmudanza.R;

import java.util.List;

public class Camioneta3Adaptador extends RecyclerView.Adapter<com.example.appmudanza.CamionetaAdapter.Camioneta3Adaptador.RecyclerHolder> {

    private List<Camioneta3> items;
    public Camioneta3Adaptador(List<Camioneta3>items){this.items = items;}

    @NonNull
    @Override
    public com.example.appmudanza.CamionetaAdapter.Camioneta3Adaptador.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.camioneta3, parent,false );
        return new com.example.appmudanza.CamionetaAdapter.Camioneta3Adaptador.RecyclerHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull  com.example.appmudanza.CamionetaAdapter.Camioneta3Adaptador.RecyclerHolder holder, int position) {
        Camioneta3 item = items.get( position );
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
            imagen = itemView.findViewById( R.id.imagenCamioneta_tres );
            Nombre = itemView.findViewById( R.id.txtNombreCamioneta_tres );
            Contenido = itemView.findViewById( R.id.txtContendoCamioneta_tres );
        }

    }
}


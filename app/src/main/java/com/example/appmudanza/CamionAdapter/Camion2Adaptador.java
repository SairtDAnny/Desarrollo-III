package com.example.appmudanza.CamionAdapter;

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

public class Camion2Adaptador extends RecyclerView.Adapter<Camion2Adaptador.RecyclerHolder> {

    private  List<Camion2> items;
    public Camion2Adaptador(List<Camion2> items){this.items = items;}

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.camion2, parent,false );
        return new RecyclerHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull  Camion2Adaptador.RecyclerHolder holder, int position) {
        Camion2 item = items.get( position );
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
            imagen = itemView.findViewById( R.id.imagenCamion_dos );
            Nombre = itemView.findViewById( R.id.txtNombreCamion_dos );
            Contenido = itemView.findViewById( R.id.txtContendoCamion_dos );
        }

    }
}


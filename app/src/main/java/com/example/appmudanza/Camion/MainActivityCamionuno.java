package com.example.appmudanza.Camion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.appmudanza.CamionAdapter.Camion1;
import com.example.appmudanza.CamionAdapter.Camion1Adaptador;
import com.example.appmudanza.MapsActivity;
import com.example.appmudanza.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivityCamionuno extends AppCompatActivity {
    VideoView videoCamionetas;
    RecyclerView rvLista;
    Camion1Adaptador adapter;
    List<Camion1> items;

    ImageView perfil;
    ImageButton cambiarPerfil;
    ImageButton ubicacion,llamada,watsap,facebook,masinfo;
    String url_Facebook ="https://www.facebook.com/ramon.baldes.3994";
    String url_Watsap ="http://wa.me/50240216809";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_camionuno );

        //cambiar foto de perfil
        cambiarPerfil = findViewById( R.id.btnCambiarPerfil );

        videoCamionetas = findViewById( R.id.videoCamioneta );
        String path = "android.resource://"+getPackageName()+"/"+R.raw.camion;
        videoCamionetas.setVideoURI( Uri.parse( path ) );
        videoCamionetas.start();

        ubicacion = findViewById( R.id.btnUbicacionC1 );
        llamada = findViewById( R.id.btnLlamadaC1 );
        watsap = findViewById( R.id.btnWatC1 );
        facebook = findViewById( R.id.btnFacebookC1 );
        //masinfo = findViewById( R.id.btnMasC1 );

        //llamar a facebook
        facebook.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri link = Uri.parse( url_Facebook );
                Intent i = new Intent(Intent.ACTION_VIEW,link);
                startActivity( i );
            }
        } );
        //whatsapp
        watsap.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri link = Uri.parse( url_Watsap );
                Intent i = new Intent(Intent.ACTION_VIEW,link);
                startActivity( i );
            }
        } );
        //Lllamada
        llamada.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permiso = ContextCompat.checkSelfPermission( MainActivityCamionuno.this, Manifest.permission.CALL_PHONE );
                if(permiso != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText( getApplicationContext(),"No tiene permisos",
                            Toast.LENGTH_LONG).show();
                    ActivityCompat.requestPermissions( MainActivityCamionuno.this, new String[]{Manifest.permission.CALL_PHONE},255 );
                }else{
                    String nuemro = "942139454";
                    String inicio ="tel: "+nuemro;
                    Intent i = new Intent(Intent.ACTION_CALL);
                    i.setData( Uri.parse( inicio ) );
                    startActivity( i );
                }

            }
        } );
        //ubicacion
        ubicacion.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permiso = ContextCompat.checkSelfPermission(MainActivityCamionuno.this, Manifest.permission.ACCESS_FINE_LOCATION );
                if(permiso ==PackageManager.PERMISSION_DENIED){
                    if(ActivityCompat.shouldShowRequestPermissionRationale( MainActivityCamionuno.this,
                            Manifest.permission.ACCESS_FINE_LOCATION)){
                    }else{
                        ActivityCompat.requestPermissions( MainActivityCamionuno.this,
                                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1 );
                    }

                }
                startActivity( new Intent(getApplicationContext(), MapsActivity.class));
            }
        } );


        initViews();
        initValues();
    }

    private void initViews(){
        rvLista = findViewById( R.id.rvLista );
    }
    private void initValues(){
        LinearLayoutManager manage = new LinearLayoutManager( this );
        rvLista.setLayoutManager( manage );

        items = getItems();
        adapter = new Camion1Adaptador(items);
        rvLista.setAdapter( adapter );


    }

    private List<Camion1> getItems() {
        List<Camion1> itemList = new ArrayList<>();
        itemList.add( new Camion1( R.drawable.ramon1, "Adrian ramirez", "Camioneta de servicio de mudanza\n" +
                "Cumpliendo con los protocolos de seguridad\n" +
                "Estamos  a su servicio las 24 h del dia\n" +
                "Garantia y seguridad\n" +
                "Ubicacion av.La Cultura\n" +
                "Altura de 4to paradero.\n" ) );
        itemList.add( new Camion1( R.drawable.placas, "Placa", "GZ-784\n" +
                "Placa Cusco\n" +
                "Badeja perusna\n" +
                "Palabra Peru en alto relieve\n" +
                "Numero de matricula \n" +
                "Codigo de seguridad\n" ) );
        itemList.add( new Camion1( R.drawable.modelo, "Modelo", "\n" +
                "Cumpliendo con los protocolos de seguridad\n" +
                "En esta ocasión vamos a hablar de las camionetas de carga, aquellas para trabajos pesados. Entre las primordiales opciones al respecto encontramos a las denominadas pick up, camionetas con un amplio espacio en la parte trasera para el transporte de lo que se desee. Entre algunas de las pick up más interesantes hallamos a la Ford 250, Volkswagen\n" +
                "Altura de 4to paradero.\n" ) );


        return itemList;
    }

    public  void Capturar (View view){
        Toast.makeText( this,"Comenzandoo camara", Toast.LENGTH_SHORT ).show();
        Intent intent = new Intent( MediaStore.ACTION_IMAGE_CAPTURE );
        startActivityForResult( intent,0 );
    }
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult( requestCode,resultCode,data );
        if(resultCode == Activity.RESULT_OK){
            Bundle ext = data.getExtras();
            Bitmap bmp = (Bitmap)data.getExtras().get( "data" );
            perfil.setImageBitmap( bmp );

        }
    }
}
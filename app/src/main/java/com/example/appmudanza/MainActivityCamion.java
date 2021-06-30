package com.example.appmudanza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.VideoView;

import com.example.appmudanza.Camion.MainActivityCamioncuatro;
import com.example.appmudanza.Camion.MainActivityCamiondos;
import com.example.appmudanza.Camion.MainActivityCamiontres;
import com.example.appmudanza.Camion.MainActivityCamionuno;

public class MainActivityCamion extends AppCompatActivity {
    VideoView videoCamion;
    Button boton1,boton2,boton3,boton4,boton5;
    ImageButton boton1Image,boton2Image,boton3Image,boton4Image,boton5Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_camion );

        videoCamion = findViewById( R.id.videoCamion );
        String path = "android.resource://"+getPackageName()+"/"+R.raw.videoanimacion;

        videoCamion.setVideoURI( Uri.parse( path ) );
        videoCamion.start();


        boton1 = findViewById( R.id.btnCamion1 );
        boton2 = findViewById( R.id.btnCamion2 );
        boton3 = findViewById( R.id.btnCamion3 );
        boton4 = findViewById( R.id.btnCamion4 );
        boton5 = findViewById( R.id.btnCamion5);

        boton1Image = findViewById( R.id.btnImagenCamion1 );
        boton2Image = findViewById( R.id.btnImagenCamion2 );
        boton3Image = findViewById( R.id.btnImagenCamion3 );
        boton4Image = findViewById( R.id.btnImagenCamion4 );
        boton5Image = findViewById( R.id.btnImagenCamion5 );

        boton1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(), MainActivityCamionuno.class));
            }
        } );
        boton2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(), MainActivityCamiondos.class));
            }
        } );
        boton3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(),MainActivityCamiontres.class));
            }
        } );
        boton4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(),MainActivityCamioncuatro.class));
            }
        } );
       /* boton5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(),MainActivityLorenzo.class));
            }
        } );*/



        boton1Image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(),MainActivityCamionuno.class));
            }
        } );
        boton2Image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(),MainActivityCamiondos.class));
            }
        } );
        boton3Image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(), MainActivityCamiontres.class));
            }
        } );
        boton4Image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(), MainActivityCamioncuatro.class));
            }
        } );
       /* boton5Image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(),MainActivityLorenzo.class));
            }
        } );*/



    }
}
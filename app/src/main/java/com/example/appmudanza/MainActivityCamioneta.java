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
import com.example.appmudanza.Camioneta.MainActivityCamionetacuatro;
import com.example.appmudanza.Camioneta.MainActivityCamionetados;
import com.example.appmudanza.Camioneta.MainActivityCamionetatres;
import com.example.appmudanza.Camioneta.MainActivityCamionetauno;

public class MainActivityCamioneta extends AppCompatActivity {
    VideoView videoCamioneta;
    Button boton1,boton2,boton3,boton4,boton5;
    ImageButton boton1Image,boton2Image,boton3Image,boton4Image,boton5Image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_camioneta );
        //video
        videoCamioneta = findViewById( R.id.videoCamionetausuario );
        String path = "android.resource://"+getPackageName()+"/"+R.raw.videoanimacion;
        videoCamioneta.setVideoURI( Uri.parse( path ) );
        videoCamioneta.start();
        //botones de los usuarios
        boton1 = findViewById( R.id.btnCamioneta1 );
        boton2 = findViewById( R.id.btnCamioneta2 );
        boton3 = findViewById( R.id.btnCamioneta3 );
        boton4 = findViewById( R.id.btnCamioneta4 );
        boton5 = findViewById( R.id.btnCamioneta5);

        boton1Image = findViewById( R.id.btnImagenCamioneta1 );
        boton2Image = findViewById( R.id.btnImagenCamioneta2 );
        boton3Image = findViewById( R.id.btnImagenCamioneta3 );
        boton4Image = findViewById( R.id.btnImagenCamioneta4 );
        boton5Image = findViewById( R.id.btnImagenCamioneta5 );

        boton1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(), MainActivityCamionetauno.class));
            }
        } );
        boton2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(), MainActivityCamionetados.class));
            }
        } );
        boton3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(), MainActivityCamionetatres.class));
            }
        } );
        boton4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(), MainActivityCamionetacuatro.class));
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
                startActivity( new Intent(getApplicationContext(),MainActivityCamionetauno.class));
            }
        } );
       /* boton2Image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(),MainActivityCamionetados.class));
            }
        } );
        boton3Image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(), MainActivityCamionetatres.class));
            }
        } );
        boton4Image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(), MainActivityCamionetacuatro.class));
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
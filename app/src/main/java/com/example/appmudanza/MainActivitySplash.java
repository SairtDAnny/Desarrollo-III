package com.example.appmudanza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivitySplash extends AppCompatActivity {

    MediaPlayer sonido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_splash );

        Animation ani1 = AnimationUtils.loadAnimation(this, R.anim.logoarriba);
        //sonido
        sonido = MediaPlayer.create( this, R.raw.sonidointro );
        sonido.start();

        ImageView imalogo = findViewById(R.id.imalogo);
        ImageView imabienvenidos = findViewById(R.id.imabienvenidos);
        TextView txttitulo = findViewById(R.id.txtTitulo);

        imalogo.setAnimation(ani1);
        imabienvenidos.setAnimation(ani1);
        txttitulo.setAnimation(ani1);

        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivitySplash.this, MainActivityLogin.class);
                startActivity(intent);
                finish();

            }
        }, 5500);

    }
}
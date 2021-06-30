package com.example.appmudanza;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.appmudanza.Camioneta.MainActivityCamionetacuatro;
import com.example.appmudanza.ui.home.HomeFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appmudanza.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    ImageButton boton1,boton2,boton3,btnfacebookNosotros,btnLlamadaNosotros;
    VideoView video,videonostros,videoayuda;
    MediaController mediaController;
    String url_Facebook ="https://www.facebook.com/ramon.baldes.3994";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        binding = ActivityMainBinding.inflate( getLayoutInflater() );
        setContentView( binding.getRoot() );

        setSupportActionBar( binding.appBarMain.toolbar );
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow )
                .setDrawerLayout( drawer )
                .build();
        NavController navController = Navigation.findNavController( this, R.id.nav_host_fragment_content_main );
        NavigationUI.setupActionBarWithNavController( this, navController, mAppBarConfiguration );
        NavigationUI.setupWithNavController( navigationView, navController );


        //reproducir video
        video = findViewById( R.id.videoView );
        String path = "android.resource://"+getPackageName()+"/"+R.raw.videoanimacion;
        video.setVideoURI( Uri.parse( path ) );
        video.start();

        //btnfacebookNosotros = findViewById( R.id.btnFacebookAyudas );
        //btnLlamadaNosotros = findViewById( R.id.btnLlamadaAyudas );

       /* btnfacebookNosotros.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri link = Uri.parse( url_Facebook );
                Intent i = new Intent(Intent.ACTION_VIEW,link);
                startActivity( i );
            }
        } );*/
      /*  btnfacebookNosotros.setOnClickListener( new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Uri link = Uri.parse( url_Facebook );
              Intent i = new Intent(Intent.ACTION_VIEW,link);
              startActivity( i );
          }
      } );*/
       /* btnLlamadaNosotros.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permiso = ContextCompat.checkSelfPermission( MainActivity.this, Manifest.permission.CALL_PHONE );
                if(permiso != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText( getApplicationContext(),"No tiene permisos",
                            Toast.LENGTH_LONG).show();
                    ActivityCompat.requestPermissions( MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},255 );
                }else{
                    String nuemro = "084168480";
                    String inicio ="tel: "+nuemro;
                    Intent i = new Intent(Intent.ACTION_CALL);
                    i.setData( Uri.parse( inicio ) );
                    startActivity( i );
                }
            }
        } );*/


        //acciones alos botones
        boton1 =findViewById( R.id.btnCamion );
        boton2 =findViewById( R.id.btnCamioneta );


        boton1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(),MainActivityCamion.class));
            }
        } );
        boton2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(),MainActivityCamioneta.class));
            }
        } );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.main, menu );
        return true;
    }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController( this, R.id.nav_host_fragment_content_main );
        return NavigationUI.navigateUp( navController, mAppBarConfiguration )
                || super.onSupportNavigateUp();

    }
   /* public void videoNosotross(){
        videonostros = findViewById( R.id.videoNosotros );
        String path2 = "android.resource://"+getPackageName()+"/"+R.raw.videoanimacion;
        videonostros.setVideoURI( Uri.parse( path2 ) );
        videonostros.start();
    }
    public void videoAyu(){
        videonostros = findViewById( R.id.videoNosotros );
        String path2 = "android.resource://"+getPackageName()+"/"+R.raw.videoanimacion;
        //videonostros.setVideoURI( Uri.parse( path2 ) );
        videonostros.start();
    }*/


}
package com.example.appmudanza;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.appmudanza.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private String lat,longi;
    private GoogleMap mMap;
    private ActivityMapsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        binding = ActivityMapsBinding.inflate( getLayoutInflater() );
        setContentView( binding.getRoot() );

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById( R.id.map );
        mapFragment.getMapAsync( this );
        LocationManager locationManager = (LocationManager) MapsActivity.this.getSystemService( Context.LOCATION_SERVICE );

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged( Location location) {
                lugar( location.getLatitude(),location.getLongitude() );
            }
            public void onStatusChanged(String provider, int status, Bundle extras){}
            public void onProviderEnabled(String provider){}
            public void onProviderDisabled(String provider){}
        };
        int permiso = ContextCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION );
        locationManager.requestLocationUpdates( LocationManager.NETWORK_PROVIDER,0,0, locationListener );

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng( -34, 151 );
        mMap.addMarker( new MarkerOptions().position( sydney ).title( "Marker in Sydney" ) );
        mMap.moveCamera( CameraUpdateFactory.newLatLng( sydney ) );

    }
    public void lugar(double longitud ,double latitud){

        mMap.setMapType( GoogleMap.MAP_TYPE_SATELLITE );
        UiSettings uiSettings = mMap.getUiSettings();
        //UiSettings.setZommControlsEnable(true);
        LatLng sydney = new LatLng(  longitud ,latitud );
        mMap.addMarker( new MarkerOptions().position( sydney ).title( "Ubicación del Vheiculo" ) );
        mMap.moveCamera( CameraUpdateFactory.newLatLng( sydney ) );

    }
}
package com.example.appmudanza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;

public class MainActivityLogin extends AppCompatActivity {

    TextView tienecuenta;
    Button registrar;
    EditText txtInputEmail,txtInputPassword;
    private ProgressDialog progreso;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_login );

        txtInputEmail = findViewById( R.id.txtEmailLogin );
        txtInputPassword = findViewById( R.id.txtPasswordLogin );

        tienecuenta = findViewById( R.id.textNoTieneCuenta );
        registrar = findViewById( R.id.btnIngresar );


        tienecuenta.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MainActivityLogin.this, MainActivityRegistro.class) );
            }
        } );

        registrar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarCredencial();
            }
        } );
        progreso = new ProgressDialog( MainActivityLogin.this );
        mAuth = FirebaseAuth.getInstance();
    }

    public  void verificarCredencial(){
        String email = txtInputEmail.getText().toString();
        String password = txtInputPassword.getText().toString();
        if(email.isEmpty() || !email.contains( "@" )){
            txtInputEmail.setError( "Email invalido" );
            //Toast.makeText( MainActivityRegistro.this, "email invalido", Toast.LENGTH_SHORT).show();
        }else if(password.isEmpty() || password.length()<7){
            txtInputPassword.setError( "necesitas mas de 7 caracteres" );
        }else{
            progreso.setTitle( "Login" );
            progreso.setMessage( "Iniciando Seción, espere un momento" );
            progreso.setCanceledOnTouchOutside( false );
            progreso.show();
            mAuth.signInWithEmailAndPassword( email, password ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progreso.dismiss();
                        Intent intent = new Intent(MainActivityLogin.this, MainActivity.class);
                        intent.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK );
                        startActivity( intent );
                    }else{
                        Toast.makeText( getApplicationContext(), "No se pudo iniciar Secion, verifique correo/Paswword",
                                Toast.LENGTH_LONG).show();
                    }
                }
            } );
        }
    }

    /*protected void onStar(){
        FirebaseUser user = mAuth.getCurrentUser();
        if (user!= null) {
            Intent intent = new Intent(MainActivityLogin.this, MainActivity.class);
            intent.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK );
            startActivity( intent );
        }
        super.onStart();
        }*/
}
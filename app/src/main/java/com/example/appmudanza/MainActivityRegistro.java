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

import org.jetbrains.annotations.NotNull;

public class MainActivityRegistro extends AppCompatActivity {
    TextView tienecuenta;
    Button registrar;
    EditText txtInputEmail,txtInputPassword, txtInputCinfirmPassword;
    private ProgressDialog progreso;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_registro );

        txtInputEmail = findViewById( R.id.txtEmail );
        txtInputPassword = findViewById( R.id.txtPassword );
        txtInputCinfirmPassword = findViewById( R.id.txtConfirmPassword );

        tienecuenta = findViewById( R.id.textTieneCuenta );
        registrar = findViewById( R.id.btnRegistro );

        registrar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarcredenciales();
            }
        } );

        tienecuenta.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MainActivityRegistro.this, MainActivityLogin.class) );
            }
        } );

        mAuth = FirebaseAuth.getInstance();

        progreso = new ProgressDialog( MainActivityRegistro.this );
    }
    public void verificarcredenciales(){
        String email = txtInputEmail.getText().toString();
        String password = txtInputPassword.getText().toString();
        String confirmpassword = txtInputCinfirmPassword.getText().toString();
        if(email.isEmpty() || !email.contains( "@" )){
            txtInputEmail.setError( "Email invalido" );
            //Toast.makeText( MainActivityRegistro.this, "email invalido", Toast.LENGTH_SHORT).show();
        }else if(password.isEmpty() || password.length()<7){
            txtInputPassword.setError( "necesitas mas de 7 caracteres" );
        }else if(confirmpassword.isEmpty() || !confirmpassword.equals( password )){
            txtInputPassword.setError( "las contraseñas no coinciden" );
        }else{
            progreso.setTitle( "Progreso de registro" );
            progreso.setMessage( "Registrando Usuario, espere un momento" );
            progreso.setCanceledOnTouchOutside( false );
            progreso.show();
            //Registrar Usuario
            mAuth.createUserWithEmailAndPassword( email,password ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progreso.dismiss();
                        Intent intent = new Intent(MainActivityRegistro.this, MainActivityLogin.class);
                        intent.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK );
                        startActivity( intent );
                    }else{
                        Toast.makeText( getApplicationContext(), "Error. No se pudo registrar ", Toast.LENGTH_LONG).show();
                    }
                }
            } );
        }

    }
}
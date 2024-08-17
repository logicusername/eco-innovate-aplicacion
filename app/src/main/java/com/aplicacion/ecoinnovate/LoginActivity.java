package com.aplicacion.ecoinnovate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText txtEmail,txtPassword;
    Button btnformularioregistro, btnInicioSesion;
    UserManager userManager;
    ImageView btnatraslogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnformularioregistro = findViewById(R.id.btn_formulario_registro);
        txtEmail = findViewById(R.id.login_Email);
        txtPassword = findViewById(R.id.login_Password);
        btnInicioSesion = findViewById(R.id.btn_ingreso);
        btnatraslogin = findViewById(R.id.btnatraslogin);

        userManager = new UserManager(this);

        btnformularioregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, FormularioRegistroActivity.class);
                startActivity(intent);
            }
        });
        btnInicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                if (userManager.LoginUser(email,password)){
                    Intent intent = new Intent(LoginActivity.this,MenuActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "Email o Password invalidos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnatraslogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
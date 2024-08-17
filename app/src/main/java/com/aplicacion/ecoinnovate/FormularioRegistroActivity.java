package com.aplicacion.ecoinnovate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class FormularioRegistroActivity extends AppCompatActivity {

    EditText txtEmail,txtPassword,txtRepetirPassword;
    Button btnCrearCuenta;
    UserManager userManager;
    ImageView btnatrasformulario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_registro);

        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        txtRepetirPassword = findViewById(R.id.txt_repetir_password);
        btnCrearCuenta = findViewById(R.id.btnCrearCuenta);
        btnatrasformulario = findViewById(R.id.btnatrasformulario);

        userManager = new UserManager(this);

        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();
                String repetirpassword = txtRepetirPassword.getText().toString();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(FormularioRegistroActivity.this, "ingrese un correo electronico", Toast.LENGTH_SHORT).show();
                } else if(!isValidEmail(email)){
                    Toast.makeText(FormularioRegistroActivity.this, "ingrese un correo electronico valido", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(password)) {
                    Toast.makeText(FormularioRegistroActivity.this, "ingrese una contraseña", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(repetirpassword)){
                    Toast.makeText(FormularioRegistroActivity.this, "llene todos los campos", Toast.LENGTH_SHORT).show();
                }else if (!password.equals(repetirpassword)){
                    Toast.makeText(FormularioRegistroActivity.this, "tienen que ser identicas las contraseñas", Toast.LENGTH_SHORT).show();
                }
                else{
                    registrarUsuario(email,password);
                }
            }
            private boolean isValidEmail(CharSequence target){
                return(!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
            }
            private void registrarUsuario(String email, String password){
                userManager.RegisterUser(email,password);
                Toast.makeText(FormularioRegistroActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
            }
        });
        btnatrasformulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormularioRegistroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
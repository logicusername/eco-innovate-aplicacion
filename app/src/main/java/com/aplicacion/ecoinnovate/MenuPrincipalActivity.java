package com.aplicacion.ecoinnovate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MenuPrincipalActivity extends AppCompatActivity {

    Button btnhierro, btnpapel,btnvidrio;
    ImageView btnatrasmenup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnhierro = findViewById(R.id.btn_categoria_hierro);
        btnpapel = findViewById(R.id.btn_categoria_papel);
        btnvidrio = findViewById(R.id.btn_categoria_vidrio);
        btnatrasmenup = findViewById(R.id.btn_atrasmenup);

        btnpapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipalActivity.this,PapelCategoriaActivity.class);
                startActivity(intent);
            }
        });
        btnvidrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipalActivity.this,VidrioCategoriaActivity.class);
                startActivity(intent);
            }
        });
        btnhierro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipalActivity.this,HierroCategoriaActivity.class);
                startActivity(intent);
            }
        });
        btnatrasmenup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipalActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
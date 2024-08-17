package com.aplicacion.ecoinnovate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class VidrioCategoriaActivity extends AppCompatActivity {

    Spinner spinnermeses;
    EditText valorReciclaje, kilosReciclaje;
    Button guardarDatos;
    ImageView btnatrasvidrio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vidrio_categoria);


        spinnermeses = findViewById(R.id.spinner_meses_vidrio);
        valorReciclaje = findViewById(R.id.txt_valor_vidrio);
        kilosReciclaje = findViewById(R.id.txt_kilos_vidrio);
        guardarDatos = findViewById(R.id.btn_guardardatos_vidrio);
        btnatrasvidrio = findViewById(R.id.btn_atrasvidrio);

        String [] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, meses);
        spinnermeses.setAdapter(adapter);

        guardarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mes = spinnermeses.getSelectedItem().toString();
                String valor = valorReciclaje.getText().toString();
                String kilos = kilosReciclaje.getText().toString();
                String material = "vidrio";

                if (TextUtils.isEmpty(mes) || TextUtils.isEmpty(valor) || TextUtils.isEmpty(kilos)){
                    Toast.makeText(VidrioCategoriaActivity.this, "Complete los campos", Toast.LENGTH_SHORT).show();
                    return;
                }
                SharedPreferences preferences = getSharedPreferences("DataP",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                int index = preferences.getInt("index", 0);
                editor.putString("material"+ index,material);
                editor.putString("mes"+ index,mes);
                editor.putString("valor"+ index,valor + " $");
                editor.putString("kilos"+ index,kilos + " Kg");

                editor.putInt("index", index+1);
                editor.apply();
                Toast.makeText(VidrioCategoriaActivity.this, "Los datos de reciclaje han sido guardados", Toast.LENGTH_SHORT).show();
            }
        });
        btnatrasvidrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VidrioCategoriaActivity.this, MenuPrincipalActivity.class);
                startActivity(intent);
            }
        });

    }
}
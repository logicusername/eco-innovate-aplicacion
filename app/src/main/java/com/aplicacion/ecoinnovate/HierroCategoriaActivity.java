package com.aplicacion.ecoinnovate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class HierroCategoriaActivity extends AppCompatActivity {

    Spinner spinnermeseshierro;
    EditText valorReciclajeHierro, kilosReciclajeHierro;
    Button guardarDatosHierro;
    ImageView btnatrasHierro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hierro_categoria);

        spinnermeseshierro = findViewById(R.id.spinner_meses_hierro);
        valorReciclajeHierro = findViewById(R.id.txt_valor_hierro);
        kilosReciclajeHierro = findViewById(R.id.txt_kilos_hierro);
        guardarDatosHierro = findViewById(R.id.btn_guardardatos_hierro);
        btnatrasHierro = findViewById(R.id.btn_atras_hierro);

        String [] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, meses);
        spinnermeseshierro.setAdapter(adapter);

        guardarDatosHierro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mes = spinnermeseshierro.getSelectedItem().toString();
                String valor = valorReciclajeHierro.getText().toString();
                String kilos = kilosReciclajeHierro.getText().toString();
                String material = "hierro";

                if (TextUtils.isEmpty(mes) || TextUtils.isEmpty(valor) || TextUtils.isEmpty(kilos)){
                    Toast.makeText(HierroCategoriaActivity.this, "Complete los campos", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(HierroCategoriaActivity.this, "Los datos de reciclaje han sido guardados", Toast.LENGTH_SHORT).show();
            }
        });
        btnatrasHierro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HierroCategoriaActivity.this, MenuPrincipalActivity.class);
                startActivity(intent);
            }
        });
    }
}
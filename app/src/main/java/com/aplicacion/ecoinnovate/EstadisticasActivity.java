package com.aplicacion.ecoinnovate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class EstadisticasActivity extends AppCompatActivity {

    TableLayout tableLayout;
    ImageView btnatrasestadisticas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        tableLayout = findViewById(R.id.tabla_datos);
        btnatrasestadisticas = findViewById(R.id.btn_atras_estadisticas);

        loadData();

        btnatrasestadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EstadisticasActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });


    }
    private void loadData(){
        SharedPreferences materialPrefs = getSharedPreferences("DataP",MODE_PRIVATE);

        int dataindex = materialPrefs.getInt("index",0);

        for (int i = 0; i < dataindex; i++){

            String material = materialPrefs.getString("material" + i, "");
            String mes = materialPrefs.getString("mes" + i,"");
            String kilos = materialPrefs.getString("kilos" + i, "");
            String valor = materialPrefs.getString("valor" + i, "");

            TableRow tableRow = new TableRow(this);

            TextView textViewMaterial = new TextView(this);
            textViewMaterial.setText(material);
            textViewMaterial.setBackgroundResource(R.color.white);
            tableRow.addView(textViewMaterial);

            TextView textViewMes = new TextView(this);
            textViewMes.setText(mes);
            textViewMes.setBackgroundResource(R.color.white);
            tableRow.addView(textViewMes);

            TextView textViewKilos = new TextView(this);
            textViewKilos.setText(kilos);
            textViewKilos.setBackgroundResource(R.color.white);
            tableRow.addView(textViewKilos);

            TextView textViewValor = new TextView(this);
            textViewValor.setText(valor);
            textViewValor.setBackgroundResource(R.color.white);
            tableRow.addView(textViewValor);

            tableLayout.addView(tableRow);

        }
    }
}
package com.aplicacion.ecoinnovate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.logging.SimpleFormatter;

public class ConsejosActivity extends AppCompatActivity {

    TextView textViewTip;
    ImageView btnAtrasConsejos;

    private String[] Tips = {
            "Separa residuos reciclables de los no reciclables.",
            "Lava bien envases antes de reciclarlos.",
            "Utiliza contenedores adecuados para cada material.",
            "Reduce el uso de plásticos desechables siempre que puedas.",
            "Recicla papel y cartón de forma correcta.",
            "Reutiliza frascos y botellas antes de descartar.",
            "Involucra a la familia en el reciclaje diario.",
            "Compra productos con envases reciclables y sostenibles.",
            "Evita la contaminación de los materiales reciclables.",
            "Organiza un sistema de reciclaje en casa.",
            "Consulta las normas locales de reciclaje específicas.",
            "Donar objetos útiles antes de tirarlos.",
            "Reduce el desperdicio de alimentos mediante planificación.",
            "Repara y reutiliza objetos antes de reemplazarlos.",
            "Infórmate sobre programas de reciclaje en tu área."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos);

        btnAtrasConsejos = findViewById(R.id.btn_atras_consejos);
        textViewTip = findViewById(R.id.txt_tip);

        SharedPreferences preferences  = getSharedPreferences("Tips", MODE_PRIVATE);
        String savedDate = preferences.getString("savedDate","");
        SharedPreferences.Editor editor = preferences.edit();

        boolean isInitialized = preferences.getBoolean("isInitialized",false);

        if (!isInitialized) {
            for (int i = 0; i < Tips.length; i++){
                editor.putString("tip_" + i, Tips[i]);
            }
            editor.putBoolean("isInitialized",true);
            editor.apply();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy", new Locale("es","CO"));
        String currentDate = sdf.format(new Date());
        if(!currentDate.equals(savedDate)){
            Random random = new Random();
            int randomIndex = random.nextInt(Tips.length);
            String newTip = Tips[randomIndex];
            editor.putString("currentTip",newTip);
            editor.putString("savedDate",currentDate);
            editor.apply();
        }

        CargarTipDiario();

        btnAtrasConsejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConsejosActivity.this, MenuPrincipalActivity.class);
                startActivity(intent);
            }
        });
    }
    private void CargarTipDiario(){
        SharedPreferences preferences = getSharedPreferences("Tips",MODE_PRIVATE);
        String tipDiario = preferences.getString("currentTip", "Consejo no disponible");
        textViewTip.setText(tipDiario);
    }
}
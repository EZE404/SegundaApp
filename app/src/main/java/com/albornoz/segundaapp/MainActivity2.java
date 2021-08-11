package com.albornoz.segundaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView ETS;
    private Button BTS2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        inicializarVista();
    }

    private void inicializarVista() {
        ETS = findViewById(R.id.ETSalida);
        BTS2 = findViewById(R.id.BTSiguiente2);

        // A ETS hay que asignarle lo de la primer act

        String msg = getIntent().getStringExtra("ETE_text");
        ETS.setText(msg);

        // listerner Siguiente
        BTS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(i);
            }
        });

    }
}
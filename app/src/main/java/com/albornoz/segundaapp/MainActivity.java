package com.albornoz.segundaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button BTS1;
    private EditText ETE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVista();
    }

    private void inicializarVista() {
        BTS1 = findViewById(R.id.BTSiguiente1);
        ETE = findViewById(R.id.ETEntrada);
        BTS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("ETE_text", ETE.getText().toString());
                startActivity(i);
            }

        });
    }

}
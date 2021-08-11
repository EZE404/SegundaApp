package com.albornoz.segundaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private TextView TVF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        acceder();

    }

    private void acceder() {

        TVF = findViewById(R.id.TVFinal);
        Uri llamadas = Uri.parse("content://call_log/calls");
        ContentResolver resolver = getContentResolver();

        Cursor resultSet = resolver.query(
                llamadas,
                null,
                null,
                null,
                null
        );

        if (resultSet != null && resultSet.getCount() > 0) {

            String nro = null;
            String tiempo = null;
            StringBuilder sb = new StringBuilder();

            while (resultSet.moveToNext()) {

                nro = resultSet.getString(resultSet.getColumnIndexOrThrow(CallLog.Calls.NUMBER));
                tiempo = resultSet.getString(resultSet.getColumnIndexOrThrow(CallLog.Calls.DURATION));

                sb.append(nro + " " + tiempo);
            }

            TVF.setText(sb.toString());

        } else {

            TVF.setText("Sin datos");

        }
    }
}
package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView salida;
    private Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        inicializarVista();
    }
    private void inicializarVista(){
        salida = findViewById(R.id.ETSalida);
        String mensaje = getIntent().getStringExtra("entrada");
        Log.d("mensaje", mensaje);
        salida.setText(mensaje);
        siguiente = findViewById(R.id.BTSiguiente2);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(i);
            }
        });
    }
}
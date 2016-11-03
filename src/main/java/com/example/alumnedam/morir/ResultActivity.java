package com.example.alumnedam.morir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.alumnedam.morir.R;

import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad2);

        Intent i = getIntent();
        String nombre = i.getStringExtra("Nombre");
        int edad = calcularMuerte();
        // Seria millor String nombre = getIntent().getStringExtra("nombre");
        TextView tvTexto = (TextView) findViewById(R.id.twResultado);

        // tvTexto.setText ("Saludos " + nombre);


        //Settear el texto resultado con los datos que nos llegan del main

            tvTexto.setText(new StringBuilder().append("Don ").append(nombre).append(" ").append("morira a la edad de ").append(edad).append(" ").append("al electrocutarse con el secador").toString());


    }

    public int calcularMuerte() {
        int resultado=0;
        Intent i = getIntent();
        String edad = i.getStringExtra("Edad");
        Random rand = new Random();
        resultado=Integer.parseInt(edad);
        int n = rand.nextInt(34);
        resultado=(resultado+n);
        return resultado;
    }
    @Override
    public void finish() {

        Intent intent = new Intent();
        TextView tvTexto = (TextView) findViewById(R.id.twResultado);
        intent.putExtra("saludo", tvTexto.getText().toString());
        setResult(this.RESULT_OK, intent);

        super.finish();
    }
}

package com.example.alumnedam.morir;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.alumnedam.morir.R.layout.landscape;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup radioGroupSexo;
    public final int REQUEST_CODE = 1000;
    private boolean isCheckedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroupSexo = (RadioGroup) findViewById(R.id.rgSexo);

        Button btnCalcular = (Button) findViewById(R.id.BCalcular);
        btnCalcular.setOnClickListener(this);
        setOrientacion();
    }




    public void setOrientacion() {
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        if (display.getRotation() == Surface.ROTATION_0 || display.getRotation() == Surface.ROTATION_180) {
        } else {
            Toast.makeText(this, "CargarHorizontal", Toast.LENGTH_SHORT).show();
            cargarHoritzontal(display);
        }
    }

    /*
    * Metodes on click que comprovi que els editText no estan buits quan es fa click al button
    * per calcular la mort
     */

    public void onClick(View v) {
        EditText etNombre = (EditText) findViewById(R.id.etNombre);
        EditText etEdad = (EditText) findViewById(R.id.etEdad);

        if (!MyUtils.editTextIsNullOrEmpty(etEdad)
                && !MyUtils.editTextIsNullOrEmpty(etNombre)) {

            //TODO Cosas que hacer si el texto esta completo en los dos

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            //Enviar nombre, edad,  y resultados de los checkbox
            intent.putExtra("Nombre", etNombre.getText().toString());
            intent.putExtra("Edad", etEdad.getText().toString());
            startActivity(intent);
            startActivityForResult(intent, REQUEST_CODE);

        } else {
            if (MyUtils.editTextIsNullOrEmpty(etNombre)) {
                Toast.makeText(this, "Introduce nombre", Toast.LENGTH_SHORT).show();

                etNombre.setFocusable(true);
                etNombre.requestFocus();

            }

            if (MyUtils.editTextIsNullOrEmpty(etEdad)) {
                Toast.makeText(this, "Introduce Edad", Toast.LENGTH_SHORT).show();
                etEdad.setFocusable(true);
                etEdad.requestFocus();

            }
        }


    }


    /*
    * Fer el onclick per els radio button y els casos de quin s'ha pulsat
     */
    public void addListenerOnButton() {
        radioGroupSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                if (checkedId == R.id.rbHombre) {
                    //Se ha pulsado el boton hombre
                } else if (checkedId == R.id.rbMujer) {
                    //Se ha pulsado el boton mujer
                }

            }
        });
    }
    /*
    * Metode per cargar l'aplicacio en horitzontal
     */
    private void cargarHoritzontal(Display display) {
    //TODO utilitza el layout landscape.xml
        DisplayMetrics displayMetrics = new DisplayMetrics();

        // Carrega els valors del display en displaymetrics

        display.getMetrics(displayMetrics);

        setContentView(landscape);

    }



}


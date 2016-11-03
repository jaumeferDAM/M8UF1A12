package com.example.alumnedam.morir;

import android.widget.EditText;

/**
 * Created by ALUMNEDAM on 18/10/2016.
 */
public class MyUtils {
    public static boolean stringIsNullOrEmpty (String cadena)

    {
        return (cadena == null ||cadena.length()==0);

    }

    public static boolean editTextIsNullOrEmpty (EditText editText)
    {
        return stringIsNullOrEmpty (editText.getText().toString());
    }
}

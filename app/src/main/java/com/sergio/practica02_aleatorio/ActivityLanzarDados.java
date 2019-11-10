package com.sergio.practica02_aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class ActivityLanzarDados extends AppCompatActivity implements View.OnClickListener {

    Button botonAddDado;
    ImageView imagenDados;
    ArrayList listaDados;
    int aleatorio;
    int intImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanzar_dados);
        instancias();
        acciones();
    }

    private void acciones()
    {
        botonAddDado.setOnClickListener(this);
    }

    private void instancias()
    {
        botonAddDado = findViewById(R.id.btnGenerarDado);
        imagenDados = findViewById(R.id.imgDados);
        listaDados = new ArrayList();
        listaDados.add(R.drawable.dado_uno);
        listaDados.add(R.drawable.dado_dos);
        listaDados.add(R.drawable.dado_tres);
        listaDados.add(R.drawable.dado_cuatro);
        listaDados.add(R.drawable.dado_cinco);
        listaDados.add(R.drawable.dado_seis);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnGenerarDado:
                aleatorio = (int) ((Math.random()*6));
                intImg = (int) listaDados.get(aleatorio);
                imagenDados.setImageResource(intImg);
                break;
        }

    }
}

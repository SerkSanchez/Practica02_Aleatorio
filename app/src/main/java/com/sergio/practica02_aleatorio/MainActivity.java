package com.sergio.practica02_aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    ImageButton img_botonUno, img_botonDos, img_botonTres;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones()
    {
        img_botonUno.setOnClickListener(this);
        img_botonDos.setOnClickListener(this);
        img_botonTres.setOnClickListener(this);
    }

    private void instancias()
    {
        img_botonUno = findViewById(R.id.img_button1);
        img_botonDos = findViewById(R.id.img_button2);
        img_botonTres = findViewById(R.id.img_button3);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.img_button1:
                Intent paso1 = new Intent(getApplicationContext(), ActivityGenerar.class);
                startActivity(paso1);
                break;
            case R.id.img_button2:
                Intent paso2 = new Intent(getApplicationContext(), ActivityAgregar.class);
                startActivity(paso2);
                break;
            case R.id.img_button3:
                Intent paso3 = new Intent(getApplicationContext(), ActivityLanzarDados.class);
                startActivity(paso3);
                break;
        }
    }
}

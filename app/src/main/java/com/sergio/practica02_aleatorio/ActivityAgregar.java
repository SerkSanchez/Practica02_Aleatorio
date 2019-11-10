package com.sergio.practica02_aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import java.util.ArrayList;

public class ActivityAgregar extends AppCompatActivity implements View.OnClickListener
{
    EditText txtNom, txtScroll;
    Button botonGenerarGanador, botonAddJugador;
    ScrollView txtScrollGenerar;


    ArrayList<String> jugadores = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        instancias();
        acciones();
    }

    private void acciones()
    {
        botonGenerarGanador.setOnClickListener(this);
        botonAddJugador.setOnClickListener(this);
    }

    private void instancias()
    {
        txtNom = findViewById(R.id.txtAddNom);
        botonGenerarGanador = findViewById(R.id.btnGenerarGanador);
        botonAddJugador = findViewById(R.id.btnAddJugador);
        txtScrollGenerar = findViewById(R.id.txtScrollGenerar);
        txtScroll = findViewById(R.id.txtScroll);
    }

    @Override
    public void onClick(View v)
    {
       switch (v.getId())
        {
            case R.id.btnAddJugador:
                jugadores.add(txtNom.getText().toString());
                txtScroll.append(txtNom.getText().toString() + "\n");
                break;
            case R.id.btnGenerarGanador:
                int elementos;
                if(jugadores.size() != 0) {
                    elementos = (int) (Math.random() * jugadores.size());
                    txtScroll.setText(jugadores.get(elementos).toString());
                    jugadores.removeAll(jugadores);
                }
                break;
        }

    }
}

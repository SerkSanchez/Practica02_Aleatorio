package com.sergio.practica02_aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.Toast;

public class ActivityGenerar extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {
    ImageButton btnImgagen;
    RadioGroup radioGroup;
    RadioButton r1, r2;
    EditText numDec1, numAleat, minRan, maxRan;
    CheckBox checkPermDec;
    EditText txtScrollGenerar;
    Switch repeatNum;
    ScrollView txtScrollAleatorios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar);
        instancias();
        acciones();
    }

    private void acciones() {
        btnImgagen.setOnClickListener(this);
        repeatNum.setOnCheckedChangeListener(this);
        radioGroup.setOnCheckedChangeListener(this);
        checkPermDec.setOnClickListener(this);
    }

    private void instancias() {
        radioGroup = findViewById(R.id.grupo_radios);
        r1 = findViewById(R.id.radNoRango);
        r2 = findViewById(R.id.radNoRango);
        minRan = findViewById(R.id.txtMin);
        maxRan = findViewById(R.id.txtMax);
        checkPermDec = findViewById(R.id.checkPermDec);
        numDec1 = findViewById(R.id.txtNumDec1);
        numAleat = findViewById(R.id.txtNumAleat);
        repeatNum = findViewById(R.id.switchRepeat);
        btnImgagen = findViewById(R.id.img_button);
        txtScrollAleatorios = findViewById(R.id.txtScrollAleatorios);
        txtScrollGenerar = findViewById(R.id.txtScrollGenerar);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.img_button:
                double inicio =0, fin =1000;

                switch (radioGroup.getId())
                {

                    case R.id.grupo_radios:
                        if(r2.isChecked()){
                            if(minRan.getText().toString() == "")
                                minRan.setText("0");
                            if(maxRan.getText().toString() == "")
                                maxRan.setText("1000");
                            inicio = Double.parseDouble(minRan.getText().toString());
                            fin = Double.parseDouble(maxRan.getText().toString());
                        }

                        break;
                }

                if(Integer.valueOf(numDec1.getText().toString()) < 0)
                {
                    numDec1.setText("0");
                }

                if(Integer.parseInt(numAleat.getText().toString()) <= 0)
                {
                    numAleat.setText("1");
                }

                int cont=1;
                for(cont =1; cont<=Integer.parseInt(numAleat.getText().toString()); cont++)
                {
                    double resultado = Math.random()*fin+inicio;
                    resultado = resultado*Math.pow(10,Integer.valueOf(numDec1.getText().toString()));
                    resultado = (int) resultado;
                    resultado = resultado/Math.pow(10,Integer.valueOf(numDec1.getText().toString()));
                    txtScrollGenerar.append(String.valueOf(resultado) + "\n");
                }

            break;
            case R.id.checkPermDec:
                if(!checkPermDec.isChecked())
                    numDec1.setEnabled(false);
                else
                    numDec1.setEnabled(true);
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId())
        {

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId)
    {
        switch (radioGroup.getId())
        {
            case R.id.grupo_radios:
                switch (checkedId)
                {
                    case R.id.radNoRango:
                        minRan.setEnabled(false);
                        maxRan.setEnabled(false);
                        break;
                    case R.id.radSiRango:
                        minRan.setEnabled(true);
                        maxRan.setEnabled(true);
                        break;
                }
        }
    }
}
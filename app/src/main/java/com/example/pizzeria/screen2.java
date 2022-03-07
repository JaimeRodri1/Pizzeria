package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class screen2 extends AppCompatActivity {

    private ImageButton sal;
    private ImageView fondi;
    private CheckBox acei;
    private CheckBox pina;
    private CheckBox pollo;
    private CheckBox cama;
    private CheckBox chori;
    private CheckBox toci;
    private RadioButton Gi;
    private RadioButton Me;
    private RadioButton Pe;
    private RadioButton pepe;
    private RadioButton jamon;
    private RadioButton carne;
    private ImageButton ini;
    private EditText usu;
    double precio = 0;
    double inEx;
    String ext;
    String name;
    String usua;
    String ingre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        acei = (CheckBox) findViewById(R.id.CBaceitunas);
        pina = (CheckBox) findViewById(R.id.CBpiña);
        pollo = (CheckBox) findViewById(R.id.CBpollo);
        cama = (CheckBox) findViewById(R.id.CBcamarones);
        chori = (CheckBox) findViewById(R.id.CBchorizo);
        toci = (CheckBox) findViewById(R.id.CBtocino);
        sal = (ImageButton) findViewById(R.id.bts);
        usu = (EditText) findViewById(R.id.usuario);
        fondi = (ImageView) findViewById(R.id.IVfno);
        Gi = (RadioButton) findViewById(R.id.cbG);
        Me = (RadioButton) findViewById(R.id.cbM);
        Pe = (RadioButton) findViewById(R.id.cbP);
        ini = (ImageButton) findViewById(R.id.imprimir);
        pepe = (RadioButton) findViewById(R.id.pp);
        jamon = (RadioButton) findViewById(R.id.jam);
        carne = (RadioButton) findViewById(R.id.car);

        ext = "";


        Glide.with(getApplicationContext()).load(R.drawable.fondopedi1).into(fondi);

        ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usu.getText().toString().equals("")) {
                    Toast.makeText(screen2.this, "¡No ha escrito su nombre!", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (pepe.isChecked()==true||jamon.isChecked()==true||carne.isChecked()==true) {

                        if (Gi.isChecked() == true || Me.isChecked() == true || Pe.isChecked() == true) {
                            if(acei.isChecked()==false && pollo.isChecked()==false&&pina.isChecked()==false&&cama.isChecked()==false&&toci.isChecked()==false&&chori.isChecked()==false){
                                ext = "Ninguno \n";
                                usua = usu.getText().toString();
                                text();
                                seleccion();
                                ingreExtra();

                                Intent i = new Intent(getApplicationContext(), Resultado.class);
                                i.putExtra("nombre", name);
                                i.putExtra("ingredientes", ingre);
                                i.putExtra("usuario", usua);
                                i.putExtra("nextra", ext);
                                i.putExtra("total",inEx);
                                startActivity(i);
                            }
                            else
                            {
                                usua = usu.getText().toString();
                                text();
                                seleccion();
                                ingreExtra();

                                Intent i = new Intent(getApplicationContext(), Resultado.class);
                                i.putExtra("nombre", name);
                                i.putExtra("ingredientes", ingre);
                                i.putExtra("usuario", usua);
                                i.putExtra("nextra", ext);
                                i.putExtra("total",inEx);
                                startActivity(i);
                            }


                        }
                        else {
                            Toast.makeText(screen2.this, "¡Tiene que selecionar una opcion y un ingrediente!", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                        Toast.makeText(screen2.this, "¡Tiene que selecionar una opcion y un ingrediente!", Toast.LENGTH_SHORT).show();
                    }
                    }






            }
        });

        sal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent re = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(re);
                finish();
            }
        });
    }

    public void seleccion(){

                if (Gi.isChecked() == true) {
                    precio += 7;
                    inEx = inEx +7;
                    name = "Gigante de " + ingre + " $" + precio;

                }
                else if (Me.isChecked() == true) {
                    precio = 0;
                    precio += 5;
                    inEx = inEx +5;
                    name = "Mediana de " + ingre + " $" + precio;

                }
                else if (Pe.isChecked() == true) {
                    precio = 0;
                    precio += 3;
                    inEx = inEx +3;
                    name = "Pequeña de " + ingre + " $" + precio;

                }
                else {
                    Toast.makeText(screen2.this, "¡Tiene que selecionar una opcion y un ingrediente!", Toast.LENGTH_SHORT).show();
                }



    }

    public void text(){
                if (pepe.isChecked() == true) {
                    ingre = "Peperoni";

                } else if (jamon.isChecked() == true) {
                    ingre = "Jamon";

                } else if (carne.isChecked() == true) {
                    ingre = "Carne";

                } else {
                    Toast.makeText(screen2.this, "¡Tiene que selecionar una opcion y un ingrediente!", Toast.LENGTH_SHORT).show();
                }



    }

    public void ingreExtra(){


        if (acei.isChecked()==true){

            ext += "Aceituna  $0.50 \n";
            inEx = inEx +0.50;

        }
        if (pina.isChecked()==true){


            ext += "Piña $0.50 \n";
            inEx = inEx +0.50;

        }
        if (pollo.isChecked()==true)
        {

            ext += "Pollo $0.50 \n";
            inEx = inEx +0.50;

        }
        if (cama.isChecked()==true)
        {

            ext += "Camarones $0.50 \n";
            inEx = inEx +0.50;

        }
        if (chori.isChecked()==true)
        {

            ext += "Chorizo $0.50 \n";
            inEx = inEx +0.50;

        }
        if (toci.isChecked()==true)
        {

            ext += "Tocino $0.50 \n";
            inEx = inEx +0.50;
        }


    }


}
package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Resultado extends AppCompatActivity {

    private ImageButton regre;
    private TextView imp;
    private TextView us;
    private TextView extras;
    private ImageView pedi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        pedi = (ImageView) findViewById(R.id.fondo);
        imp = (TextView) findViewById(R.id.TVimprimir);
        us = (TextView) findViewById(R.id.TVus);
        regre = (ImageButton) findViewById(R.id.Btsal);
        extras = (TextView) findViewById(R.id.TVex);

        Glide.with(getApplicationContext()).load(R.drawable.fondopedi).into(pedi);

        Bundle r = getIntent().getExtras();
        String na = r.getString("nombre");
        String u = r.getString("usuario");
        double tu = r.getDouble("total");
        String ex = r.getString("nextra");

        us.setText("¡¡Gracias por tu pedido "+u+" esperamos que vuelvas a comprar con nosotros!!");
        imp.setText(na);
        extras.setText("Ingredientes Extras: \n"+ ex+"\n"+"Tu total es: $"+tu);

        regre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rg = new Intent(getApplicationContext(),screen2.class);
                startActivity(rg);
                finish();
            }
        });
    }



}
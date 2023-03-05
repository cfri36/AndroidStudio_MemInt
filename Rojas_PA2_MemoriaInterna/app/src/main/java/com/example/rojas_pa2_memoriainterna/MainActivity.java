package com.example.rojas_pa2_memoriainterna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText ruc,nombres,apellidos,pedido,emision;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ruc = (EditText) findViewById(R.id.txtRuc);
        nombres = (EditText) findViewById(R.id.txtNombre);
        apellidos = (EditText) findViewById(R.id.txtApellido);
        pedido = (EditText) findViewById(R.id.txtPedido);
        emision = (EditText) findViewById(R.id.txtEmision);
    }

    public void grabar(View view)
    {
        String nruc,name,lastname,order,date;
        nruc=ruc.getText().toString();
        name=nombres.getText().toString();
        lastname=apellidos.getText().toString();
        order=pedido.getText().toString();
        date=emision.getText().toString();
        SharedPreferences preferences=getSharedPreferences("guia", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("ruc",nruc);
        editor.putString("nombres",name);
        editor.putString("apellidos",lastname);
        editor.putString("pedido",order);
        editor.putString("emision",date);
        editor.commit();
        Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();

    }
}
package com.jcapax.jcarlosporcel.testrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre;
    EditText txtEdad;

    List<Persona> lista = new ArrayList<>();

    RecyclerView mRecyclerViewLista;

    Adaptador adaptador;

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerViewLista = (RecyclerView) findViewById(R.id.mReciclerViewLista);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerViewLista.setLayoutManager(linearLayoutManager);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtEdad   = (EditText) findViewById(R.id.txtEdad);

        adaptador = new Adaptador(lista);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista.add(new Persona(Integer.parseInt(txtEdad.getText().toString()), txtNombre.getText().toString()));

                mRecyclerViewLista.setAdapter(adaptador);

                txtEdad.setText("");
                txtNombre.setText("");

            }
        });

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, beachiña!!!");

    }



}

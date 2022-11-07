package com.example.crud_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Editar extends AppCompatActivity {

    Button btn_excluir, btn_editar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        btn_excluir = findViewById(R.id.btn_excluir);
        btn_editar = findViewById(R.id.btn_editar);

        btn_excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Editar.this, "Produto deletado com sucesso!", Toast.LENGTH_LONG).show();
            }
        });


        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Editar.this, "Produto Editado com sucesso!", Toast.LENGTH_LONG).show();
            }
        });

    }
}
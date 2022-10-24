package com.example.crud_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.crud_app.dao.ProdutoDao;

public class MainActivity extends AppCompatActivity {

    ListView listViewProduto;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_cadastrar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cadastrar.class);
                startActivity(intent);
            }
        });

        listViewProduto = findViewById(R.id.listViewProduto);
        listViewProduto.setEmptyView(findViewById(R.id.text_vazio));
        Cursor lista = new ProdutoDao(this).select_all();

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_listar_produtos, lista,
                new String[]{"_id", "nome", "descricao", "valor"},
                new int[]{R.id.text_id, R.id.text_nome, R.id.text_descricao, R.id.text_valor}, 0);

        listViewProduto.setAdapter(adapter);
//        listViewProduto.setOnClickListener(new AdapterView.OnItemClickListener());


    }
}
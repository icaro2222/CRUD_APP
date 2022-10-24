package com.example.crud_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.crud_app.dao.ProdutoDao;

public class Cadastrar extends AppCompatActivity {

    EditText nome;
    EditText descricao;
    EditText valor;
    EditText foto;
    Button btn_cadastrar;

    //Criando instancia do produto
    ProdutoDao produto;

    //Variavel para armazenar retorno do metodo insert
    Boolean cadastrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        //Recebendo valores vindos da tela
        btn_cadastrar = findViewById(R.id.btn_cadastrar);
        nome = findViewById(R.id.input_nome);
        descricao = findViewById(R.id.input_descricao);
        valor = findViewById(R.id.input_valor);
        foto = findViewById(R.id.input_foto);

        //Irá executar no momento em que o usuário clicar no botão de cadastrar produto
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!nome.getText().toString().isEmpty()){
                    produto = new ProdutoDao(Cadastrar.this);
                    produto.setNome(nome.getText().toString());
                    produto.setDescricao(descricao.getText().toString());
                    produto.setValor(valor.getText().toString());
                    cadastrado = produto.insert();

                    if(cadastrado){
                        Intent intent = new Intent(Cadastrar.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

    }
}
package com.example.crud_app.help;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private int version = 1;
    private String nome_do_banco = "Banco_de_dados.db";

    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Banco_de_dados.db", null, 1);
    }
    public DbHelper(Context context) {
        super(context, "Banco_de_dados.db", null, 1);
    }

    //Metodo a ser incializado junto com o projeto. Só executa uma vez
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_produto = "CREATE TABLE produto(" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "nome TEXT," +
                     "descricao TEXT," +
                     "valor NUMERIC," +
                     "foto TEXT);";

        db.execSQL(sql_produto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql_update = "ALTER TABLE produto ADD COLUMNS teste";
        db.execSQL(sql_update);
    }

    //Metodo para dropar/excluir o banco
    public void delete_o_banco(SQLiteDatabase banco_a_ser_excluido){
        String sql_apagar_o_banco = "DROP TABLE produtos;";
        banco_a_ser_excluido.execSQL(sql_apagar_o_banco);
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getNome_do_banco() {
        return nome_do_banco;
    }

    public void setNome_do_banco(String nome_do_banco) {
        this.nome_do_banco = nome_do_banco;
    }

}

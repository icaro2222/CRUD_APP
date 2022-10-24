package com.example.crud_app.help;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static int DB_VERSION = 1;
    private static String DB_NAME = "Banco_de_dados.sqlite";

    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //Metodo a ser incializado junto com o projeto. Só executa uma vez
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_produto = "CREATE TABLE produto(" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "nome TEXT, " +
                     "descricao TEXT, " +
                     "valor NUMERIC, " +
                     "foto TEXT);";

        try{
            db.execSQL(sql_produto);
        }catch (SQLException e){
            Log.e("DB_LOG", "onCreate: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql_update = "ALTER TABLE produto ADD COLUMNS teste";
        db.execSQL(sql_update);
    }

    //Metodo para dropar/excluir o banco
    public void delete_o_banco(SQLiteDatabase banco_a_ser_excluido){
        String sql_apagar_o_banco = "DROP TABLE produto;";
        banco_a_ser_excluido.execSQL(sql_apagar_o_banco);
    }

    public int getVersion() {
        return DB_VERSION;
    }

    public void setVersion(int version) {
        this.DB_VERSION = version;
    }

    public String getNome_do_banco() {
        return DB_NAME;
    }

    public void setNome_do_banco(String nome_do_banco) {
        this.DB_NAME = nome_do_banco;
    }

}

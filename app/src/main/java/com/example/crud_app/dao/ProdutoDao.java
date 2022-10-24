package com.example.crud_app.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.crud_app.help.DbHelper;

public class ProdutoDao {

    private Integer id;
    private String nome;
    private String descricao;
    private String foto;
    private String valor;
    private DbHelper dbHelper;
    private SQLiteDatabase database;

    public ProdutoDao(Context context){
        this.dbHelper = new DbHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public ProdutoDao(Integer id, String nome, String descricao, String foto, String valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
        this.valor = valor;
    }

    public boolean insert(){

        ContentValues values = new ContentValues();

        values.put("nome", nome);
        values.put("descricao", descricao);
        values.put("valor", valor);

        try{
            database.insert("produto", null, values);
            return true;
        }catch (SQLException e){
            Log.e("DB_LOG", "Produto_Dao: " + e.getLocalizedMessage());
            return false;
        }
    }

    public Cursor select(){

        String sql_select = "SELECT * FROM produto;";
        Cursor lista = database.rawQuery(sql_select, null);

        return lista;
    }

    public boolean update(){
        return false;
    }

    public boolean delete(){
        int if_delete = database.delete("produto", null, null);

        return true;
    }

    public Cursor select_all(){
        String sql_select = "SELECT 'id' as '_id', nome, descricao, valor FROM produto;";
        Cursor lista = database.rawQuery(sql_select, null);

        if (lista != null){
            lista.moveToFirst();
        }
        return lista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public DbHelper getDbHelper() {
        return dbHelper;
    }

    public void setDbHelper(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public SQLiteDatabase getSqLiteDatabase() {
        return database;
    }

    public void setSqLiteDatabase(SQLiteDatabase sqLiteDatabase) {
        this.database = sqLiteDatabase;
    }
}

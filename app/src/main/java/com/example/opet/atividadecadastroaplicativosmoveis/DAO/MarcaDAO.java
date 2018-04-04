package com.example.opet.atividadecadastroaplicativosmoveis.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.opet.atividadecadastroaplicativosmoveis.Factory.DatabaseFactory;
import com.example.opet.atividadecadastroaplicativosmoveis.Util.BancoUtil;

/**
 * Created by Diego on 13/09/2017.
 *
 * Classe para inserção, remoção, atualização e busca em Banco de Dados de um Marca.
 *
 */

public class MarcaDAO {
    private SQLiteDatabase db;
    private DatabaseFactory banco;

    public static final int LIVROS_TOTAL = 1;


    public MarcaDAO(Context context) {
        banco = new DatabaseFactory(context);
    }

    public long insereDado(Marca marca) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(BancoUtil.NOME_MARCA, marca.getNomeMarca());

        resultado = db.insert(BancoUtil.TABELA_MARCA, null, valores);
        db.close();

        return resultado;

    }

    public Marca carregaMarcaPorID(int id){
        Cursor cursor;
        String[] campos = {BancoUtil.ID_MARCA, BancoUtil.NOME_MARCA};
        db = banco.getReadableDatabase();

        String where = BancoUtil.ID_MARCA + " = " + id;

        cursor = db.query(BancoUtil.TABELA_MARCA, campos, where, null, null, null, null, null);

        Marca marca = new Marca();
        if (cursor != null) {
            cursor.moveToFirst();

            int ID = cursor.getInt(cursor.getColumnIndexOrThrow(BancoUtil.ID_MARCA));
            String nomeMarca = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.NOME_MARCA));

            marca.setID(ID);
            marca.setNomeMarca(nomeMarca);
        }
        db.close();
        return marca;
    }

    public long validaMarca(String nomeMarca){
        Cursor cursor;
        String[] campos = {BancoUtil.ID_MARCA, BancoUtil.NOME_MARCA};
        db = banco.getReadableDatabase();

        String where = BancoUtil.NOME_MARCA + " = " + "'" + nomeMarca + "'";

        cursor = db.query(BancoUtil.TABELA_MARCA, campos, where, null, null, null, null, null);

        cursor.moveToFirst();

        db.close();

        if(cursor.getCount() > 0)
            return cursor.getInt(cursor.getColumnIndexOrThrow(BancoUtil.ID_MARCA));
        return -1;
    }
}
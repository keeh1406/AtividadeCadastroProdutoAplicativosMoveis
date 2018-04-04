package com.example.opet.atividadecadastroaplicativosmoveis.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.opet.atividadecadastroaplicativosmoveis.Factory.DatabaseFactory;
import com.example.opet.atividadecadastroaplicativosmoveis.Util.BancoUtil;

/**
 * Created by Diego on 08/11/2017.
 */

public class SetorDAO {

    private SQLiteDatabase db;
    private DatabaseFactory banco;


    public SetorDAO(Context context) {
        banco = new DatabaseFactory(context);
    }

    public long insereDado(Setor setor) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(BancoUtil.ID_SETOR, setor.getID());
        valores.put(BancoUtil.NOME_SETOR, setor.getNomeSetor());

        resultado = db.insert(BancoUtil.TABELA_SETOR, null, valores);
        db.close();

        return resultado;

    }

    public Setor carregaSetorPorID(long id){
        Cursor cursor;
        String[] campos = {BancoUtil.ID_SETOR, BancoUtil.NOME_SETOR};
        db = banco.getReadableDatabase();

        String where = BancoUtil.ID_SETOR + " = " + id;

        cursor = db.query(BancoUtil.TABELA_SETOR, campos, where, null, null, null, null, null);

        Setor setor = new Setor();
        if (cursor != null) {
            cursor.moveToFirst();

            int ID = cursor.getInt(cursor.getColumnIndexOrThrow(BancoUtil.ID_SETOR));
            String nomeSetor = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.NOME_SETOR));

            setor.setID(ID);
            setor.setNomeSetor(nomeSetor);

        }
        db.close();
        return setor;
    }

    public long validaSetor(String nomeSetor){
        Cursor cursor;
        String[] campos = {BancoUtil.ID_SETOR, BancoUtil.NOME_SETOR};
        db = banco.getReadableDatabase();

        String where = BancoUtil.NOME_SETOR + " = " + "'" + nomeSetor + "'";

        cursor = db.query(BancoUtil.TABELA_SETOR, campos, where, null, null, null, null, null);

        cursor.moveToFirst();

        db.close();

        if(cursor.getCount() > 0)
            return cursor.getInt(cursor.getColumnIndexOrThrow(BancoUtil.ID_SETOR));
        return -1;
    }

}

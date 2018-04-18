package com.example.opet.atividadecadastroaplicativosmoveis.Factory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.opet.atividadecadastroaplicativosmoveis.Util.BancoUtil;

/**
 * Created by Diego on 13/09/2017.
 */

public class DatabaseFactory extends SQLiteOpenHelper {

    public DatabaseFactory(Context context){
        super(context, BancoUtil.NOME_BANCO,null,BancoUtil.VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+ BancoUtil.TABELA_PRODUTO+"("
                + BancoUtil.ID_PRODUTO+ " integer primary key autoincrement,"
                + BancoUtil.NOME_PRODUTO + " text,"
                + BancoUtil.DESCRICAO_PRODUTO + " text,"
                + BancoUtil.VALIDADE_PRODUTO + " date,"
                + BancoUtil.SETOR_PRODUTO + " text,"
                + BancoUtil.MARCA_PRODUTO + " text";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BancoUtil.TABELA_PRODUTO);
        onCreate(db);
    }
}

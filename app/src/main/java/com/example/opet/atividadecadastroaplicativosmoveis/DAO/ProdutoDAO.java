package com.example.opet.atividadecadastroaplicativosmoveis.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.opet.atividadecadastroaplicativosmoveis.Factory.DatabaseFactory;
import com.example.opet.atividadecadastroaplicativosmoveis.Util.BancoUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoDAO {

    private SQLiteDatabase db;
    private DatabaseFactory banco;


    public ProdutoDAO(Context context) {
        banco = new DatabaseFactory(context);
    }

    public long insereDado(Produto produto) {
        ContentValues valores;
        long resultado;

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(BancoUtil.NOME_PRODUTO, produto.getNomeProduto());
        valores.put(BancoUtil.DESCRICAO_PRODUTO, produto.getDescricaoProduto());
        valores.put(BancoUtil.VALIDADE_PRODUTO, format.format(produto.getValidadeProduto()));
        valores.put(BancoUtil.PRODUTO_MARCA, produto.getId_marca());
        valores.put(BancoUtil.PRODUTO_SETOR, produto.getId_setor());

        resultado = db.insert(BancoUtil.TABELA_PRODUTO, null, valores);
        db.close();

        return resultado;

    }

    public Produto carregaProdutoPorID(long id){
        Cursor cursor;
        String[] campos = {BancoUtil.ID_PRODUTO, BancoUtil.NOME_PRODUTO, BancoUtil.DESCRICAO_PRODUTO, BancoUtil.VALIDADE_PRODUTO};
        db = banco.getReadableDatabase();

        String where = BancoUtil.ID_PRODUTO + " = " + id;

        cursor = db.query(BancoUtil.TABELA_PRODUTO, campos, where, null, null, null, null, null);

        Produto produto = new Produto();
        if (cursor != null) {
            cursor.moveToFirst();

            int ID = cursor.getInt(cursor.getColumnIndexOrThrow(BancoUtil.ID_PRODUTO));
            String nomeProduto = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.NOME_PRODUTO));
            String descricaoProduto = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.DESCRICAO_PRODUTO));
            String validadeProduto = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.VALIDADE_PRODUTO));

            produto.setID(ID);
            produto.setNomeProduto(nomeProduto);
            produto.setDescricaoProduto(descricaoProduto);
            produto.setValidadeProduto(validadeProduto);

        }
        db.close();
        return produto;
    }

    public Cursor carregaDados(long id_marca, long id_setor) {
        Cursor cursor;
        String[] campos = {BancoUtil.ID_PRODUTO, BancoUtil.NOME_PRODUTO, BancoUtil.DESCRICAO_PRODUTO, BancoUtil.VALIDADE_PRODUTO};
        db = banco.getReadableDatabase();

        String where = BancoUtil.PRODUTO_MARCA + " = " + id_marca + " AND " + BancoUtil.PRODUTO_SETOR + " = " + id_setor;

        cursor = db.query(BancoUtil.TABELA_PRODUTO, campos, where, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}

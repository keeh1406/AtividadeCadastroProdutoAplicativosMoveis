package com.example.opet.atividadecadastroaplicativosmoveis.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.opet.atividadecadastroaplicativosmoveis.Factory.DatabaseFactory;
import com.example.opet.atividadecadastroaplicativosmoveis.Util.BancoUtil;
import com.example.opet.atividadecadastroaplicativosmoveis.Util.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
        valores.put(BancoUtil.SETOR_PRODUTO, produto.getSetorProduto());
        valores.put(BancoUtil.MARCA_PRODUTO, produto.getMarcaProduto());

        resultado = db.insert(BancoUtil.TABELA_PRODUTO, null, valores);
        db.close();

        return resultado;

    }

    public Produto carregaProdutoPorID(long id) throws ParseException {
        Cursor cursor;
        String[] campos = {BancoUtil.ID_PRODUTO, BancoUtil.NOME_PRODUTO, BancoUtil.DESCRICAO_PRODUTO, BancoUtil.VALIDADE_PRODUTO, BancoUtil.SETOR_PRODUTO, BancoUtil.MARCA_PRODUTO};
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
            String setorProduto = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.SETOR_PRODUTO));
            String marcaProduto = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.MARCA_PRODUTO));

            produto.setID(ID);
            produto.setNomeProduto(nomeProduto);
            produto.setDescricaoProduto(descricaoProduto);
            produto.setValidadeProduto(Util.toDate(validadeProduto));
            produto.setSetorProduto(setorProduto);
            produto.setMarcaProduto(marcaProduto);

        }
        db.close();
        return produto;
    }

    public Cursor carregaDados() {
        Cursor cursor;
        String[] campos = {BancoUtil.ID_PRODUTO, BancoUtil.NOME_PRODUTO, BancoUtil.DESCRICAO_PRODUTO, BancoUtil.VALIDADE_PRODUTO, BancoUtil.SETOR_PRODUTO, BancoUtil.MARCA_PRODUTO};
        db = banco.getReadableDatabase();

        String where = null;
        cursor = db.query(BancoUtil.TABELA_PRODUTO, campos, where, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public List<Produto> carregaDadosLista() {
        Cursor cursor = null;

        cursor = carregaDados();

        List<Produto> produtos = new ArrayList<>();

        try {
            if(cursor.getCount() > 0) {
                do {
                    Produto produto = new Produto();
                    int ID = cursor.getInt(cursor.getColumnIndexOrThrow(BancoUtil.ID_PRODUTO));
                    String nomeProduto = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.NOME_PRODUTO));
                    String descricaoProduto = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.DESCRICAO_PRODUTO));
                    String validadeProduto = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.VALIDADE_PRODUTO));
                    String setorProduto = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.SETOR_PRODUTO));
                    String marcaProduto = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.MARCA_PRODUTO));

                    produto.setID(ID);
                    produto.setNomeProduto(nomeProduto);
                    produto.setDescricaoProduto(descricaoProduto);
                    produto.setValidadeProduto(Util.toDate(validadeProduto));
                    produto.setSetorProduto(setorProduto);
                    produto.setMarcaProduto(marcaProduto);

                    produtos.add(produto);
                } while (cursor.moveToNext());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }

        return produtos;
    }

    public void deletaRegistro(int id) {
        String where = BancoUtil.ID_PRODUTO + "=" + id;
        db = banco.getReadableDatabase();

        db.delete(BancoUtil.TABELA_PRODUTO, where, null);
        db.close();
    }

    public boolean atualizaProduto(Produto produto) {
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = BancoUtil.ID_PRODUTO + " = " + produto.getID();
        where = BancoUtil.NOME_PRODUTO + " = " + produto.getNomeProduto();
        where = BancoUtil.DESCRICAO_PRODUTO + " = " + produto.getDescricaoProduto();
        where = BancoUtil.VALIDADE_PRODUTO + " = " + produto.getValidadeProduto();
        where = BancoUtil.SETOR_PRODUTO + " = " + produto.getSetorProduto();
        where = BancoUtil.MARCA_PRODUTO + " = " + produto.getMarcaProduto();

        valores = new ContentValues();
        valores.put(BancoUtil.NOME_PRODUTO, produto.getNomeProduto());
        valores.put(BancoUtil.DESCRICAO_PRODUTO, produto.getDescricaoProduto());
        valores.put(BancoUtil.VALIDADE_PRODUTO, String.valueOf(produto.getValidadeProduto()));
        valores.put(BancoUtil.SETOR_PRODUTO, produto.getSetorProduto());
        valores.put(BancoUtil.MARCA_PRODUTO, produto.getMarcaProduto());


        int resultado = db.update(BancoUtil.TABELA_PRODUTO, valores, where, null);
        db.close();
        if (resultado > 0)
            return true;
        else
            return false;
    }
}

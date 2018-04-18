package com.example.opet.atividadecadastroaplicativosmoveis.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.opet.atividadecadastroaplicativosmoveis.DAO.Produto;
import com.example.opet.atividadecadastroaplicativosmoveis.R;

import java.util.List;

/**
 * Created by opet on 18/04/2018.
 */

public class ProdutoAdapter extends ArrayAdapter{
    private int resource;
    private List<Produto> produtos;

    public ProdutoAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Produto> objects) {
        super(context, resource, objects);
        this.resource = resource;
        produtos = objects;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent){
        View mView = currentView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(resource,null,false);
        }

        Produto produto = produtos.get(position);

        TextView textID = (TextView) mView.findViewById(R.id.textID);
        TextView textNomeProduto = (TextView) mView.findViewById(R.id.textNomeProduto);
        TextView textDescricaoProduto = (TextView) mView.findViewById(R.id.textDescricaoProduto);
        TextView textValidadeProduto = (TextView) mView.findViewById(R.id.textValidadeProduto);
        TextView textSetorProduto = (TextView) mView.findViewById(R.id.textSetorProduto);
        TextView textMarcaProduto = (TextView) mView.findViewById(R.id.textMarcaProduto);

        if(textID != null){
            textID.setText(String.valueOf(produto.getID()));
        }
        if(textNomeProduto != null){
            textNomeProduto.setText(produto.getNomeProduto());
        }
        if(textDescricaoProduto != null){
            textDescricaoProduto.setText(produto.getDescricaoProduto());
        }
        if(textValidadeProduto != null){
            textValidadeProduto.setText(String.valueOf(produto.getValidadeProduto()));
        }
        if(textSetorProduto != null){
            textSetorProduto.setText(String.valueOf(produto.getSetorProduto()));
        }
        if(textMarcaProduto != null){
            textMarcaProduto.setText(String.valueOf(produto.getMarcaProduto()));
        }
        return mView;
    }
}

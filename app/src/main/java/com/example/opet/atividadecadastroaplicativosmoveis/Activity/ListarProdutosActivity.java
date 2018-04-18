package com.example.opet.atividadecadastroaplicativosmoveis.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.opet.atividadecadastroaplicativosmoveis.Adapter.ProdutoAdapter;
import com.example.opet.atividadecadastroaplicativosmoveis.DAO.Produto;
import com.example.opet.atividadecadastroaplicativosmoveis.DAO.ProdutoDAO;
import com.example.opet.atividadecadastroaplicativosmoveis.R;

import java.util.List;

/**
 * Created by opet on 18/04/2018.
 */

public class ListarProdutosActivity extends Activity {

    private ListView listaProdutos;
    private ProdutoAdapter myAdapter;
    ProdutoDAO produtoDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);

        carregarElementos();
    }

    public void carregarElementos(){
        listaProdutos = (ListView) findViewById(R.id.listProdutos);
        produtoDAO = new ProdutoDAO(this);
        List<Produto> produtos = produtoDAO.carregaDadosLista();
        myAdapter = new ProdutoAdapter(this, R.layout.item_produto,produtos);
        listaProdutos.setAdapter(myAdapter);
        listaProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Produto produto = (Produto)parent.getItemAtPosition(position);
                Intent atualizarIntent = new Intent(ListarProdutosActivity.this,AtualizarProdutosActivity.class);
                atualizarIntent.putExtra("ID_PRODUTO",produto.getID());
                startActivity(atualizarIntent);
            }
        });
    }
}

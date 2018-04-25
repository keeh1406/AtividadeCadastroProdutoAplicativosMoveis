package com.example.opet.atividadecadastroaplicativosmoveis.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.opet.atividadecadastroaplicativosmoveis.DAO.Produto;
import com.example.opet.atividadecadastroaplicativosmoveis.DAO.ProdutoDAO;
import com.example.opet.atividadecadastroaplicativosmoveis.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CadastrarProdutoActivity extends Activity {
    private EditText editNomeProduto;
    private EditText editDescricaoProduto;
    private EditText editValidadeProduto;
    private EditText editSetorProduto;
    private EditText editMarcaProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produto);

        editNomeProduto = (EditText) findViewById(R.id.editNomeProduto);
        editDescricaoProduto = (EditText) findViewById(R.id.editDescricaoProduto);
        editValidadeProduto = (EditText) findViewById(R.id.editValidadeProduto);
        editSetorProduto = (EditText) findViewById(R.id.editSetorProduto);
        editMarcaProduto = (EditText) findViewById(R.id.editMarcaProduto);
    }

    public void salvarProduto(View v) throws ParseException {
        ProdutoDAO produtoDAO = new ProdutoDAO(this);
        Produto produto = new Produto();
        produto.setNomeProduto(editNomeProduto.getText().toString());
        produto.setDescricaoProduto(editDescricaoProduto.getText().toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        produto.setValidadeProduto(simpleDateFormat.parse(editValidadeProduto.getText().toString()));
        produto.setSetorProduto(editSetorProduto.getText().toString());
        produto.setMarcaProduto(editMarcaProduto.getText().toString());

        long resultado = produtoDAO.insereDado(produto);

        if(resultado > 0){
            exibirMensagem("Cadastro realizado com sucesso!");
            Intent listarProdutos = new Intent(CadastrarProdutoActivity.this,ListarProdutosActivity.class);
            startActivity(listarProdutos);
            finish();
        }
        else{
            exibirMensagem("Erro ao cadastrar o item.");
        }
    }

    private void exibirMensagem(String mensagem){
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}

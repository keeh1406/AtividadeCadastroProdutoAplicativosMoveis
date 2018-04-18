package com.example.opet.atividadecadastroaplicativosmoveis.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.opet.atividadecadastroaplicativosmoveis.DAO.Produto;
import com.example.opet.atividadecadastroaplicativosmoveis.DAO.ProdutoDAO;
import com.example.opet.atividadecadastroaplicativosmoveis.R;

public class AtualizarProdutosActivity extends Activity {
    private int ID_PRODUTO;
    private ProdutoDAO produtoDAO = new produtoDAO(this);
    private Produto produto;
    private EditText editNomeProduto;
    private EditText editDescricaoProduto;
    private EditText editValidadeProduto;
    private EditText editSetorProduto;
    private EditText editMarcaProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_produtos);

        Intent intent = getIntent();
        if(intent.hasExtra("ID_PRODUTO")){
            ID_PRODUTO = intent.getIntExtra("ID_PRODUTO",0);
        }
        produto = produtoDAO.carregaProdutoPorID(ID_PRODUTO);

        editNomeProduto = (EditText) findViewById(R.id.editNomeProdutoUpdate);
        editDescricaoProduto = (EditText) findViewById(R.id.editDescricaoProdutoUpdate);
        editValidadeProduto = (EditText) findViewById(R.id.editValidadeProdutoUpdate);
        editSetorProduto = (EditText) findViewById(R.id.editSetorProdutoUpdate);
        editMarcaProduto = (EditText) findViewById(R.id.editMarcaProdutoUpdate);

        editNomeProduto.setText(produto.getNomeProduto());
        editDescricaoProduto.setText(produto.getDescricaoProduto());
        editValidadeProduto.setText((CharSequence) produto.getValidadeProduto());
        editSetorProduto.setText(produto.getSetorProduto());
        editMarcaProduto.setText(produto.getMarcaProduto());
    }

    public void atualizarLivro(View v){
        produto.setNomeProduto(editNomeProduto.getText().toString());
        produto.setDescricaoProduto(editDescricaoProduto.getText().toString());
        produto.setValidadeProduto(editValidadeProduto.getText().toString());
        produto.setSetorProduto(editSetorProduto.getText().toString());
        produto.setMarcaProduto(editMarcaProduto.getText().toString());

        if(produtoDAO.atualizaProduto(produto))
            Toast.makeText(AtualizarProdutosActivity.this, "Produto atualizado com sucesso.", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(AtualizarProdutosActivity.this, "Erro ao atualizar o produto.", Toast.LENGTH_SHORT).show();
        telaInicial();
    }

    public void removerProduto(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.dialog_title);
        builder.setMessage(R.string.dialog_message);
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                produtoDAO.deletaRegistro(ID_PRODUTO);
                Toast.makeText(AtualizarProdutosActivity.this, "Produto removido com sucesso.", Toast.LENGTH_SHORT).show();
                telaInicial();
            }
        });
        builder.setNegativeButton("Não", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void telaInicial() {
        Intent telaInicial = new Intent(AtualizarProdutosActivity.this,MainActivity.class);
        startActivity(telaInicial);
        finish();
    }
}

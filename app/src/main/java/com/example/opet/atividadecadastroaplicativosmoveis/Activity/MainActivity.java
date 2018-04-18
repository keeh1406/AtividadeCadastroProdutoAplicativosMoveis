package com.example.opet.atividadecadastroaplicativosmoveis.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.opet.atividadecadastroaplicativosmoveis.R;

public class MainActivity extends Activity {

    private TextView textWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textWelcome = (TextView) findViewById(R.id.textWelcome);

        Intent resultado = getIntent();

        textWelcome.setText("Olá!");
    }

    public void carregaItemMenu(View v){
        switch (v.getId()) {
            case R.id.btnInserir:
                carregarIntent(CadastrarProdutoActivity.class);
                break;
            case R.id.btnListar:
                carregarIntent(ListarProdutosActivity.class);
                break;
        }
    }

    private void carregarIntent(Class classe){
        Intent intent = new Intent(MainActivity.this,classe);
        startActivity(intent);
    }
}

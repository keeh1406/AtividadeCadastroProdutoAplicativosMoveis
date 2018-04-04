package com.example.opet.atividadecadastroaplicativosmoveis.DAO;

import java.util.Date;

public class Produto {
    private int ID;
    private String nomeProduto;
    private String descricaoProduto;
    private Date validadeProduto;
    private long id_marca;
    private long id_setor;

    public Produto() {
    }

    public Produto(int ID, String nomeProduto, String descricaoProduto, Date validadeProduto) {
        this.ID = ID;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.validadeProduto = validadeProduto;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Date getValidadeProduto() {
        return validadeProduto;
    }

    public void setValidadeProduto(String validadeProdutooProdutoProduto) {
        this.validadeProduto = validadeProduto;
    }

    public long getId_marca() {
        return id_marca;
    }

    public void setId_marca(long id_marca) {
        this.id_marca = id_marca;
    }

    public long getId_setor() {
        return id_setor;
    }

    public void setId_setor(long id_setor) {
        this.id_setor = id_setor;
    }
}
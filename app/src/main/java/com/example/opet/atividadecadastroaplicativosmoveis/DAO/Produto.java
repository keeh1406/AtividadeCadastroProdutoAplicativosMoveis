package com.example.opet.atividadecadastroaplicativosmoveis.DAO;

import java.util.Date;

public class Produto {
    private int ID;
    private String nomeProduto;
    private String descricaoProduto;
    private Date validadeProduto;
    private String marcaProduto;
    private String setorProduto;

    public Produto() {
    }

    public Produto(int ID, String nomeProduto, String descricaoProduto, Date validadeProduto, String marcaProduto, String setorProduto) {
        this.ID = ID;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.validadeProduto = validadeProduto;
        this.marcaProduto = marcaProduto;
        this.setorProduto = setorProduto;
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
    public void setValidadeProduto(Date validadeProduto) {
        this.validadeProduto = validadeProduto;
    }


    public String getMarcaProduto() {
        return marcaProduto;
    }
    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }


    public String getSetorProduto() {
        return setorProduto;
    }
    public void setSetorProduto(String setorProduto) {
        this.setorProduto = setorProduto;
    }
}
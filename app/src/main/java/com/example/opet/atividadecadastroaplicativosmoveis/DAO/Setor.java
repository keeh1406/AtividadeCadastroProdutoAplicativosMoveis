package com.example.opet.atividadecadastroaplicativosmoveis.DAO;

/**
 * Created by Diego on 08/11/2017.
 */

public class Setor {
    private int ID;
    private String nomeSetor;

    public Setor() {
    }

    public Setor(int ID, String nomeSetor) {
        this.ID = ID;
        this.nomeSetor = nomeSetor;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }
}

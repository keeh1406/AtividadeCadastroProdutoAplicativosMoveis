package com.example.opet.atividadecadastroaplicativosmoveis.DAO;

/**
 * Created by Diego on 13/09/2017.
 */

public class Marca {
    private int ID;
    private String nomeMarca;

    public Marca() {
    }

    public Marca(int ID, String nomeMarca) {
        this.ID = ID;
        this.nomeMarca = nomeMarca;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }
}

package com.example.barba.model;

import java.io.Serializable;

/**
 * Created by Gilbertopapa013 on 08/04/2017.
 */

public class Usuario implements Serializable {

    private String email;
    private String telefone;
    private String nomeUsuario;

    public Usuario(String email, String telefone, String nomeUsuario) {
        this.setEmail(email);
        this.setTelefone(telefone);
        this.setNomeUsuario(nomeUsuario);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Setores;

import Usuario.FilaUsuarios;

public class Setores{

    private String nome;
    private boolean ativo;
    private FilaUsuarios usuario;
    private Setores proximo;
    private Setores anterior;
    
    public Setores(String nome) {
        this.nome = nome;
        this.usuario = null;
        this.proximo = null;
        this.anterior = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public FilaUsuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(FilaUsuarios usuario) {
        this.usuario = usuario;
    }

    public Setores getProximo() {
        return proximo;
    }

    public void setProximo(Setores proximo) {
        this.proximo = proximo;
    }

    public Setores getAnterior() {
        return anterior;
    }

    public void setAnterior(Setores anterior) {
        this.anterior = anterior;
    }

    
}
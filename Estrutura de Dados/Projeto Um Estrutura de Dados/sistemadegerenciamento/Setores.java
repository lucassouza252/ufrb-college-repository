/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadegerenciamento;

/**
 *
 * @author Kelly
 */
public class Setores extends NodoGeral {

    private String nome;
    private boolean ativo;
    private ListaUsuarios usuario;

    public Setores() {
        this.usuario = null;
        this.ativo = false;
    }

    public Setores(String nome, boolean ativo) {
        this.nome = nome;
        this.ativo = ativo;
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

    public ListaUsuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(ListaUsuarios usuario) {
        this.usuario = usuario;
    }

}

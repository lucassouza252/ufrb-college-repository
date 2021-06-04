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
public class ListaAtendidos {

    Usuario inicio;
    int cont;

    public ListaAtendidos() {
        cont = 0;
        inicio = null;
    }

    public boolean isEmpty() {
        return this.cont == 0;
    }

    public void listarSenhas() {
        if (isEmpty()) {
            System.out.println("Lista de atendidos está vazia!");
            return;
        }
        Usuario aux = inicio;
        int num = 0;
        while (aux != null && num < 10) {
            System.out.println("Senha: " + aux.getChamada().getSenha() + "\n");
            aux = (Usuario) aux.getProximo();
            num++;
        }
        System.out.println("\n\n");
    }

    public void insere(Usuario usuario) {
        if (isEmpty()) {
            inicio = usuario;
        } else {
            Usuario aux = inicio;
            usuario.setProximo(aux);
            inicio = usuario;
        }
        this.cont++;
    }

}

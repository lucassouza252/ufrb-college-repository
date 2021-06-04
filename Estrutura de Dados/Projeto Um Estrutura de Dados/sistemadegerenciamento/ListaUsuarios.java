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
public class ListaUsuarios {

    Usuario inicioFila, fimFila;
    int total;

    public ListaUsuarios() {
        this.inicioFila = null;
        this.fimFila = null;
        this.total = 0;
    }

    public boolean isEmpty() {
        return this.total == 0;
    }

    public void insere(String cpf, String matricula, Chamada chamada) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setCpf(cpf);
        novoUsuario.setChamada(chamada);
        novoUsuario.setMatricula(matricula);
        if (isEmpty()) {
            inicioFila = novoUsuario;
            fimFila = novoUsuario;
        } else {
            fimFila.setProximo(novoUsuario);
            novoUsuario.setProximo(null);
            fimFila = novoUsuario;
        }
        this.total++;
    }

    public String toString(Usuario atual) {
        return "Usuario a ser atendido:\nMatricula: " + atual.getMatricula() + "; CPF: " + atual.getCpf() + ", Senha: " + atual.getChamada().getSenha();
    }
//Atender:

    public Usuario remove() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
            return null;
        }
        Usuario usuarioAtendido = inicioFila;
        System.out.println(this.toString(usuarioAtendido));
        inicioFila = (Usuario) inicioFila.getProximo();

        this.total--;
        return usuarioAtendido;
    }

    public void listar() {
        if (isEmpty()) {
            System.out.println("Fila vazia");
            return;
        }
        Usuario aux = inicioFila;
        while (aux != null) {
            System.out.println("Matricula: " + aux.getMatricula() + "; CPF: " + aux.getCpf() + "; Senha: " + aux.getChamada().getSenha() + "\n");
            aux = (Usuario) aux.getProximo();
        }
        System.out.println("\n\n");
    }

}

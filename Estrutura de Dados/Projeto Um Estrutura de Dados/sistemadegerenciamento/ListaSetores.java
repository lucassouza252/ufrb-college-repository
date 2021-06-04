/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadegerenciamento;

import java.util.Scanner;

/**
 *
 * @author Kelly
 */
public class ListaSetores {

    Scanner input = new Scanner(System.in);
    Setores inicio, fim;

    int total, numSetor;

    public ListaSetores() {
        this.inicio = null;
        this.fim = null;
        this.total = 0;
        this.numSetor = 0;
    }

    public void inserir(String nome) {

        Setores novo = new Setores();
        novo.setNome(nome);
        if (isEmpty()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.setProximo(novo);
            novo.setAnterior(fim);
            novo.setProximo(null);
            fim = novo;
        }
        this.total++;
    }

    public void listarSetoresComFila() {
        if (isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }
        Setores aux = inicio;
        System.out.println("\nSETORES:\n");
        while (aux != null) {
            System.out.println(aux.getNome().toUpperCase() + "\n");
            if (aux.isAtivo()) {
                System.out.println("O " + aux.getNome().toUpperCase() + " ESTÁ ATIVO.\n");
            } else {
                System.out.println("O " + aux.getNome().toUpperCase() + " ESTÁ INATIVO.\n");
            }
            if (aux.getUsuario() != null) {
                System.out.println("FILA DO " + aux.getNome().toUpperCase() + ":\n");
                if (!aux.getUsuario().isEmpty()) {
                    aux.getUsuario().listar();
                }
            }
            aux = (Setores) aux.getProximo();
        }
        System.out.println("\n\n");
    }

    public void listarSetores() {
        if (isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }
        Setores aux = inicio;
        System.out.println("\nSETORES E SEUS RESPECTIVOS STATUS:\n");
        while (aux != null) {
            System.out.print(aux.getNome().toUpperCase() + ", ");
            if (aux.isAtivo()) {
                System.out.println("O " + aux.getNome().toUpperCase() + " ESTÁ ATIVO.\n");
            } else {
                System.out.println("O " + aux.getNome().toUpperCase() + " ESTÁ INATIVO.\n");
            }
            aux = (Setores) aux.getProximo();
        }
        System.out.println("\n\n");
    }

    public void alteraStatus(String nome) {
        if (isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }
        Setores aux = inicio;
        while (aux != null) {
            if (aux.getNome().equalsIgnoreCase(nome)) {
                int op;
                System.out.println("Informe qual o status do setor: " + aux.getNome());
                System.out.print("1 - Ativo\n2 - Inativo\nEscolha: ");
                op = input.nextInt();
                if (op == 1) {
                    aux.setAtivo(true);
                } else {
                    aux.setAtivo(false);
                }
                return;
            }
            aux = (Setores) aux.getProximo();
        }
        System.out.println("Nome de setor invalido!");
    }

    public void pegarSenha(String nome) {
        if (isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }
        Setores aux = inicio;
        while (aux != null) {

            if (aux.getNome().equalsIgnoreCase(nome)) {
                if (aux.isAtivo()) {
                    int op;
                    input.nextLine();
//Já existe uma fila no setor: 
                    if (aux.getUsuario() != null) {
                        if (!aux.getUsuario().isEmpty()) {

                            ListaUsuarios usuarios;
                            usuarios = aux.getUsuario();
                            Chamada chamada;
                            do {
                                String matricula;
                                String cpf;
                                chamada = new Chamada();

                                System.out.println("Matricula: ");
                                matricula = input.nextLine();
                                System.out.println("CPF: ");
                                cpf = input.nextLine();
                                chamada.setSenha(aux.getNome() + (usuarios.total + 1));

                                usuarios.insere(cpf, matricula, chamada);
                                aux.setUsuario(usuarios);
                                System.out.print("Add outra pessoa?1 - S e 2 - N ----------- ");
                                op = input.nextInt();
                                input.nextLine();
                            } while (op != 2);

                            if (aux.getUsuario() != null) {
                                if (!aux.getUsuario().isEmpty()) {
                                    aux.getUsuario().listar();
                                }
                            }
                            return;
                        }
                    }
// Não existe ainda uma fila no setor: 
                    ListaUsuarios usuarios = new ListaUsuarios();
                    Chamada chamada;
                    do {
                        String matricula;
                        String cpf;
                        chamada = new Chamada();

                        System.out.println("Matricula: ");
                        matricula = input.nextLine();
                        System.out.println("CPF: ");
                        cpf = input.nextLine();
                        chamada.setSenha(aux.getNome() + (usuarios.total + 1));

                        usuarios.insere(cpf, matricula, chamada);
                        aux.setUsuario(usuarios);
                        System.out.print("Add outra pessoa?1 - S e 2 - N ----------- ");
                        op = input.nextInt();
                        input.nextLine();
                    } while (op != 2);

                    if (aux.getUsuario() != null) {
                        if (!aux.getUsuario().isEmpty()) {
                            aux.getUsuario().listar();
                        }
                    }
                    return;
                } else {
                    System.out.println("SETOR INATIVO NO MOMENTO, VOLTE MAIS TARDE!");
                    return;
                }
            }
            aux = (Setores) aux.getProximo();
        }
        System.out.println("Nome de setor invalido!");
    }

    public void atenderAlguem(String nome) {
        if (isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }
        Setores aux = inicio;
        while (aux != null) {

            if (aux.getNome().equalsIgnoreCase(nome)) {
                if (aux.isAtivo()) {
                    int op;
                    input.nextLine();
//Já existe uma fila no setor: 
                    if (aux.getUsuario() != null) {
                        if (!aux.getUsuario().isEmpty()) {

                            ListaUsuarios usuarios;
                          //  ListaAtendidos atendidos = new ListaAtendidos();
                            usuarios = aux.getUsuario();
                            Usuario usuarioAtendido;
                            do {
                                usuarioAtendido = usuarios.remove();
                              //  atendidos.insere(usuarioAtendido);
                                System.out.print("Atender outra pessoa?1 - S e 2 - N ----------- ");
                                op = input.nextInt();
                                input.nextLine();
                                if (op == 1) {
                                    System.out.print("Informe de qual setor deseja atender alguém: ");
                                    String nomeSetor = input.nextLine();
                                    this.atenderAlguem(nomeSetor);
                                }
                                System.out.print("Atender outra pessoa?1 - S e 2 - N ----------- ");
                                op = input.nextInt();
                                if (op == 2) {
                                    break;
                                }
                            } while (true);

                            if (aux.getUsuario() != null) {
                                if (!aux.getUsuario().isEmpty()) {
                                    aux.getUsuario().listar();
                                }
                            }
                            return;
                        }
                    } else {
                        System.out.println("NINGUÉ NA FILA!");
                        return;
                    }
                } else {
                    System.out.println("SETOR INATIVO NO MOMENTO, VOLTE MAIS TARDE!");
                    return;
                }
            }
            aux = (Setores) aux.getProximo();
        }
        System.out.println("Nome de setor invalido!");
    }

    public boolean isEmpty() {
        return this.total == 0;
    }
}

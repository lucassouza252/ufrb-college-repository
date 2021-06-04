package sistemadegerenciamento;

import java.util.Scanner;

/**
 *
 * @author Kelly
 */
/*Implemente uma abstração que organize uma fila para atendimentos em Múltiplos setores de uma organização.
Cada usuário deve informar sua matrícula e receberá um número de controle de acordo ao setor da organização que pretende ser atendido
Ex: Matricula: 2345678    Setor: Núcleo acadêmico   => Senha: NUAC10
É importante que permita a exibição de senhas dos últimos 10 já chamadas com o horário. 
Individualmente pode ser consultado o horário da chamada de um atendimento.
Como se informa o horário de cada atendimento, deve-se calcular o tempo de cada atendimento após o término do mesmo. 
E com isso deve-se calcular o tempo médio de atendimento do setor. 
Também pode-se calcular o tempo de espera com base no tempo médio de atendimento do setor.*/
public class Menu {

    static Scanner input = new Scanner(System.in);

    public static int menu() {
        int op;
        System.out.print("O que deseja fazer?\n1 - Criar setor\n2 - Alterar status de um setor\n3 - Pegar ficha\n4 - Atender alguém\n5 - Listar Setores\n0 - Encerrar aplicação(ATENÇÃO!! ESTÁ OPÇÃO ENCERRA TODOS OS SETORES EM EXECUÇÃO!)\nEscolha: ");
        op = input.nextInt();
        return op;
    }

    public static void main(String args[]) {

        ListaSetores setores = new ListaSetores();
        int op = 1, opGeral;

        String lixo, nomedep;
        do {
            opGeral = menu();
            input.nextLine();
            switch (opGeral) {
                case 1:
                    String nomeSetor;
                    System.out.println("ATENÇÃO:\nO SETOR É CRIADO COMO INATIVO POR DEFAULT, PARA USO DO SETOR ALTERE O SEU STATUS INDO NA OPÇÃO 2.\n");
                    System.out.println("Informe os dados do setor: ");
                    System.out.print("Nome: ");
                    nomeSetor = input.nextLine();
                    setores.inserir(nomeSetor);
                    break;
                case 2:
                    if (!setores.isEmpty()) {
                        setores.listarSetores();
                        System.out.print("Informe de qual setor deseja alterar o status: ");
                        nomeSetor = input.nextLine();
                        setores.alteraStatus(nomeSetor);
                    }
                    break;
                case 3:
                    if (!setores.isEmpty()) {
                        setores.listarSetores();
                        System.out.print("Informe de qual setor deseja entrar na fila: ");
                        nomeSetor = input.nextLine();
                        setores.pegarSenha(nomeSetor);
                    }
                    break;
                case 4:
                    if (!setores.isEmpty()) {
                        System.out.print("Informe de qual setor deseja atender alguém: ");
                        nomeSetor = input.nextLine();
                        setores.atenderAlguem(nomeSetor);
                    }
                    break;
                case 5:
                    if (!setores.isEmpty()) {
                        setores.listarSetoresComFila();
                    }
                    break;
                default:
            }
        } while (opGeral != 0);

        System.out.println("\n\n");
    }

}

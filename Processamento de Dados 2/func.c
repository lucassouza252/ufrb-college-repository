#include "func.h"

int main(){

    short opcao;
    printf("----Bem Vindo ao Nosso Condominio!!!------\n\n");

    do{

        printf("Digite a opcao desejada!!\n\n");
        printf("1 - Cadastrar Apartamento\n");
        printf("2 - Calcular Area Total dos Apartamentos\n");
        printf("3 - Calcular a Arrecadacao Total do Condominio\n");
        printf("4 - Imprimir Dados do(s) Apartamento(s) com Mais Pessoas\n");
        printf("5 - Salvar Dados\n");
        printf("6 - Carregar Dados\n");
        printf("7 - SAIR\n");

        fflush(stdin);
        scanf("%i", &opcao);

        switch(opcao){
        case 1:
            system("cls");
            cadastrar_apartamento(1);
            break;
        case 2:
            system("cls");
            calcular_area();
            break;
        case 3:
            system("cls");
            calcular_arrecadacao();
            break;
        case 4:
            system("cls");
            imprimir_dados();
            break;
        case 5:
            system("cls");
            salvar_dados();
            break;
        case 6:
            system("cls");
            carregar_dados();
            break;
        case 7:
            system("cls");
            printf("Obrigado Pela Sua Atencao!!\n");//Para o Loop
            break;
        default:
            system("cls");  //Evita opcoes invalidas
        }

    }while(opcao != 7);


return 0;
}

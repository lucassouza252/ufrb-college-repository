#ifndef FUNC_H_
#define FUNC_H_

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define TAM 10


FILE *arq;
typedef struct dono{

    char nome[30];
    char cpf[20];
}Dono;

typedef struct apartamento{

    Dono _dono;
    int numero_do_ap;
    float area_do_ap;
    int numero_de_moradores;
    float valor_do_cond;
}Apartamento;

Apartamento apartamento[TAM];
int i = 0,A;



void cadastrar_apartamento(int n){
    short OP;
    int j =0;
    arq=fopen("Apartamentos.bin","a+b");
	if(!arq){
	printf("Erro na abertura arquivo\n");
	}
    for(i=0;i<TAM;i++){
    	if(apartamento[i].valor_do_cond>0){
    		j++;
		}

}
	fclose(arq);
	i=j;
	//printf("%i",i); So para teste
    if(i >= TAM){
        printf("Numero de Apartamentos Esgotados.\n");
        fflush(stdin);
        char so_pra_voltar = getchar();
        system("cls");;
    }
	do{
    Apartamento ap;

    fflush(stdin);
    printf("--Cadastro de Apartamento---\n");
    printf("Por Favor, Digite o Nome do Proprietario: ");
    fgets(apartamento[i]._dono.nome, 30, stdin);
    fflush(stdin);
    printf("Por Favor, Digite o CPF do Proprietario: ");
    fgets(apartamento[i]._dono.cpf, 20, stdin);
    fflush(stdin);
    printf("Por Favor, Digite o Numero do Apartamento: ");
    scanf("%d", &apartamento[i].numero_do_ap);
    fflush(stdin);
    printf("Por Favor, Digite a Area do Apartamento: ");
    scanf("%f", &apartamento[i].area_do_ap);
    fflush(stdin);
    printf("Por Favor, Digite o Numero de Moradores do Apartamento: ");
    scanf("%d", &apartamento[i].numero_de_moradores);
    fflush(stdin);
    printf("Por Favor, Digite o Valor do Condominio: ");
    scanf("%f", &apartamento[i].valor_do_cond);
    fflush(stdin);
    printf("--Apartamento Cadastrado com Sucesso--");

    i++;

    fflush(stdin);
    char so_pra_voltar = getchar();
    system("cls");
	printf("1-Fazer um novo cadastro\n2-Voltar ao menu\n ");
	scanf("%i",&OP);
	system("cls");
	}while(OP==1);

}

void calcular_area(){

    if(i == 0){
        printf("Nenhum Apartamento Cadastrado.\n");
        fflush(stdin);
        char so_pra_voltar = getchar();
        system("cls");
    }
    else{
        printf("--Calcular Area Total dos Apartamentos--\n");
        printf("Calculando...\n\n");

        int j;
        float area_total = 0.0;
        for(j = 0; j < i; j++){
            area_total += apartamento[j].area_do_ap;
        }

        printf("Area dos Apartamentos: %0.2f Metros Quadrados\n", area_total);
    }

    fflush(stdin);
    char so_pra_voltar = getchar();
    system("cls");

}

void calcular_arrecadacao(){

    if(i == 0){
        printf("Nenhum Apartamento Cadastrado.\n");
        fflush(stdin);
        char so_pra_voltar = getchar();
        system("cls");
    }
    else{
        printf("--Calcular Arrecadacao Total do Condominio--\n");
        printf("Calculando...\n\n");

        int j;
        float valot_total = 0.0;
        for(j = 0; j < i; j++){
            valot_total += apartamento[j].valor_do_cond;
        }

        printf("Valor Total da Arrecadacao: R$%0.2f.\n", valot_total);
    }

    fflush(stdin);
    char so_pra_voltar = getchar();
    system("cls");
}

void imprimir_dados(){

    if(i == 0){
        printf("Nenhum Apartamento Cadastrado.\n");
        fflush(stdin);
        char so_pra_voltar = getchar();
        system("cls");
    }
    else{
        printf("--Imprimir Dados Dos Apartamentos--\n");
        printf("Calculando... So um Instante...\n\n");

        	int maior = 0;

		for (i=0;i<11;i++){
			if (maior < apartamento[i].numero_de_moradores ){
				maior = apartamento[i].numero_de_moradores;

			}
			else
			maior = maior ;}


        for(i = 0; i < TAM; i++){
            if(maior==apartamento[i].numero_de_moradores){
            printf("Nome do Proprietario: %s", apartamento[i]._dono.nome);
            printf("CPF do Proprietadio: %s", apartamento[i]._dono.cpf);
            printf("Numero do Apartamento: %i\n", apartamento[i].numero_do_ap);
            printf("Area do Apartamento: %0.2f Metros Quadrados\n", apartamento[i].area_do_ap);
            printf("Numero de Moradores: %i\n", apartamento[i].numero_de_moradores);
            printf("Valor do Condominio: R$%0.2f\n\n\n", apartamento[i].valor_do_cond);
            }
        }
    }

    fflush(stdin);
    char so_pra_voltar = getchar();
    system("cls");
}

void salvar_dados(){
	
	short j=0;
	arq=fopen("Apartamentos.bin","ab");
	if(!arq){
	printf("Erro na abertura arquivo\n");
	}
		for(j=0;j<i;j++){
				fwrite(&apartamento[j],sizeof(struct apartamento),1,arq);}
		rewind(arq);
	fclose(arq);
	
	printf("arquivo salvo com sucesso!!");
	fflush(stdin);
    char so_pra_voltar = getchar();
    system("cls");
}

void carregar_dados(){
	
    arq=fopen("Apartamentos.bin","rb");
	if(!arq){
	printf("Erro na abertura arquivo\n");
	}
	i=0;
	A=0;
	while(fread(&apartamento[A],sizeof(struct apartamento),1,arq)!=NULL){
	 				A++;
					i++;
	}
	fclose(arq);

	printf("arquivo carregado com sucesso!!");
    fflush(stdin);
	char so_pra_voltar = getchar();
    system("cls");

}

#endif //FUNC_H_

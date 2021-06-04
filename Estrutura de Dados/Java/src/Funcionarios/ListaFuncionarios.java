/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionarios;

/**
 *
 * @author lucas
 */
public class ListaFuncionarios {
    public Funcionarios primeiro;
    public Funcionarios ultimo;
    
    public ListaFuncionarios(){
        this.ultimo = null;
        this.primeiro = null;
    }
    
    // Inserir no final da lista
    public void inserir(String nome, double salario, int matricula){
        Funcionarios novo = new Funcionarios(nome, salario, matricula);
        
        if (primeiro == null){
            primeiro = novo;
            ultimo = novo;
        }
        else{
            novo.anterior = ultimo;
            ultimo.proximo = novo;
            ultimo = novo;
        }
    }
    
    // Busca por matricula. Auxilia para inserir lista de dependencia por agregação.
    public Funcionarios encontrar(int matricula){
        Funcionarios auxiliar = primeiro;
        
        if(vazio()){
            System.out.println("Lista Vazia!");
            return null;
        }
        
        while(auxiliar != null && matricula != auxiliar.matricula){
            auxiliar = auxiliar.proximo;
        }
        
        if(auxiliar == null){
            System.out.println("Funcionario não encontrado!");
            return null;
        }
        else{
            return auxiliar;
        }
    }
    
    public void printarLista(){
        Funcionarios auxiliar = primeiro;
        
        while(auxiliar != null){
            auxiliar.printarFuncionario();
            auxiliar = auxiliar.proximo;
        }
    }
    
    public void remover(){
        if(this.vazio()){
            System.out.println("Lista Vazia!");
        }
        else{
            ultimo.anterior.proximo = null;
            ultimo = ultimo.anterior;
        }
    }
    
    public boolean vazio(){
        return primeiro == null;
    }
}

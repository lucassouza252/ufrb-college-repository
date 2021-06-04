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
public class ListaDependentes {
    public Dependentes primeiro;
    
    public ListaDependentes(){
        primeiro = null;
    }
    
    // Inserir no inicio da lista
    public void inserir(String nome){
        Dependentes novo = new Dependentes(nome);
        
        if(primeiro == null){
            primeiro = novo;
        }
        else{
            novo.proximo = primeiro;
            primeiro = novo;
        }
    }
    
    public void printarLista(){
        Dependentes auxiliar = primeiro;
        
        while(auxiliar != null){
            auxiliar.printarDependentes();
            auxiliar = auxiliar.proximo;
        }
    }
    
    public void remover(){
        if(this.vazio()){
            System.out.println("Lista Vazia!");
        }
        else{
            primeiro = primeiro.proximo;
        }
    }
    
    public boolean vazio(){
        
        return primeiro == null;        
    }
}

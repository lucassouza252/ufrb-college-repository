/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDuplamenteEncadeada;

/**
 *
 * @author lucas
 */
public class ListaDuplamenteEncadeada {

    public Node inicio = null;
    public Node fim = null;
    
    public void inserirNoInicio(int dado){
        Node novoNo = new Node();
        novoNo.data = dado;
        
        if(inicio == null){
            inicio = novoNo;
            fim = novoNo;
            
        }
        else{
            novoNo.anterior = null;
            inicio.anterior = novoNo;
            novoNo.proximo = inicio;
            inicio = novoNo;
        }
    }
    
    public void inserirNoFim(int dado){
        Node novoNo = new Node();
        novoNo.data = dado;
        
        if(inicio == null){
            this.inserirNoInicio(dado);
        }
        else{
            novoNo.proximo = null;
            novoNo.anterior = fim;
            fim.proximo = novoNo;
            fim = novoNo;
        }
    }
    
    public void printar(){
        Node aux = inicio;
        
        while(aux != null){
            System.out.println("Dado: " + aux.data);
            aux = aux.proximo;
        }
    }
}

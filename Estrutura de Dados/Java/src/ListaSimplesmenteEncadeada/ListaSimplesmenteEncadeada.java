/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaSimplesmenteEncadeada;

/**
 *
 * @author lucas
 */
public class ListaSimplesmenteEncadeada {

    public Node inicio = null;

    public void inserir(int dado) {
        Node atual = new Node();

        if (inicio == null) {
            atual.data = dado;
            atual.proximo = null;
            inicio = atual;
        } else {
            atual.data = dado;
            atual.proximo = inicio;
            inicio = atual;
        }
    }

    public void inserirEmOrdem(int dado) {
        Node novo = new Node();
        Node aux = inicio;
        Node anterior = null;

        if (inicio == null) {
            this.inserir(dado);
        } 
        else {
            while (aux != null && dado > aux.data) {
                anterior = aux;
                aux = anterior.proximo;
            }

            if (anterior == null) {
                this.inserir(dado);
            } 
            else {
                novo.data = dado;
                anterior.proximo = novo; // Funciona porque o anterior tem a referencia, 
                                        //entao nao precisa igualar ao inicio porque referencia é a mesma.
            }
        }
    }

    public void printar() {
        Node aux = inicio;
        
        while (aux != null) {
            System.out.println("Dado: " + aux.data);
            aux = aux.proximo;
        }
    }
    
    public void remover(int dado){
        Node anterior = null;
        Node aux = inicio;
        
        while(aux != null && aux.data != dado){
            anterior = aux;
            aux = anterior.proximo;
        }
        
        if(anterior == null){
            inicio = aux.proximo;
        }
        else{
            
            if(anterior.proximo == null){
                System.out.println("Valor nao existe!");
            }
            else{
                anterior.proximo = aux.proximo;
            }
            
        }
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fila;

/**
 *
 * @author lucas
 */
public class Fila {
    
    public Node primeiro;
    public Node ultimo;
    
    public Fila()
    {
        this.primeiro = null;
        this.ultimo = null;
    }
    
    public void enqueue(int dado)
    {
        Node novo = new Node(dado);
        
        if(this.primeiro == null)
        {
            this.primeiro = novo;
            this.ultimo = novo;
        }
        else
        {
            this.ultimo.proximo = novo;
            this.ultimo = novo;
        }
    } 
    
    public int peek()
    {
        if(this.primeiro == null)
        {
            System.out.println("Lista Vazia!");
            return -1;
        }
        else
        {
            return this.primeiro.data;
        }
    }
    
    public int dequeue()
    {
        if(this.primeiro == null)
        {
            System.out.println("Lista Vazia!");
            return -1;
        }
        else
        {
            int aux = this.primeiro.data;
            this.primeiro = this.primeiro.proximo;
            return aux;
        }
    }
    
    public void percorrer()
    {
        Node aux = this.primeiro;
        
        while(aux != null)
        {
            System.out.println(aux.data);
            aux = aux.proximo;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pilha;

/**
 *
 * @author lucas
 */
public class Pilha {
    
    public Node topo;
    
    public Pilha()
    {
        this.topo = null;
    }
    
    public void push(int dado)
    {
        Node novo = new Node(dado);
        
        if(topo == null)
        {
            this.topo = novo;
        }
        else
        {
            novo.proximo = this.topo;
            this.topo = novo;
        }
        
    }
    
    public int pop()
    {
        if(this.topo == null)
        {
            System.out.println("Lista Vazia!");
            return -1;
        }
        else
        {
            int aux = this.topo.data;
            this.topo = this.topo.proximo;
            return aux;
        }
    }
    
    public int top()
    {
        if(this.topo == null)
        {
            System.out.println("Lista Vazia!");
            return -1;
        }
        else
        {
            return this.topo.data;
        }
    }
    
    public void pull(int dado)
    {
        if(this.topo == null)
        {
            System.out.println("Lista Vazia!");
        }
        else
        {
            this.topo.data = dado;
        }
    }
}

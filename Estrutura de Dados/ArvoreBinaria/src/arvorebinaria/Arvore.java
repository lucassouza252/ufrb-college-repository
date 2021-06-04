/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;

/**
 *
 * @author lucas
 */
public class Arvore {
    public Node raiz;
    
    public Arvore()
    {
        this.raiz = null;
    }
    
    public Node inserir(Node atual, Node novo)
    {
        if(atual != null)
        {
            if(novo.dado < atual.dado)
            {
                atual.esquerda = this.inserir(atual.esquerda, novo);
            }
            else
            {
                if(atual.dado > novo.dado)
                {
                    atual.direita = this.inserir(atual.direita, novo);
                }
                else
                {
                    return null;
                }
            }
        }
        else
        {
            atual = novo;
        }
        
        return atual;
    }
    
    public void novoNo(int dado)
    {
        Node no = new Node(null, null, dado);
        if(raiz == null)
        {
            raiz = no;
        }
        else
        {
            this.inserir(no, raiz);
        }
    }
    
    public void percorrerInOrdem(Node no)
    {
     if(!this.estaVazio())
        {
            this.percorrerInOrdem(no.esquerda);
            System.out.println(no.dado);
            this.percorrerInOrdem(no.direita);
        }   
    }
    
    public void percorrerPreOrdem(Node no)
    {
        if(!this.estaVazio())
        {
            System.out.println(no.dado);
            this.percorrerPreOrdem(no.esquerda);
            this.percorrerPreOrdem(no.direita);
        }
    }
    
    public void percorrerPosOrdem(Node no)
    {
        if(!this.estaVazio())
        {
            this.percorrerPosOrdem(no.esquerda);
            this.percorrerPosOrdem(no.direita);
            System.out.println(no.dado);
        }
    }
    
    public Node buscarInOrdem(int dado)
    {
        if(this.estaVazio())
        {
            return null;
        }
        else
        {
            if()
                    
        }
    }
    
    public void buscarPerOrdem()
    {
        
    }
    
    public void buscarPosOrdem()
    {
        
    }
    
    public boolean estaVazio()
    {
        return raiz == null;
    }
}

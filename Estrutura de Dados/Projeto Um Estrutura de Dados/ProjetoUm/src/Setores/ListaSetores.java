/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Setores;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class ListaSetores {
    private Setores primeiro;
    private Setores ultimo;
    
    public ListaSetores()
    {
        this.primeiro = null;
        this.ultimo = null;
    }
    
    public void inserir(String nome){
        Setores novo = new Setores(nome);
        
        if (this.primeiro == null){
            this.primeiro = novo;
            this.ultimo = novo;
        }
        else{
            novo.setAnterior(ultimo);
            ultimo.setProximo(novo);
            ultimo = novo;
        }
    }
    
    public void remover(String nome){
        Setores aux = primeiro;
        Setores anterior = null;

        while(aux != null && aux.getNome() != nome)
        {
            anterior = aux;
            aux = anterior.getProximo();
        }
        
        if(anterior == null)
        {
            primeiro = aux.getProximo();
        }
        else{
            anterior.setProximo(aux.getProximo());
        }
    }
    
     public boolean estaVazio(){
        return primeiro == null;
    }
     
    public ArrayList<Setores> toArray()
    {
        ArrayList<Setores> lista = new ArrayList<>();
        Setores aux = this.primeiro;
        while(aux != null)
        {
            lista.add(aux);
            aux = aux.getProximo();
        }
        
        return lista;
    }
    
    public ArrayList<String> toArrayNome()
    {
        ArrayList<String> lista = new ArrayList<>();
        Setores aux = this.primeiro;
        while(aux != null)
        {
            lista.add(aux.getNome());
            aux = aux.getProximo();
        }
        
        return lista;
    }
}

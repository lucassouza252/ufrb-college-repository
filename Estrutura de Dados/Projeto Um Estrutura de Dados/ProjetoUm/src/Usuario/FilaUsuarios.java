/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.util.ArrayList;

public class FilaUsuarios {
    
    private Usuario primeiro;
    private Usuario ultimo;
    
    public FilaUsuarios()
    {
        this.primeiro = null;
        this.ultimo = null;
    }
    
    public void enqueue(String matricula, String cpf)
    {
        Usuario novo = new Usuario(matricula, cpf);
        
        if(this.primeiro == null)
        {
            this.primeiro = novo;
            this.ultimo = novo;
        }
        else
        {
            this.ultimo.setProximo(novo);
            this.ultimo = novo;
        }
    }
    
    public void enqueue(String cpf, String matricula, String chamada)
    {
        Usuario novo = new Usuario(matricula, cpf, chamada);
        
        if(this.primeiro == null)
        {
            this.primeiro = novo;
            this.ultimo = novo;
        }
        else
        {
            this.ultimo.setProximo(novo);
            this.ultimo = novo;
        }
    }
    
    public Usuario dequeue()
    {
        if(this.primeiro == null)
        {
            System.out.println("Lista Vazia!");
            return null;
        }
        else
        {
            Usuario user = this.primeiro;
            this.primeiro = this.primeiro.getProximo();
            return user;
        }
    }
    
    public void remover(String mat)
    {
        Usuario aux = this.primeiro;
        Usuario anterior = null;
        
        while(aux != this.ultimo)
        {
            anterior = aux;
            aux = aux.getProximo();
        }
        
        if(anterior == null)
        {
            primeiro = aux.getProximo();
        }
        else{
            anterior.setProximo(aux.getProximo());
        }
    }
    
    public void percorrer()
    {
        Usuario aux = this.primeiro;
        
        while(aux != null)
        {
            System.out.println(aux.getMatricula() + " " + aux.getCpf() + " " + aux.getChamada());
            aux = aux.getProximo();
        }
    }
    
    public ArrayList<Usuario> toArray()
    {
        ArrayList<Usuario> usua = new ArrayList<>();
        Usuario aux = this.primeiro;
        
        while(aux != null)
        {
            usua.add(aux);
            aux = aux.getProximo();
        }
        
        return usua;
    }
    
    public ArrayList<ArrayList<String>> toArrayString()
    {
        ArrayList<String> usua; 
        ArrayList<ArrayList<String>> fila = new ArrayList<>();
        
        Usuario aux = this.primeiro;
        while(aux != null)
        {
            usua = new ArrayList<String>();
            
            usua.add(aux.getMatricula());
            usua.add(aux.getCpf());
            usua.add(aux.getChamada());
            
            fila.add(usua);
            
            aux = aux.getProximo();
        }
        
        return fila;
    }
    
}
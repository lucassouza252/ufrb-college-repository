package Usuario;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 */
public class PilhaChamada {
    private Usuario topo;
    
    public PilhaChamada()
    {
        this.topo = null;
    }
    
    public void push(String matricula, String cpf, String chamada)
    {
        Usuario novo = new Usuario(matricula, cpf, chamada);
        
        if(this.topo == null)
        {
            this.topo = novo;
        }
        else
        {
            novo.setProximo(this.topo);
            this.topo = novo;
        }
    }
    
    public Usuario pop()
    {
        if(this.topo == null)
        {
            System.out.println("Lista Vazia!");
            return null;
        }
        else
        {
            Usuario aux = new Usuario(this.topo.getMatricula(), this.topo.getCpf(), this.topo.getChamada());
            this.topo = this.topo.getProximo();
            return aux;
        }
    }
    
    public ArrayList<Usuario> toArray()
    {
        Usuario aux = this.topo;
        ArrayList<Usuario> array = new ArrayList<>();
        
        while(aux != null)
        {
            array.add(aux);
            aux = aux.getProximo();
        }
        
        return array;
    }
}

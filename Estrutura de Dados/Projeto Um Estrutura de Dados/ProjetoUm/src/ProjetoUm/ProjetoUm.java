/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoUm;

import Setores.JSetores;
import Usuario.FilaUsuarios;
import Usuario.JLoginUsuario;
import Usuario.JUsuarios;
import Usuario.PilhaChamada;
import Usuario.Usuario;
import java.util.ArrayList;

public class ProjetoUm {
    
    public static void main(String[] args) 
    {
        
        JUsuarios juser = new JUsuarios();
        JSetores jsetor = new JSetores(juser);
        
        jsetor.setVisible(true);
        juser.setVisible(true);
        
        /*
        PilhaChamada pilha = new PilhaChamada();
        
        pilha.push("1", "1", "1");
        pilha.push("2", "2", "2");
        pilha.push("3", "3", "3");
        pilha.push("4", "4", "4");
        
        for(Usuario s: pilha.toArray())
        {
            System.out.println(s.getMatricula());
        }*/
    }
}

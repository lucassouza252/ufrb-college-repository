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
public class Dependentes {
    public String nome;
    public Dependentes proximo; // Link para endereço do proximo dependente
    
    public Dependentes(String nome){
        this.nome = nome;
        this.proximo = null;
    }
    
    public void printarDependentes(){
        System.out.println("Dependente: " + this.nome);    
    }
}

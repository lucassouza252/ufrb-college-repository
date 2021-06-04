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
public class Funcionarios {
    public String nome;
    public double salario;
    public int matricula;
    
    public ListaDependentes lista; // Lista de dependentes, simplesmente encadeada
    
    public Funcionarios proximo; // Link para o endereço do proximo Funcionario
    public Funcionarios anterior; // Link para o endereço do Funcionaro anterior
    
    public Funcionarios(String nome, double salario, int matricula){
        this.nome = nome;
        this.salario = salario;
        this.matricula = matricula;
        this.anterior = null;
        this.proximo = null;
        this.lista = new ListaDependentes();
    }
    
    public void printarFuncionario(){
        if(this.temDependentes()){
            System.out.println("Funcionario: " + this.nome);
            System.out.println("Salario: " + this.salario);
            System.out.println("Matricula: " + this.matricula);
            
            this.printarDependentes();
            System.out.println(" ");
        }
        else{
            System.out.println("Funcionario: " + this.nome);
            System.out.println("Salario: " + this.salario);
            System.out.println("Matricula: " + this.matricula);
            System.out.println(" ");
        }
        
    }
    
    public void inserirDependentes(String nome){
        this.lista.inserir(nome);
    }
    
    public boolean temDependentes(){
        return !(lista == null);
    }
    
    public void printarDependentes(){
        this.lista.printarLista();
    }
}

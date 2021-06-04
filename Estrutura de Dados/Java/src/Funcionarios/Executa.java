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
public class Executa {
   
    public static void main(String[] args){
        ListaFuncionarios lis = new ListaFuncionarios();
        
        lis.inserir("Lucas", 1250.0, 12334);
        lis.inserir("Zels", 2500.0, 121212);
        lis.inserir("Teos", 3000.0, 323212);
        
        lis.printarLista();
        
        System.out.println("#------------------------");
        System.out.println(" ");
        
        lis.encontrar(121212).inserirDependentes("Sella");
        lis.encontrar(121212).inserirDependentes("Angela");
        lis.encontrar(121212).inserirDependentes("Meuri");
        
        lis.printarLista();
        
    }
}

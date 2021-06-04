/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDuplamenteEncadeada;

/**
 *
 * @author lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ListaDuplamenteEncadeada lis = new ListaDuplamenteEncadeada();
        
        lis.inserirNoFim(5);
        lis.inserirNoFim(2);
        lis.inserirNoFim(9);
        lis.inserirNoFim(1);
        lis.inserirNoFim(3);
        lis.inserirNoFim(7);
        
        lis.printar();
        System.out.println("#-----------------------------------");
        
        lis.inserirNoInicio(5);
        lis.inserirNoInicio(2);
        lis.inserirNoInicio(9);
        lis.inserirNoInicio(1);
        lis.inserirNoInicio(3);
        lis.inserirNoInicio(7);
        
        lis.printar();
    }
    
}

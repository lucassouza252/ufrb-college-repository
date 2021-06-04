/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaSimplesmenteEncadeada;

/**
 *
 * @author lucas
 */
public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
       ListaSimplesmenteEncadeada lis = new ListaSimplesmenteEncadeada();
       
       lis.inserirEmOrdem(4);
       lis.inserirEmOrdem(3);
       lis.inserirEmOrdem(5);
       lis.inserirEmOrdem(6);
       
       lis.printar();
       
       System.out.println("#----------------------------------------");
        
       lis.remover(7);
       
       lis.printar();
    }
}

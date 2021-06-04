/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pilha;

/**
 *
 * @author lucas
 */
public class Main 
{
    public static void main(String[] args)
    {
        Pilha pil = new Pilha();
        
        pil.push(1);
        pil.push(2);
        pil.push(3);
        
        System.out.println("Topo: " + pil.top());
        pil.pop();
        System.out.println("Topo: " + pil.top());
        pil.pop();
        System.out.println("Topo: " + pil.top());
        
    }
}

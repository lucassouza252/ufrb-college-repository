/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fila;

/**
 *
 * @author lucas
 */
public class Main {
    public static void main(String[] args)
    {
        Fila fil = new Fila();
        
        fil.enqueue(1);
        fil.enqueue(2);
        fil.enqueue(3);
        fil.enqueue(4);
        
        fil.percorrer();
        System.out.println("Frente: " + fil.peek());
        fil.dequeue();
        fil.dequeue();
        fil.dequeue();
        fil.percorrer();
    }
}

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
public class Node {
    public int data;
    public Node proximo;
    
    public Node(int dado)
    {
        this.data = dado;
        this.proximo = null;
    }
}

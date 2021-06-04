package arvorebinaria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 */
public class Node {
    public Node esquerda;
    public Node direita;
    public int dado;
    
    public Node(Node esq, Node dir, int dado)
    {
        esquerda = esq;
        direita = dir;
        this.dado = dado;
    }
}

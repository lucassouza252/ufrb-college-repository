/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.util.ArrayList;

public class Usuario{
    
    private String cpf;
    private String matricula;
    private String chamada;
    private Usuario proximo;

    public Usuario() {}

    public Usuario(String matricula, String cpf) {
        this.proximo = null;
        this.matricula = matricula;
        this.cpf = cpf;
    }
    
    public Usuario(String matricula, String cpf, String chamada) {
        this.proximo = null;
        this.matricula = matricula;
        this.cpf = cpf;
        this.chamada = chamada;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getChamada() {
        return chamada;
    }

    public void setChamada(String chamada) {
        this.chamada = chamada;
    }

    public Usuario getProximo() {
        return proximo;
    }

    public void setProximo(Usuario proximo) {
        this.proximo = proximo;
    }

}
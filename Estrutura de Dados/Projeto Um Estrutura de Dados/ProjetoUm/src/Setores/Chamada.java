/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Setores;

import java.util.Date;

public class Chamada{

//    Date data = new Date();
//    SimpleDateFormat formatbrasil;
//    String dataatual, horaatual;
    private Date horario;
    private String senha;

    public Chamada() {
    }

    public Chamada(String senha) {
//        formatbrasil = new SimpleDateFormat("dd/MM/yyyy");
//        dataatual = formatbrasil.format(data);
//        formatbrasil = new SimpleDateFormat("H:m:s");
//        horaatual = formatbrasil.format(data);
//this.horario = horaatual;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Chamada{" + "senha=" + senha + '}';
    }

}
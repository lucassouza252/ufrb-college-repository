package sistemadegerenciamento;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Kelly
 */
public class Chamada extends NodoGeral {

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

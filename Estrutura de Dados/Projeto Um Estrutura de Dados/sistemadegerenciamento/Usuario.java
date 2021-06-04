package sistemadegerenciamento;

/**
 *
 * @author Kelly
 */
public class Usuario extends NodoGeral{
    
private String cpf;
private String matricula;
private Chamada chamada;

    public Usuario() {}

    public Usuario(String cpf, String matricula, Chamada chamada) {
        this.cpf = cpf;
        this.matricula = matricula;
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

    public Chamada getChamada() {
        return chamada;
    }

    public void setChamada(Chamada chamada) {
        this.chamada = chamada;
    }

}

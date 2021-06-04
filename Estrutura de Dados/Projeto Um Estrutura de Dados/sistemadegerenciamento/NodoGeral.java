package sistemadegerenciamento;

/**
 *
 * @author Kelly
 */
public class NodoGeral {
     NodoGeral anterior;
     NodoGeral proximo;

    public NodoGeral() {
        anterior = null;
        proximo = null;
    }

    public NodoGeral getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoGeral anterior) {
        this.anterior = anterior;
    }

    public NodoGeral getProximo() {
        return proximo;
    }

    public void setProximo(NodoGeral proximo) {
        this.proximo = proximo;
    }
    
    
}

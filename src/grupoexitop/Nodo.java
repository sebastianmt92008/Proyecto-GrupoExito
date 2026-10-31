
package grupoexitop;

public class Nodo {
    
    private Cliente dato;
    private Nodo izq;
    private Nodo der;

    public Nodo(Cliente dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }

    public Cliente getDato() {
        return dato;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
    
    
 
}

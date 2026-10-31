
package grupoexitop;


public class ArbolBinarioBusqueda {
    
    private Nodo cabeza;
    private int tamanio;
    
    private Nodo raiz;
 
    public ArbolBinarioBusqueda() {
        raiz = null;
    }
 
    public boolean estaVacio() {
        return raiz == null;
    }
 
    public Nodo getRaiz() {
        return raiz;      
    }
    
    
    public boolean insertar(Cliente cliente) {
        
        if (buscar(cliente.getCedula()) != null) {
            return false;
        }
        raiz = insertar(raiz, cliente);
        return true;
    }

    private Nodo insertar(Nodo n, Cliente cliente) {
        if (n == null) {
            return new Nodo(cliente);
        }
        
        long cedulaActual = n.getDato().getCedula();
        
        if (cliente.getCedula() < cedulaActual) {
            
            n.setIzq(insertar(n.getIzq(), cliente));
        } else if (cliente.getCedula() > cedulaActual) {
            
            n.setDer(insertar(n.getDer(), cliente));
        } else {
            
            System.out.println("La cedula ya esta registrada. Actualizando datos...");
        }
        
        return n;
    }
    
    public Cliente buscar(long cedula) {
        Nodo actual = raiz;
        
        while (actual != null) {
            long clave = actual.getDato().getCedula();
            
            if (cedula == clave) {
                return actual.getDato(); 
            }
            
            if (cedula < clave) {
                actual = actual.getIzq(); 
            } else {
                actual = actual.getDer(); 
            }
        }
        
        return null; 
    }
    
    public void inorden() {
    inorden(raiz);
    }

    private void inorden(Nodo n) {
        if (n == null) return;
        inorden(n.getIzq());
        System.out.println(n.getDato());
        inorden(n.getDer());
    }

    public void preorden() {
        preorden(raiz);
    }

    private void preorden(Nodo n) {
        if (n == null) return;
        System.out.println(n.getDato());
        preorden(n.getIzq());
        preorden(n.getDer());
    }

    public void postorden() {
        postorden(raiz);
    }

    private void postorden(Nodo n) {
        if (n == null) return;
        postorden(n.getIzq());
        postorden(n.getDer());
        System.out.println(n.getDato());
    }
    
    public void porNiveles() {
        int h = altura(raiz);
        for (int nivel = 0; nivel < h; nivel++) {
            imprimirNivel(raiz, nivel);
        }
    }

    private void imprimirNivel(Nodo n, int nivel) {
        if (n == null) return;
        if (nivel == 0) {
            System.out.println(n.getDato());
        } else {
            imprimirNivel(n.getIzq(), nivel - 1);
            imprimirNivel(n.getDer(), nivel - 1);
        }
    }
    
    public void eliminar(long cedula) {
    raiz = eliminar(raiz, cedula);
}

    private Nodo eliminar(Nodo n, long cedula) {
        if (n == null) return null;
        long clave = n.getDato().getCedula();
        if (cedula < clave) {
            n.setIzq(eliminar(n.getIzq(), cedula));
        } else if (cedula > clave) {
            n.setDer(eliminar(n.getDer(), cedula));
        } else {
            if (n.getIzq() == null) return n.getDer();
            if (n.getDer() == null) return n.getIzq();
        
            Nodo suc = minimoNodo(n.getDer());
            n.setDato(suc.getDato());
            n.setDer(eliminar(n.getDer(), suc.getDato().getCedula()));
        }
        return n;
    }   
    
    private Nodo minimoNodo(Nodo n) {
        while (n.getIzq() != null) {
            n = n.getIzq();
        }
        return n;
    }
    
    private Nodo maximo(Nodo n) {
        while (n.getDer() != null) {
            n = n.getDer();
        }
        return n;
    }
    
    public int altura() {
        return altura(raiz);
    }

    private int altura(Nodo n) {
        if (n == null) return 0;
        return 1 + Math.max(altura(n.getIzq()), altura(n.getDer()));
    }
    
    private int contarNodos(Nodo n) {
        if (n == null) return 0;
        return 1 + contarNodos(n.getIzq()) + contarNodos(n.getDer());
    }

    private int contarHojas(Nodo n) {
        if (n == null) return 0;
        if (n.getIzq() == null && n.getDer() == null) return 1;
        return contarHojas(n.getIzq()) + contarHojas(n.getDer());
    }   

    public int contarInternos() {
        return contarNodos(raiz) - contarHojas(raiz);
    }
    
    public int nivel(long cedula) {
        Nodo actual = raiz;
        int nivel = 0;
        while (actual != null) {
            long clave = actual.getDato().getCedula();
            if (cedula == clave) return nivel;
            actual = (cedula < clave) ? actual.getIzq() : actual.getDer();
            nivel++;
        }
        return -1;
    }
    
    public Cliente sucesor(long cedula) {
        Nodo actual = raiz;
        Cliente candidato = null;
        while (actual != null) {
            long k = actual.getDato().getCedula();
            if (cedula < k) {
                candidato = actual.getDato();
                actual = actual.getIzq();
            } else {
                actual = actual.getDer();
            }
        }
        return candidato;
    }
    
    public void dibujar() {
        dibujar(raiz, 0);
    }

    private void dibujar(Nodo n, int nivel) {
        if (n == null) return;
        dibujar(n.getDer(), nivel + 1);
        System.out.println("      ".repeat(nivel) + n.getDato().getCedula());
        dibujar(n.getIzq(), nivel + 1);
    }
    
    public void filtrarPorPuntos(int limite) {
    filtrarPorPuntos(raiz, limite);
}

    private void filtrarPorPuntos(Nodo n, int limite) {
        if (n == null) return;
        filtrarPorPuntos(n.getIzq(), limite);
        if (n.getDato().getPuntosAcumulados() < limite) {
            System.out.println(n.getDato());
        }
        filtrarPorPuntos(n.getDer(), limite);
    }

    public int totalPuntos() {
        return totalPuntos(raiz);
    }

    private int totalPuntos(Nodo n) {
        if (n == null) return 0;
        return n.getDato().getPuntosAcumulados()
            + totalPuntos(n.getIzq())
            + totalPuntos(n.getDer());
    }
}

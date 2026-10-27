
package grupoexitop;


public class ListaClientes {
    
    private Nodo cabeza;
    private int tamanio;
    
    public ListaClientes() {
        this.cabeza = null;
        this.tamanio = 0;
    }
    
    public boolean estaVacia(){
        return cabeza==null;
    }
    
    public void agregarCliente(Cliente cliente) {
        Nodo nuevo = new Nodo(cliente, null);
        if (estaVacia()) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }
    
    
    public Cliente buscarCliente(int cedula) {
        if (estaVacia()) {
            return null;
        }
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getDato().getCedula() == cedula) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public void mostrarClientes() {
        if (estaVacia()) {
            System.out.println("No hay clientes registrados en la lista.");
            return;
        }
        Nodo actual = cabeza;
        System.out.println("\n--- LISTA DE CLIENTES - PUNTOS COLOMBIA ---");
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }
    
}


package grupoexitop;

import java.io.*;
import java.util.ArrayList;


public class ArbolBinarioBusqueda {
    
    
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
    
    
    public void cargarCSV(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea = br.readLine(); // Salta el encabezado
            int cargados = 0;
        
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(",");
                try {
                    long cedula = Long.parseLong(p[0].trim());
                    String nombre = p[1].trim();
                    String correo = p[2].trim();
                    String ciudad = p[3].trim();
                    int puntosAcumulados = Integer.parseInt(p[4].trim());
                    double totalCompradoAnio = Double.parseDouble(p[5].trim());
                    String categoria = p[6].trim();

                    Cliente cliente = new Cliente(cedula, nombre, correo, ciudad, puntosAcumulados, totalCompradoAnio, categoria);
                
                    if (insertar(cliente)) {
                        cargados++;
                    } else {
                        System.out.println("Cedula repetida omitida: " + cedula);
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Linea con formato invalido o columnas incompletas: " + linea);
                }
            }
            System.out.println("¡Carga masiva finalizada! Clientes agregados al árbol: " + cargados);
        
        } catch (IOException e) {
            System.out.println("¡Error critico! No se encontro el archivo CSV en la raiz: " + e.getMessage());
        }
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
    
    public boolean eliminar(long cedula) {
        if (buscar(cedula) == null) return false;
        raiz = eliminar(raiz, cedula);
        return true;
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
    
    public Cliente minimo() {
        if (raiz == null) return null;
        return minimoNodo(raiz).getDato();
    }
    
    private Nodo minimoNodo(Nodo n) {
        while (n.getIzq() != null) {
            n = n.getIzq();
        }
        return n;
    }
    
    public Cliente maximo() {
        if (raiz == null) return null;
        return maximo(raiz).getDato();
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
    
    public int totalNodos() {
        return contarNodos(raiz);
    }
    
    private int contarNodos(Nodo n) {
        if (n == null) return 0;
        return 1 + contarNodos(n.getIzq()) + contarNodos(n.getDer());
    }
    
    public int totalHojas() {
        return contarHojas(raiz);
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
    
    public Cliente predecesor(long cedula) {
        Nodo actual = raiz;
        Cliente candidato = null;
        while (actual != null) {
            long k = actual.getDato().getCedula();
            if (cedula > k) {
                candidato = actual.getDato();
                actual = actual.getDer();
            } else {
                actual = actual.getIzq();
            }
        }
        return candidato;
    }
    
    public boolean actualizar(long cedula, String nombre, String correo, String ciudad) {
        Cliente c = buscar(cedula);
        if (c == null) return false;
        c.setNombre(nombre);
        c.setCorreo(correo);
        c.setCiudad(ciudad);
        return true;
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
    
    public void buscarPorRango(long min, long max) {
        buscarPorRango(raiz, min, max);
    }
    
    private void buscarPorRango(Nodo n, long min, long max) {
        if (n == null) return;
        long clave = n.getDato().getCedula();
        if (clave > min) {
            buscarPorRango(n.getIzq(), min, max);
        }
        if (clave >= min && clave <= max) {
            System.out.println(n.getDato());
        }
        if (clave < max) {
            buscarPorRango(n.getDer(), min, max);
        }
    }
    
    public void registrarCompra(long cedula, double valorCompra) {
        if (valorCompra <= 0) {
            System.out.println("El valor de la compra debe ser mayor que 0.");
            return;
        }
        
        Cliente c = buscar(cedula);
        if (c != null) {
            // Sumar al total comprado en el año
            c.setTotalCompradoAnio(c.getTotalCompradoAnio() + valorCompra);
            
            // 1 punto por cada $1.000
            int puntosNuevos = (int) (valorCompra / 1000);
            c.setPuntosAcumulados(c.getPuntosAcumulados() + puntosNuevos);
            
            // Actualizar categoría
            if (c.getTotalCompradoAnio() >= 5000000) {
                c.setCategoria("Oro");
            } else if (c.getTotalCompradoAnio() >= 2000000) {
                c.setCategoria("Plata");
            } else {
                c.setCategoria("Clasico");
            }
            
            System.out.println("¡Compra registrada! Puntos actuales: " + c.getPuntosAcumulados());
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
    
    public void redimirPuntos(long cedula, int puntosARedimir) {
        
        if (puntosARedimir <= 0) {
            System.out.println("Los puntos a redimir deben ser mayores que 0.");
            return;
        }
        
        Cliente c = buscar(cedula);
        if (c != null) {
            if (c.getPuntosAcumulados() >= puntosARedimir) {
                c.setPuntosAcumulados(c.getPuntosAcumulados() - puntosARedimir);
                System.out.println("¡Redención exitosa! Puntos restantes: " + c.getPuntosAcumulados());
            } else {
                System.out.println("Error: No tiene suficientes puntos.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
    
    public void top10() {
        ArrayList<Cliente> lista = new ArrayList<>();
        llenarLista(raiz, lista);

        int mostrar = Math.min(10, lista.size());
        for (int i = 1; i <= mostrar; i++) {
            int posMayor = 0;
            for (int j = 1; j < lista.size(); j++) {
                if (lista.get(j).getPuntosAcumulados() > lista.get(posMayor).getPuntosAcumulados()) {
                    posMayor = j;
                }
            }
            Cliente mayor = lista.remove(posMayor);
            System.out.println(i + ". " + mayor.getNombre() + " - " + mayor.getPuntosAcumulados() + " puntos");
        }
    }

    private void llenarLista(Nodo n, ArrayList<Cliente> lista) {
        if (n == null) return;
        llenarLista(n.getIzq(), lista);
        lista.add(n.getDato());
        llenarLista(n.getDer(), lista);
    }
    
    
}

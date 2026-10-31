
package grupoexitop;
import java.util.Scanner;
public class GrupoExitoP {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        
        arbol.insertar(new Cliente(40512345678L, "Ana", "ana@correo.com", "Medellín", 250000, 1200000.0, "VIP"));
        arbol.insertar(new Cliente(40500000001L, "Luis", "luis@correo.com", "Envigado", 90000, 450000.0, "Regular"));
        arbol.insertar(new Cliente(40599999999L, "Sara", "sara@correo.com", "Bello", 1200000, 3500000.0, "Platino"));
        
        boolean insertadoOtraVez = arbol.insertar(new Cliente(40512345678L, "Repetida", "rep@correo.com", "Itagüí", 0, 0.0, "Nueva"));
        System.out.println("¿Se pudo insertar la cédula repetida? " + insertadoOtraVez); // Debe imprimir false

        System.out.println("\n--- RECORRIDO INORDEN (Ordenados por cédula) ---");
        arbol.inorden();
        
        System.out.println("\nAltura del árbol: " + arbol.altura());
        
        
    }
    
}

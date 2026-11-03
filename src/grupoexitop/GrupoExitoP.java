
package grupoexitop;

import java.util.Scanner;
import java.io.*;
public class GrupoExitoP {

    public static int leerEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Error, por favor ingrese solo numeros.");
            sc.next();

        }
        int enteroValido = sc.nextInt();
        sc.nextLine();
        return enteroValido;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinarioBusqueda arbolExito = new ArbolBinarioBusqueda();

        int opcion;
        do {
            System.out.println("===== ÁRBOL DE CLIENTES - GRUPO ÉXITO =====");
            System.out.println("1. Insertar       2. Buscar         3. Eliminar");
            System.out.println("4. Inorden        5. Preorden       6. Postorden");
            System.out.println("7. Por niveles    8. Altura y conteos");
            System.out.println("9. Dibujar arbol  10. Cargar CSV de clients");
            System.out.println("--- OPERACIONES DEL NEGOCIO ---");
            System.out.println("11. Registrar compra (Acumular puntos)");
            System.out.println("12. Redimir puntos (Descontar saldo)");
            System.out.println("13. Mostrar Top 10 de clientes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero(sc);
        switch(opcion){
            //Insertar nodo al arbol
            case 1:{
                
                
                break;
            }
            //Buscar nodo por cedula
            case 2:{
                
                
                break;
            }
            //Eliminar nodo por cedula
            case 3:{
                
                
                break;
            }
            //mostrar datos con inorden
            case 4:{
                arbolExito.inorden();
                
                break;
            }
            // Mostrar datos con preorden
            case 5:{
                
                arbolExito.preorden();
                break;
            }
            //mostrar datos por postorden
            case 6:{
                
                arbolExito.postorden();
                break;
            }
            //Mostrar datos por niveles del arbol
            case 7:{
                
                arbolExito.porNiveles();
                break;
            }
            //Ver la altura y conteos del arbol
            case 8:{
                
                
                break;
            }
            //Dibujar el arbol
            case 9:{
                System.out.println("-----ARBOL DE CLIENTES GRUPO EXITO-----");
                arbolExito.dibujar();
                break;
            }
            //Cargar CSV de clientes
            case 10:{
                
                arbolExito.cargarCSV("clientes_exito.csv");
                break;
            }
             //registrar nueva compra y acumular puntos
            case 11:{
                
                
                break;
            }
            //Redimir puntos (descontarlos)
            case 12:{
                
                
                break;
            }
            //Mostrar top 10 de clientes
            case 13:{
                
                
                break;
            }
            
            case 0:{
                System.out.println("Saliendo del programa....");
                
                break;
            }
            default:{
                System.out.println("Opcion no encontrada, intente nuevamente.");
                break;
            }
        }
        } while (opcion != 0);
    }
    

}

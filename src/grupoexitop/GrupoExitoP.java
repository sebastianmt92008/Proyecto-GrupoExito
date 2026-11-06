
package grupoexitop;

import java.util.Scanner;
import java.io.*;
public class GrupoExitoP {
    
public static double leerDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println("Error, por favor ingrese solo numeros.");
            sc.next();

        }
        double doubleValido = sc.nextDouble();
        sc.nextLine();
        return doubleValido;
    }

public static int leerEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Error, por favor ingrese solo numeros.");
            sc.next();

        }
        int enteroValido = sc.nextInt();
        sc.nextLine();
        return enteroValido;
    }

    
    static long leerLong(Scanner sc) {
        while (!sc.hasNextLong()) {
            System.out.print(" Debes escribir un numero valido: ");
            sc.next();
        }
        long longValido = sc.nextLong();
        sc.nextLine(); 
        return longValido;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        int opcion;
        do {
            System.out.println("===== ARBOL DE CLIENTES - GRUPO EXITO =====");
            System.out.println("1. Insertar       2. Buscar         3. Eliminar");
            System.out.println("4. Inorden        5. Preorden       6. Postorden");
            System.out.println("7. Por niveles    8. Minimo y maximo");
            System.out.println("9. Altura y conteos  10. Buscar por rango");
            System.out.println("11. Dibujar arbol  12. Cargar CSV de clientes");
            System.out.println("--- OPERACIONES DEL GRUPO EXITO ---");
            System.out.println("13. Registrar compra (Acumular puntos)");
            System.out.println("14. Redimir puntos (Descontar saldo)");
            System.out.println("15. Mostrar Top 10 de clientes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            
            
                opcion = leerEntero(sc);
                
        switch(opcion){
            //Insertar nodo al arbol
            case 1:{
                System.out.println("Ingrese el numero de cedula: ");
                long cedula = leerLong(sc);
               
                System.out.print("Ingrese nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese correo: ");
                String correo = sc.nextLine();
                System.out.print("Ingrese ciudad: ");
                String ciudad = sc.nextLine();
                System.out.print("Ingrese puntos acumulados: ");
                int puntos = leerEntero(sc);
                System.out.print("Ingrese total comprado en el anio: ");
                double total = leerDouble(sc);
                
                System.out.print("Ingrese categoria (Clasico/Plata/Oro): ");
                String categoria = sc.nextLine();

                Cliente nuevo = new Cliente(cedula, nombre, correo, ciudad, puntos, total, categoria);
                if (arbol.insertar(nuevo)) {
                    System.out.println("Cliente insertado con exito.");
                } else {
                        System.out.println("Error: La cedula ya existe.");
                }
                
                break;
            }
            //Buscar nodo por cedula
            case 2:{
                
                System.out.print("Ingrese cedula a buscar: ");
                long cedulaBuscada = leerLong(sc);
                
                Cliente encontrado = arbol.buscar(cedulaBuscada);
                if (encontrado != null) {
                    System.out.println("Encontrado: " + encontrado);
                } else {
                        System.out.println("Cliente no encontrado.");
                }
                
                break;
            }
            //Eliminar nodo por cedula
            case 3:{
                
                System.out.print("Ingrese cedula a eliminar: ");
                long cedulaEliminar = leerLong(sc);
                
                arbol.eliminar(cedulaEliminar);
                System.out.println("Operacion de eliminacion ejecutada.");
        
                break;
            }
            //mostrar datos con inorden
            case 4:{
                System.out.println("\n--- RECORRIDO INORDEN ---");
                arbol.inorden();
                
                break;
            }
            // Mostrar datos con preorden
            case 5:{
                System.out.println("\n--- RECORRIDO PREORDEN ---");
                arbol.preorden();
                break;
            }
            //mostrar datos por postorden
            case 6:{
                System.out.println("\n--- RECORRIDO POSTORDEN ---");
                arbol.postorden();
                break;
            }
            //Mostrar datos por niveles del arbol
            case 7:{
                System.out.println("\n--- RECORRIDO POR NIVELES ---");
                arbol.porNiveles();
                break;
            }
            //Ver minimo y maximo
            case 8:{
                
                System.out.println("\n--- MINIMO Y MAXIMO ---");
                System.out.println("Minimo: " + arbol.minimo());
                System.out.println("Maximo: " + arbol.maximo());
                break;
            }
            //Ver la altura y conteos del arbol
            case 9:{
                System.out.println("\n--- ALTURA Y CONTEOS ---");
                System.out.println("Altura: " + arbol.altura());
                System.out.println("Total nodos: " + arbol.totalNodos());
                System.out.println("Total hojas: " + arbol.totalHojas());
                System.out.println("Nodos internos: " + arbol.contarInternos());
                break;
            }
            //buscar por rango
            case 10:{
                
                System.out.print("Cedula inicial: ");
                long minRango = leerLong(sc);
                System.out.print("Cedula final: ");
                long maxRango = leerLong(sc);
                
                arbol.buscarPorRango(minRango, maxRango);
                break;
            }
            //dibujar arbol
            case 11:{
                
                arbol.dibujar();
                break;
            }
            //Cargar CSV de clientes
            case 12:{
                
                arbol.cargarCSV("clientes_exito.csv");
                break;
            }
            
            //registrar compra
            case 13:{
                
                System.out.print("Ingrese cedula del cliente: ");
                long cCompra = leerLong(sc);
                System.out.print("Ingrese valor de la compra ($): ");
                double vCompra = leerDouble(sc);
                
                arbol.registrarCompra(cCompra, vCompra);
                break;
            }
            
            //redimir puntos
            case 14:{
                
                System.out.print("Ingrese cedula del cliente: ");
                long cRedimir = sc.nextLong();
                System.out.print("Ingrese puntos a redimir: ");
                int pRedimir = leerEntero(sc);
                
                arbol.redimirPuntos(cRedimir, pRedimir);
                break;
            }
            
            //top 10 mejores clientes
            case 15:{
                
                arbol.reportesGrupoExito();
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





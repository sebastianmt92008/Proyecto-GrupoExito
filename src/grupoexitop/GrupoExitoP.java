
package grupoexitop;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class GrupoExitoP {

    static Scanner sc = new Scanner(System.in);
    
    static long leerCedula(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextLong()) {
            System.out.print(" Debes escribir un numero de cedula valido: ");
            sc.next();
        }
        long cedula = sc.nextLong();
        sc.nextLine(); 
        return cedula;
    }
    
    static int leerEntero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.print(" Debes escribir un numero entero valido: ");
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }   

    static double leerDecimal(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) {
            System.out.print(" Debes escribir un numero valido: ");
            sc.next();
        }
        double valor = sc.nextDouble();
        sc.nextLine();
        return valor;
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
            
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
                
        switch(opcion){
            //Insertar nodo al arbol
            case 1:{
                long cedula = leerCedula(sc, "Ingrese cedula: ");
                System.out.print("Ingrese nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese correo: ");
                String correo = sc.nextLine();
                System.out.print("Ingrese ciudad: ");
                String ciudad = sc.nextLine();
                int puntos = leerEntero(sc, "Ingrese puntos acumulados: ");
                double total = leerDecimal(sc, "Ingrese total comprado en el ano: ");
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
                long cedulaBuscada = leerCedula(sc, "Ingrese cedula a buscar: ");
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
                
                long cedulaEliminar = leerCedula(sc, "Ingrese cedula a eliminar: ");
                if (arbol.eliminar(cedulaEliminar)) {
                    System.out.println("Cliente eliminado con exito.");
                } else {
                    System.out.println("No existe un cliente con esa cedula.");
                }
        
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
                
                long minRango = leerCedula(sc, "Cedula inicial: ");
                long maxRango = leerCedula(sc, "Cedula final: ");
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
                
                long cCompra = leerCedula(sc, "Ingrese cedula del cliente: ");
                double vCompra = leerDecimal(sc, "Ingrese valor de la compra ($): ");
                arbol.registrarCompra(cCompra, vCompra);
                break;
            }
            
            //redimir puntos
            case 14:{
                
                long cRedimir = leerCedula(sc, "Ingrese cedula del cliente: ");
                int pRedimir = leerEntero(sc, "Ingrese puntos a redimir: ");
                arbol.redimirPuntos(cRedimir, pRedimir);
                break;
            }
            
            //top 10 mejores clientes
            case 15:{
                System.out.println("\n--- TOP 10 MEJORES CLIENTES ---");
                arbol.top10();
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
        } else {
                System.out.println("Por favor digite un numero valido.");
                sc.next(); 
                opcion=-1;
            }
        } while (opcion != 0);
    }
    

}

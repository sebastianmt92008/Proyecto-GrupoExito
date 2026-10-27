
package grupoexitop;
import java.util.Scanner;
public class GrupoExitoP {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ListaClientes lista = new ListaClientes();
        int opcion;
        
        do{
            System.out.println("\n=== MENU PUNTOS COLOMBIA - GRUPO EXITO ===");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Buscar cliente por cedula");
            System.out.println("3. Mostrar todos los clientes");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch(opcion){
                case 1: {
                    System.out.print("Cedula: ");
                    int ced = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();
                    System.out.print("Correo: ");
                    String corr = sc.nextLine();
                    System.out.print("Ciudad: ");
                    String ciu = sc.nextLine();
                    System.out.print("Puntos iniciales: ");
                    int pts = sc.nextInt();
                    System.out.print("Total comprado en el año: ");
                    double total = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Categoría (Clasico/Plata/Oro): ");
                    String cat = sc.nextLine();

                    Cliente nuevo = new Cliente(ced, nom, corr, ciu, pts, total, cat);
                    lista.agregarCliente(nuevo);
                    System.out.println("¡Cliente registrado con exito!");
                    break;
                }
                case 2: {
                    System.out.print("Ingresa la cedula a buscar: ");
                    int cedulaBuscada = sc.nextInt();
                    Cliente encontrado = lista.buscarCliente(cedulaBuscada);
                    if (encontrado != null) {
                        System.out.println("¡Cliente encontrado! -> " + encontrado);
                    } else {
                        System.out.println("No se encontro ningun cliente con esa cedula.");
                    }
                    break;
                }
                case 3: {
                    lista.mostrarClientes();
                    break;
                }
                case 0: {
                    break;
                }
                default:
                    System.out.println("Opcion invalida");
            }
            System.out.println();
        }while(opcion!=0);
        sc.close();
        
    }
    
}

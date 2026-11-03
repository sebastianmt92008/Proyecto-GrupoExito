
package grupoexitop;
import java.util.Scanner;

import java.io.*;


public class GrupoExitoP {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        arbol.cargarCSV("clientes_exito.csv");
        
        arbol.inorden();
        
        
    }
    
}

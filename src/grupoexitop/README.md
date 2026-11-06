# Sistema de Gestion de Clientes - Grupo Exito

Proyecto academico para la asignatura Estructura de Datos en el Instituto Tecnologico Metropolitano (ITM). Implementa un Arbol Binario de Busqueda (ABB) propio en Java para la administracion y fidelizacion de clientes por numero de cedula (long).

## Clases

* **Cliente**
* **Nodo**
* **ArbolBinarioBusqueda**
* **GrupoExitoP**

## Operaciones

* **ABB**: Insertar, buscar, eliminar (hoja, un hijo, dos hijos), inorden, preorden, postorden, por niveles, minimo, maximo, altura, conteos (nodos, hojas, internos), rango con poda, sucesor, predecesor, actualizar y carga masiva desde CSV.
* **Fidelizacion Grupo Exito**:
  * Registrar compra: suma compras, acumula 1 punto por cada $1.000 y actualiza categoria (Plata >= $2.000.000, Oro >= $5.000.000).
  * Redimir puntos: descuenta puntos validando saldo suficiente.
  * Reporte Oro: listado ordenado por cedula.
  * Top 10: clientes con mayor acumulacion de puntos.

## Ejecucion

1. Ubicar `clientes_exito.csv` en la raiz del proyecto.
2. Compilar y ejecutar la clase `GrupoExitoP.java` en NetBeans (Java JDK 17+).

## Integrantes

* Sebastian Munoz Torres
* Luis Felipe Madariaga Cuello
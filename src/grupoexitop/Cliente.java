
package grupoexitop;


public class Cliente {
    
    
    private int cedula;
    private String nombre;
    private String correo;
    private String ciudad;
    private int puntosAcumulados;
    private double totalCompradoAnio;
    private String categoria;

    public Cliente(int cedula, String nombre, String correo, String ciudad, int puntosAcumulados, double totalCompradoAnio, String categoria) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.ciudad = ciudad;
        this.puntosAcumulados = puntosAcumulados;
        this.totalCompradoAnio = totalCompradoAnio;
        this.categoria = categoria;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }

    public double getTotalCompradoAnio() {
        return totalCompradoAnio;
    }

    public void setTotalCompradoAnio(double totalCompradoAnio) {
        this.totalCompradoAnio = totalCompradoAnio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public String toString() {
        return "Cliente [Cedula: " + cedula + ", Nombre: " + nombre + ", Ciudad: " + ciudad + 
               ", Puntos: " + puntosAcumulados + ", Categoría: " + categoria + "]";
    }
    
}

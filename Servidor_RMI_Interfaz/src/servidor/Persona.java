package servidor;

public class Persona {
    private int clave;
    private String nombre;
    private String cargo;
    private double sueldo;

    public Persona(int clave, String nombre, String cargo, double sueldo) {
        this.clave = clave;
        this.nombre = nombre;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public int getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSueldo() {
        return sueldo;
    }
    
    
}

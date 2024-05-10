package proyecto_daa.Entidades;

public abstract class Usuario {
    public String nombre;
    public String apellido;
    public int numTelefono;

    public Usuario(String nombre, String apellido, int numTelefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numTelefono = numTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }

    
    
}

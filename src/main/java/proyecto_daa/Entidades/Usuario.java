package proyecto_daa.Entidades;

import java.io.Serializable;

public abstract class Usuario implements Serializable{
    public String nombre;
    public String apellido;
    public int numTelefono;
    public String contrasenia;

    public Usuario(String nombre, String apellido, int numTelefono, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numTelefono = numTelefono;
        this.contrasenia = contrasenia;
    }
    public Usuario() {
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
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", numTelefono=" + numTelefono +  ", contrasenia=" + contrasenia +" ]";
    }

    
    
}

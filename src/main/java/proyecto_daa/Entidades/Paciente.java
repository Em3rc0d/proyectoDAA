package proyecto_daa.Entidades;

import java.io.Serializable;

public class Paciente extends Usuario implements Serializable{
    private HistorialMedico historialMedico;

    public Paciente(String nombre, String apellido, int numTelefono) {
        super(nombre, apellido, numTelefono);
    }

    public Paciente() {
        super(); // Llama al constructor sin argumentos de la clase padre Usuario
        // Otro código de inicialización, si es necesario
    }

    public void setHistorialMedico(HistorialMedico historialMedico) {
        this.historialMedico = historialMedico;
    }

    public HistorialMedico getHistorialMedico() {
        return historialMedico;
    }
    @Override
    public String toString() {
        return super.toString() + ", historialMedico=" + historialMedico;
    }
}

package proyecto_daa.Entidades;

import java.io.Serializable;

public class Paciente extends Usuario implements Serializable{
    private static int contadorPacientes = 0; // Contador para asignar el idPaciente
    private int idPaciente;
    private HistorialMedico historialMedico;

    public Paciente(String nombre, String apellido, int numTelefono) {
        super(nombre, apellido, numTelefono);
        this.idPaciente = ++contadorPacientes; // Asignar idPaciente y aumentar el contador
    }

    public Paciente() {
        super(); // Llama al constructor sin argumentos de la clase padre Usuario
        this.idPaciente = ++contadorPacientes; // Asignar idPaciente y aumentar el contador
        // Otro código de inicialización, si es necesario
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setHistorialMedico(HistorialMedico historialMedico) {
        this.historialMedico = historialMedico;
    }

    public HistorialMedico getHistorialMedico() {
        return historialMedico;
    }

    @Override
    public String toString() {
        return super.toString() + ", idPaciente=" + idPaciente + ", historialMedico=" + historialMedico;
    }
}

package proyecto_daa.Entidades;

import java.io.Serializable;

public class Paciente extends Usuario implements Serializable{
    private int idPaciente;
    private HistorialMedico historialMedico;

    public Paciente(String nombre, String apellido, int numTelefono, String contrasenia) {
        super(nombre, apellido, numTelefono, contrasenia);
        this.idPaciente = GeneradorID.getNextPacienteId();
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

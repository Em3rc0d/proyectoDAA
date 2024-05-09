package proyecto_daa.Entidades;

public class Paciente extends Usuario{
    private int idPaciente;
    private HistorialMedico historialMedico;

    public Paciente(String nombre, String apellido, int numTelefono, int idPaciente, HistorialMedico historialMedico) {
        super(nombre, apellido, numTelefono);
        this.idPaciente = idPaciente;
        this.historialMedico = historialMedico;
    }

    
}

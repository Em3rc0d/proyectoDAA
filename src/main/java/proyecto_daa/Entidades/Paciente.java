package proyecto_daa.Entidades;

public class Paciente extends Usuario{
    private HistorialMedico historialMedico;

    public Paciente(String nombre, String apellido, int numTelefono, String contrasenia) {
        super(nombre, apellido, numTelefono, contrasenia);
        this.idPaciente = GeneradorId.getNextPacienteId();
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
        return super.toString() + ", historialMedico=" + historialMedico;
    }
}

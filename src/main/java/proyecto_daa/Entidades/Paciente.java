package proyecto_daa.Entidades;

public class Paciente extends Usuario{
    private HistorialMedico historialMedico;

    public Paciente(String nombre, String apellido, int numTelefono) {
        super(nombre, apellido, numTelefono);
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

package proyecto_daa.Entidades;

public class Medico extends Usuario{
    private int idMedico;
    private String especialidad;
    private Turno turno;
    private int horarioDisponible[] ;

    public Medico(String nombre, String apellido, int numTelefono, String contrasenia, String especialidad, Turno turno) {
        super(nombre, apellido, numTelefono, contrasenia);
        this.idMedico = GeneradorId.getNextMedicoId();
        this.especialidad = especialidad;
        this.turno = turno;
        this.listaHorarios = new ListaHorarios(turno.getCategoria());
    }

    public String toString() {
        return super.toString() + ", idMedico: " + idMedico + ", especialidad: " + especialidad + ", turno: " + turno + ", horarioDisponible: " + horarioDisponible;
    }
}

package proyecto_daa.Entidades;

import java.io.Serializable;

public class Medico extends Usuario implements Serializable{
    private int idMedico;
    private String especialidad;
    private Turno turno;
    private int horarioDisponible[] ;

    public Medico(String nombre, String apellido, int numTelefono, int idMedico, String especialidad, Turno turno, int horarioDisponible[]) {
        super(nombre, apellido, numTelefono);
        this.idMedico = idMedico;
        this.especialidad = especialidad;
        this.turno = turno;
        this.horarioDisponible = horarioDisponible;
    }

    public String toString() {
        return super.toString() + ", idMedico: " + idMedico + ", especialidad: " + especialidad + ", turno: " + turno + ", horarioDisponible: " + horarioDisponible;
    }
}

package proyecto_daa.Entidades;

import java.io.Serializable;

import proyecto_daa.Horarios.ListaHorarios;

public class Medico extends Usuario implements Serializable {
    private int idMedico;
    private String especialidad;
    private Turno turno;
    private ListaHorarios listaHorarios;

    public Medico(String nombre, String apellido, int numTelefono, String contrasenia, String especialidad, Turno turno) {
        super(nombre, apellido, numTelefono, contrasenia);
        this.idMedico = GeneradorID.getNextMedicoId();
        this.especialidad = especialidad;
        this.turno = turno;
        this.listaHorarios = new ListaHorarios(turno.getCategoria());
    }

    public ListaHorarios getListaHorarios() {
        return listaHorarios;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return super.toString() + ", idMedico: " + idMedico + ", especialidad: " + especialidad + ", turno: " + turno;
    }
}
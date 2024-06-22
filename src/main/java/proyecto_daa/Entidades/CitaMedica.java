package proyecto_daa.Entidades;
import java.io.Serializable;

import proyecto_daa.Nodos.NodoHorario;

public class CitaMedica implements Serializable{
    
    private int idCita;
    private Paciente paciente;
    private Medico medico;
    private NodoHorario horario;
    private String estadoCita;

    public CitaMedica(Paciente paciente, Medico medico, NodoHorario horario, String estadoCita) {
        idCita = GeneradorID.getNextCitaId();
        this.paciente = paciente;
        this.medico = medico;
        this.horario = horario;
        this.estadoCita = estadoCita;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public NodoHorario getHorario() {
        return horario;
    }

    public void setHorario(NodoHorario horario) {
        this.horario = horario;
    }

    public String toString() {
        return "idCita: " + idCita + ", paciente: " + paciente + ", medico: " + medico + "horario" + horario + ", estadoCita: " + estadoCita;
    }
}

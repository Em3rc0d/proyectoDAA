package proyecto_daa.Entidades;

import java.util.Date;

public class CitaMedica {
    private int idCita;
    private Paciente paciente;
    private Medico medico;
    private String horaInicio;
    private String horaFin;
    private String estadoCita;

    public CitaMedica(int idCita, Paciente paciente, Medico medico, String horaInicio, String horaFin, String estadoCita) {
        this.idCita = idCita;
        this.paciente = paciente;
        this.medico = medico;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
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

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }   

    public String getEstadoCita() {
        return estadoCita;
    }   

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }

    public String toString() {
        return "idCita: " + idCita + ", paciente: " + paciente + ", medico: " + medico + ", horaInicio: " + horaInicio + ", horaFin: " + horaFin + ", estadoCita: " + estadoCita;
    }
}

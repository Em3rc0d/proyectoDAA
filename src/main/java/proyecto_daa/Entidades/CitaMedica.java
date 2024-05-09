package proyecto_daa.Entidades;

import java.util.Date;

public class CitaMedica {
    private int idCita;
    private Paciente paciente;
    private Medico medico;
    private Date horaInicio;
    private Date horaFin;
    private String estadoCita;

    public CitaMedica(int idCita, Paciente paciente, Medico medico, Date horaInicio, Date horaFin, String estadoCita) {
        this.idCita = idCita;
        this.paciente = paciente;
        this.medico = medico;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estadoCita = estadoCita;
    }

    public String toString() {
        return "idCita: " + idCita + ", paciente: " + paciente + ", medico: " + medico + ", horaInicio: " + horaInicio + ", horaFin: " + horaFin + ", estadoCita: " + estadoCita;
    }
}

package proyecto_daa.Nodos;

import java.io.Serializable;

import proyecto_daa.Entidades.Paciente;

public class NodoPaciente implements Serializable{
    public Paciente paciente;
    public NodoPaciente izquierda, derecha;

    public NodoPaciente(Paciente paciente) {
        this.paciente = paciente;
        this.izquierda = null;
        this.derecha = null;
    }

    @Override
    public String toString() {
        return paciente.toString();
    }
}

package proyecto_daa.Nodos;

import proyecto_daa.Entidades.Paciente;

public class NodoPaciente {
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

package proyecto_daa.Nodos;

import proyecto_daa.Entidades.Paciente;

public class NodoPaciente {
    public Paciente paciente;
    public NodoPaciente next;

    public NodoPaciente(Paciente paciente) {
        this.paciente = paciente;
        this.next = null;
    }

    @Override
    public String toString() {
        return paciente.toString();
    }
}

package proyecto_daa.Nodos;


import java.io.Serializable;

import proyecto_daa.Entidades.Paciente;

public class NodoPaciente extends NodoAVL<Paciente> implements Serializable{
    public NodoPaciente(Paciente paciente) {
        super(paciente);
    }
}

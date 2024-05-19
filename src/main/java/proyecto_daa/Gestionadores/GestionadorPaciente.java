package proyecto_daa.Gestionadores;

import proyecto_daa.Entidades.Paciente;
import proyecto_daa.Nodos.NodoPaciente;

public class GestionadorPaciente {
    public NodoPaciente raiz;

    public GestionadorPaciente() {
        this.raiz = null;
    }

    public void insertarPaciente(Paciente p) {
        raiz = insertarRecursivo(raiz, p);
    }

    private NodoPaciente insertarRecursivo(NodoPaciente nodo, Paciente paciente) {
        if (nodo == null) {
            nodo = new NodoPaciente(paciente);
            return nodo;
        }

        if (paciente.getApellido().compareTo(nodo.paciente.getApellido()) < 0) {
            nodo.izquierda = insertarRecursivo(nodo.izquierda, paciente);
        } else {
            nodo.derecha = insertarRecursivo(nodo.derecha, paciente);
        }

        return nodo;
    }

    public String listarPacientes() {
        StringBuilder msj = new StringBuilder();
        listarRecursivo(raiz, msj);
        return msj.toString();
    }

    private void listarRecursivo(NodoPaciente nodo, StringBuilder msj) {
        if (nodo != null) {
            listarRecursivo(nodo.izquierda, msj);
            msj.append(nodo.paciente.toString()).append("\n");
            listarRecursivo(nodo.derecha, msj);
        }
    }
}

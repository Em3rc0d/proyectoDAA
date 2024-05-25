package proyecto_daa.Gestionadores;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import proyecto_daa.Entidades.Paciente;
import proyecto_daa.Nodos.NodoPaciente;

public class GestionadorPaciente implements Serializable {
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
    public List<Paciente> getListaPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        agregarPacientesALista(raiz, pacientes);
        return pacientes;
    }
    private void agregarPacientesALista(NodoPaciente nodo, List<Paciente> pacientes) {
        if (nodo != null) {
            agregarPacientesALista(nodo.izquierda, pacientes);
            pacientes.add(nodo.paciente);
            agregarPacientesALista(nodo.derecha, pacientes);
        }
    }
}
package proyecto_daa.Gestionadores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import proyecto_daa.Entidades.CitaMedica;
import proyecto_daa.Entidades.Medico;
import proyecto_daa.Entidades.Paciente;
import proyecto_daa.Nodos.NodoCitaMedica;
import proyecto_daa.Nodos.NodoHorario;

public class GestionadorCitaMedica implements Serializable{
    public NodoCitaMedica raiz;
    public GestionadorCitaMedica() {
        this.raiz = null;
    }

    public void insertarCitaMedica(Paciente paciente, Medico medico, NodoHorario horario, String estadoCita) {
        CitaMedica c1 = new CitaMedica(paciente, medico, horario, estadoCita);
        raiz = insertarRecursivo(raiz, c1);
    }

    private NodoCitaMedica insertarRecursivo(NodoCitaMedica nodo, CitaMedica cita) {
        if (nodo == null) {
            nodo = new NodoCitaMedica(cita);
            return nodo;
        }
        if(cita.getMedico().getIdMedico()<nodo.CitaMedica.getMedico().getIdMedico()) {
            nodo.izquierda = insertarRecursivo(nodo.izquierda, cita);
        } else {
            nodo.derecha = insertarRecursivo(nodo.derecha, cita);
        }
        return nodo;
    }

    public String toString() {
        StringBuilder msj = new StringBuilder();
        listarRecursivo(raiz, msj);
        return msj.toString();
    }   

    private void listarRecursivo(NodoCitaMedica nodo, StringBuilder msj) {
        if (nodo != null) {
            listarRecursivo(nodo.izquierda, msj);
            msj.append(nodo.CitaMedica.toString()).append("\n");
            listarRecursivo(nodo.derecha, msj);
        }
    }

    public NodoCitaMedica buscarPorIdMedico(int idMedico) {
        return buscarPorIdMedicoRecursivo(raiz, idMedico);
    }

    private NodoCitaMedica buscarPorIdMedicoRecursivo(NodoCitaMedica nodo, int idMedico) {
        if (nodo == null) {
            return null;
        }
        if (nodo.CitaMedica.getMedico().getIdMedico() == idMedico) {
            return nodo;
        }
        if (idMedico < nodo.CitaMedica.getMedico().getIdMedico()) {
            return buscarPorIdMedicoRecursivo(nodo.izquierda, idMedico);
        } else {
            return buscarPorIdMedicoRecursivo(nodo.derecha, idMedico);
        }
    }

    public List<NodoCitaMedica> buscarTodosPorIdMedico(int idMedico) {
        List<NodoCitaMedica> resultados = new ArrayList<>();
        buscarTodosPorIdMedicoRecursivo(raiz, idMedico, resultados);
        return resultados;
    }
    
    private void buscarTodosPorIdMedicoRecursivo(NodoCitaMedica nodo, int idMedico, List<NodoCitaMedica> resultados) {
        if (nodo == null) {
            return;
        }

        if (nodo.CitaMedica.getMedico().getIdMedico() == idMedico) {
            resultados.add(nodo);
        }

        buscarTodosPorIdMedicoRecursivo(nodo.izquierda, idMedico, resultados);

        buscarTodosPorIdMedicoRecursivo(nodo.derecha, idMedico, resultados);
    }

        
    public List<NodoCitaMedica> buscarTodosPorPaciente(int idPaciente) {
        List<NodoCitaMedica> resultados = new ArrayList<>();
        buscarTodosPorPacienteRecursivo(raiz, idPaciente, resultados);
        return resultados;
    }

    private void buscarTodosPorPacienteRecursivo(NodoCitaMedica nodo, int idPaciente, List<NodoCitaMedica> resultados) {
        if (nodo == null) {
            return;
        }
        // Verificar si el paciente de la cita coincide con el paciente buscado
        if (nodo.CitaMedica.getPaciente().getIdPaciente() == idPaciente) {
            resultados.add(nodo);
        }
        // Buscar en el subárbol izquierdo
        buscarTodosPorPacienteRecursivo(nodo.izquierda, idPaciente, resultados);
        // Buscar en el subárbol derecho
        buscarTodosPorPacienteRecursivo(nodo.derecha, idPaciente, resultados);
    }

}

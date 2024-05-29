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
        // Si el idMedico buscado es menor, no hay coincidencias en el subárbol izquierdo
        if (idMedico < nodo.CitaMedica.getMedico().getIdMedico()) {
            return;
        }
        // Si el idMedico buscado es igual, agregar el nodo actual a los resultados
        if (idMedico == nodo.CitaMedica.getMedico().getIdMedico()) {
            resultados.add(nodo);
        }
        // Buscar en el subárbol derecho, ya que los nodos con el mismo idMedico están allí
        buscarTodosPorIdMedicoRecursivo(nodo.derecha, idMedico, resultados);
    }

}

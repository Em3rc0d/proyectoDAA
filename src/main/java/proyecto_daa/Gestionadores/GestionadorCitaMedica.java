package proyecto_daa.Gestionadores;

import java.util.Date;

import proyecto_daa.Entidades.CitaMedica;
import proyecto_daa.Entidades.Medico;
import proyecto_daa.Entidades.Paciente;
import proyecto_daa.Nodos.NodoCitaMedica;
import proyecto_daa.Nodos.NodoHorario;

public class GestionadorCitaMedica {
    public NodoCitaMedica raiz;
    public GestionadorCitaMedica() {
        this.raiz = null;
    }

    public void insertarCitaMedica(Paciente paciente, Medico medico, NodoHorario horario, String estadoCita) {
        CitaMedica c1 = new CitaMedica(paciente, medico, horario, estadoCita);
        //raiz = insertarRecursivo(raiz, c1);
    }

    // private NodoCitaMedica insertarRecursivo(NodoCitaMedica nodo, CitaMedica cita) {
    //     if (nodo == null) {
    //         nodo = new NodoCitaMedica(cita);
    //     } 
    //     if(cita.getHoraInicio().compareTo(nodo.CitaMedica.getHoraInicio()) < 0) {
    //         nodo.izquierda = insertarRecursivo(nodo.izquierda, cita);
    //     } else {
    //         nodo.derecha = insertarRecursivo(nodo.derecha, cita);
    //     }
    //     return nodo;
    // }

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
}

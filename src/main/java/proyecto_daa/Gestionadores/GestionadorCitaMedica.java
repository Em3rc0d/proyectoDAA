package proyecto_daa.Gestionadores;

import java.util.ArrayList;
import java.util.List;

import proyecto_daa.Entidades.CitaMedica;
import proyecto_daa.Entidades.HistorialMedico;
import proyecto_daa.Entidades.Medico;
import proyecto_daa.Entidades.Paciente;
import proyecto_daa.Nodos.NodoAVL;
import proyecto_daa.Nodos.NodoCitaMedica;
import proyecto_daa.Nodos.NodoHorario;
import proyecto_daa.Nodos.NodoPaciente;

public class GestionadorCitaMedica extends GestionadorAVL<CitaMedica>{

    public GestionadorCitaMedica() {
        super();
    }

    //Ahora es un arbolAVL

    public void insertarCitaMedica(Paciente paciente, Medico medico, NodoHorario horario, String estadoCita) {
        CitaMedica c1 = new CitaMedica(paciente, medico, horario, estadoCita);
        raiz = insertarRecursivo(raiz, c1);
    }

    private NodoCitaMedica insertarRecursivo(NodoAVL<CitaMedica> nodo, CitaMedica cita) {
        if (nodo == null) {
            return new NodoCitaMedica(cita);
        }
        else{

            NodoCitaMedica nodoCitaMedica = (NodoCitaMedica) nodo;

            if (cita.getMedico().getIdMedico() < nodoCitaMedica.entidad.getMedico().getIdMedico()) {
                nodoCitaMedica.izquierda = insertarRecursivo(nodoCitaMedica.izquierda, cita);
            } else if(cita.getMedico().getIdMedico() > nodoCitaMedica.entidad.getMedico().getIdMedico()){
                nodoCitaMedica.derecha = insertarRecursivo(nodoCitaMedica.derecha, cita);
            }else
                return nodoCitaMedica;
    
            nodoCitaMedica.altura = 1 + Math.max(altura(nodoCitaMedica.izquierda), altura(nodoCitaMedica.derecha));
    
            int balance = getBalance(nodoCitaMedica);
    
            // Rotaci�n simple a la derecha
            if (balance > 1 && cita.getMedico().getIdMedico() < nodoCitaMedica.izquierda.entidad.getMedico().getIdMedico()) {
                return (NodoCitaMedica) rotarDerecha(nodoCitaMedica);
            }
    
            // Rotaci�n simple a la izquierda
            if (balance < -1 && cita.getMedico().getIdMedico() > nodo.derecha.entidad.getMedico().getIdMedico()) {
                return (NodoCitaMedica) rotarIzquierda(nodoCitaMedica);
            }
    
            // Rotaci�n doble a la izquierda
            if (balance > 1 && cita.getMedico().getIdMedico() > nodo.izquierda.entidad.getMedico().getIdMedico()) {
                nodo.izquierda = rotarIzquierda(nodoCitaMedica.izquierda);
                return (NodoCitaMedica) rotarDerecha(nodoCitaMedica);
            }
    
            // Rotaci�n doble a la derecha
            if (balance < -1 && cita.getMedico().getIdMedico() < nodo.derecha.entidad.getMedico().getIdMedico()) {
                nodo.derecha = rotarDerecha(nodoCitaMedica.derecha);
                return (NodoCitaMedica) rotarIzquierda(nodoCitaMedica);
            }
            return nodoCitaMedica;
        }
    }

    public List<NodoCitaMedica> buscarTodosPorIdMedico(int idMedico) {
        List<NodoCitaMedica> resultados = new ArrayList<>();
        buscarTodosPorIdMedicoRecursivo(raiz, idMedico, resultados);
        return resultados;
    }
    
    private void buscarTodosPorIdMedicoRecursivo(NodoAVL<CitaMedica> nodo, int idMedico, List<NodoCitaMedica> resultados) {
        if (nodo == null) {
            return;
        }

        NodoCitaMedica nodoCitaMedica = (NodoCitaMedica) nodo;

        if (nodoCitaMedica.entidad.getMedico().getIdMedico() == idMedico) {
            resultados.add(nodoCitaMedica);
        }
        
        if (nodoCitaMedica.entidad.getMedico().getIdMedico() < idMedico) {
            buscarTodosPorIdMedicoRecursivo(nodo.izquierda, idMedico, resultados);
        }else
            buscarTodosPorIdMedicoRecursivo(nodo.derecha, idMedico, resultados);
        
    }
        
    public List<NodoCitaMedica> buscarTodosPorPaciente(int idPaciente) {
        List<NodoCitaMedica> resultados = new ArrayList<>();
        buscarTodosPorPacienteRecursivo(raiz, idPaciente, resultados);
        return resultados;
    }

    private void buscarTodosPorPacienteRecursivo(NodoAVL<CitaMedica> nodo, int idPaciente, List<NodoCitaMedica> resultados) {
        if (nodo == null) {
            return;
        }

        NodoCitaMedica nodoCitaMedica = (NodoCitaMedica) nodo;

        // Verificar si el paciente de la cita coincide con el paciente buscado
        if (nodoCitaMedica.entidad.getPaciente().getIdPaciente() == idPaciente) {
            resultados.add(nodoCitaMedica);
        }
        // Buscar en el subárbol izquierdo
        buscarTodosPorPacienteRecursivo(nodoCitaMedica.izquierda, idPaciente, resultados);
        // Buscar en el subárbol derecho
        buscarTodosPorPacienteRecursivo(nodoCitaMedica.derecha, idPaciente, resultados);
    }

    public void modificarPaciente(int idPaciente, String nombre, String apellido, int numTelefono, HistorialMedico historial){
        modificarPacienteR(raiz, idPaciente, nombre, apellido, numTelefono, historial);
    }

    private void modificarPacienteR(NodoAVL<CitaMedica> nodo, int idPaciente, String nombre, String apellido, int numTelefono, HistorialMedico historial){
        if (nodo == null) {
            return;
        }

        NodoCitaMedica nodoCitaMedica = (NodoCitaMedica) nodo;

        // Verificar si el paciente de la cita coincide con el paciente buscado
        if (nodoCitaMedica.entidad.getPaciente().getIdPaciente() == idPaciente) {
            nodoCitaMedica.entidad.getPaciente().setNombre(nombre);
            nodoCitaMedica.entidad.getPaciente().setApellido(apellido);
            nodoCitaMedica.entidad.getPaciente().setNumTelefono(numTelefono);
            nodoCitaMedica.entidad.getPaciente().setHistorialMedico(historial);

        }
        // Buscar en el subárbol izquierdo
        modificarPacienteR(nodo.izquierda, idPaciente, nombre, apellido, numTelefono, historial);
        // Buscar en el subárbol derecho
        modificarPacienteR(nodo.derecha, idPaciente, nombre, apellido, numTelefono, historial);
    }

    public void eliminarNodoPorPaciente(int idPaciente){
        eliminarNodoPorPacienteR(raiz, idPaciente);
    }

    private void eliminarNodoPorPacienteR(NodoAVL<CitaMedica> nodo, int idPaciente){
        if (nodo == null) {
            return;
        }

        NodoCitaMedica nodoCitaMedica = (NodoCitaMedica) nodo;

        // Verificar si el paciente de la cita coincide con el paciente buscado
        if (nodoCitaMedica.entidad.getPaciente().getIdPaciente() == idPaciente) {
            eliminarNodo(nodoCitaMedica.entidad.getMedico().getIdMedico());
        }
        // Buscar en el subárbol izquierdo
        eliminarNodoPorPacienteR(nodo.izquierda, idPaciente);
        // Buscar en el subárbol derecho
        eliminarNodoPorPacienteR(nodo.derecha, idPaciente);
    }

    public void eliminarNodo(int idMedico){
        eliminarNodoR(raiz, idMedico);
    }

    private NodoCitaMedica eliminarNodoR(NodoAVL<CitaMedica> nodo, int idMedico) {
        if (nodo == null) return null;

        NodoCitaMedica nodoCitaMedica = (NodoCitaMedica) nodo;

        if (idMedico < nodoCitaMedica.entidad.getMedico().getIdMedico()) {
            nodoCitaMedica.izquierda = eliminarNodoR(nodoCitaMedica.izquierda, idMedico);
        } else if (idMedico > nodoCitaMedica.entidad.getMedico().getIdMedico()) {
            nodoCitaMedica.derecha = eliminarNodoR(nodoCitaMedica.derecha, idMedico);
        } else {
            if (nodoCitaMedica.izquierda == null) return (NodoCitaMedica) nodoCitaMedica.derecha;
            else if (nodoCitaMedica.derecha == null) return (NodoCitaMedica) nodoCitaMedica.izquierda;

            nodoCitaMedica.entidad = encontrarMenor(nodoCitaMedica.derecha).entidad;
            nodoCitaMedica.derecha = eliminarNodoR(nodoCitaMedica.derecha, nodoCitaMedica.entidad.getMedico().getIdMedico());
        }

        if (nodoCitaMedica == null) return null;

        nodoCitaMedica.altura = max(altura(nodoCitaMedica.izquierda), altura(nodoCitaMedica.derecha)) + 1;

        int balance = getBalance(nodoCitaMedica);

        if (balance > 1 && getBalance(nodoCitaMedica.izquierda) >= 0) {
            return (NodoCitaMedica) rotarDerecha(nodoCitaMedica);
        }

        if (balance > 1 && getBalance(nodoCitaMedica.izquierda) < 0) {
            nodoCitaMedica.izquierda = (NodoCitaMedica) rotarIzquierda(nodoCitaMedica.izquierda);
            return (NodoCitaMedica) rotarDerecha(nodoCitaMedica);
        }

        if (balance < -1 && getBalance(nodoCitaMedica.derecha) <= 0) {
            return (NodoCitaMedica) rotarIzquierda(nodoCitaMedica);
        }

        if (balance < -1 && getBalance(nodoCitaMedica.derecha) > 0) {
            nodoCitaMedica.derecha = (NodoCitaMedica) rotarDerecha(nodoCitaMedica.derecha);
            return (NodoCitaMedica) rotarIzquierda(nodoCitaMedica);
        }

        return nodoCitaMedica;
    }


    private NodoCitaMedica encontrarMenor(NodoAVL<CitaMedica> node) {
        NodoCitaMedica temp = (NodoCitaMedica) node;
        while (temp.izquierda != null) {
            temp = (NodoCitaMedica) temp.izquierda;
        }
        return temp;
    }




}

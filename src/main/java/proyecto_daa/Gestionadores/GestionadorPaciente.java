package proyecto_daa.Gestionadores;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

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

//    public String listarPacientes() {
//        StringBuilder msj = new StringBuilder();
//        listarRecursivo(raiz, msj);
//        return msj.toString();
//    }
//
//    private void listarRecursivo(NodoPaciente nodo, StringBuilder msj) {
//        if (nodo != null) {
//            listarRecursivo(nodo.izquierda, msj);
//            msj.append(nodo.paciente.toString()).append("\n");
//            listarRecursivo(nodo.derecha, msj);
//        }
//    }
    
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

//    public Paciente buscarPacientePorId(int idPaciente) {
//        return buscarPacientePorIdRecursivo(raiz, idPaciente);
//    }
    
//    private Paciente buscarPacientePorIdRecursivo(NodoPaciente nodo, int idPaciente) {
//        if (nodo == null) {
//            return null;
//        }
   
//        if (nodo.paciente.getIdPaciente() == idPaciente) {
//            return nodo.paciente; // Se encontró al paciente con el Id buscado
//        } else if (idPaciente < nodo.paciente.getIdPaciente()) {
//            // El Id buscado es menor, buscar en el subárbol izquierdo
//            return buscarPacientePorIdRecursivo(nodo.izquierda, idPaciente);
//        } else {
//            // El Id buscado es mayor, buscar en el subárbol derecho
//            return buscarPacientePorIdRecursivo(nodo.derecha, idPaciente);
//        }
//    }
    
    //esto parece funcionar todo bien

    public Paciente buscarPacientePorId(int idPaciente) {
        return buscarPacientePorIdLineal(raiz, idPaciente).paciente;
    }

    public NodoPaciente buscarPacientePorIdNodo(int idPaciente) {
        return buscarPacientePorIdLineal(raiz, idPaciente);
    }

    private NodoPaciente buscarPacientePorIdLineal(NodoPaciente nodo, int idPaciente) {
        if (nodo == null) {
            return null;
        }

        if (nodo.paciente.getIdPaciente() == idPaciente) {
            return nodo;
        }

        NodoPaciente nodoIzquierda = buscarPacientePorIdLineal(nodo.izquierda, idPaciente);
        if (nodoIzquierda != null) {
            return nodoIzquierda;
        }

        return buscarPacientePorIdLineal(nodo.derecha, idPaciente);
    }

    public void modificarPaciente(int idPaciente, Paciente paciente){
        Paciente pacienteAModificar = buscarPacientePorId(idPaciente);
        pacienteAModificar = paciente;
    }

    public void eliminarPaciente(int idPaciente){

        NodoPaciente nodo = buscarPacientePorIdNodo(idPaciente);

        if(nodo.izquierda == null && nodo.derecha == null)
            nodo = null;
        else if(nodo.izquierda == null || nodo.derecha == null){
            if(nodo.izquierda==null)
                nodo = nodo.derecha;
            else
                nodo = nodo.izquierda;
        }else{
            //dos hijos
            NodoPaciente nodoDerecha = nodo.derecha;
            nodo = nodo.izquierda;
            NodoPaciente aux = nodo;
            while(true){
                if (nodo.derecha!=null)
                    aux = nodoDerecha.derecha;
                else{
                    aux.derecha = nodoDerecha;
                    break;
                }
                return;
            }

        }
    }

}
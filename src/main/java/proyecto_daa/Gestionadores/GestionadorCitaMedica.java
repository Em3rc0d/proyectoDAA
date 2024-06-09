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

public class GestionadorCitaMedica extends GestionadorAVL<CitaMedica> {

    public GestionadorCitaMedica() {
        super();
    }

    // Ahora es un arbolAVL

    public void insertarCitaMedica(Paciente paciente, Medico medico, NodoHorario horario, String estadoCita) {
        CitaMedica c1 = new CitaMedica(paciente, medico, horario, estadoCita);
        raiz = insertarRecursivo(raiz, c1);
    }

    private NodoCitaMedica insertarRecursivo(NodoAVL<CitaMedica> nodo, CitaMedica cita) {
        if (nodo == null) {
            return new NodoCitaMedica(cita);
        } else {

            NodoCitaMedica nodoCitaMedica = (NodoCitaMedica) nodo;
            
            if(cita.getIdCita() < nodoCitaMedica.entidad.getIdCita())
                nodoCitaMedica.izquierda = insertarRecursivo(nodoCitaMedica.izquierda, cita);
            else 
                if(cita.getIdCita() > nodoCitaMedica.entidad.getIdCita())
                    nodoCitaMedica.derecha = insertarRecursivo(nodoCitaMedica.derecha, cita);

            nodoCitaMedica.altura = 1 + Math.max(altura(nodoCitaMedica.izquierda), altura(nodoCitaMedica.derecha));

            int balance = getBalance(nodoCitaMedica);

            // Rotaci�n simple a la derecha
            if (balance > 1
                    && cita.getIdCita() < nodoCitaMedica.izquierda.entidad.getIdCita()) {
                return (NodoCitaMedica) rotarDerecha(nodoCitaMedica);
            }

            // Rotaci�n simple a la izquierda
            if (balance < -1 && cita.getIdCita() > nodoCitaMedica.derecha.entidad.getIdCita()) {
                return (NodoCitaMedica) rotarIzquierda(nodoCitaMedica);
            }

            // Rotaci�n doble a la izquierda
            if (balance > 1 && cita.getIdCita() > nodoCitaMedica.izquierda.entidad.getIdCita()) {
                nodoCitaMedica.izquierda = rotarIzquierda(nodoCitaMedica.izquierda);
                return (NodoCitaMedica) rotarDerecha(nodoCitaMedica);
            }

            // Rotaci�n doble a la derecha
            if (balance < -1 && cita.getIdCita() < nodoCitaMedica.derecha.entidad.getIdCita()) {
                nodoCitaMedica.derecha = rotarDerecha(nodoCitaMedica.derecha);
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

    private void buscarTodosPorIdMedicoRecursivo(NodoAVL<CitaMedica> nodo, int idMedico,
            List<NodoCitaMedica> resultados) {
        if (nodo == null) {
            return;
        }

        NodoCitaMedica nodoCitaMedica = (NodoCitaMedica) nodo;

        if (nodoCitaMedica.entidad.getMedico().getIdMedico() == idMedico) {
            resultados.add(nodoCitaMedica);
        }

        buscarTodosPorIdMedicoRecursivo(nodoCitaMedica.izquierda, idMedico, resultados);
        // Buscar en el subárbol derecho
        buscarTodosPorIdMedicoRecursivo(nodoCitaMedica.derecha, idMedico, resultados);

    }

    public List<NodoCitaMedica> buscarTodosPorPaciente(int idPaciente) {
        List<NodoCitaMedica> resultados = new ArrayList<>();
        buscarTodosPorPacienteRecursivo(raiz, idPaciente, resultados);
        return resultados;
    }

    private void buscarTodosPorPacienteRecursivo(NodoAVL<CitaMedica> nodo, int idPaciente,
            List<NodoCitaMedica> resultados) {
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

    public void modificarPaciente(int idPaciente, String nombre, String apellido, int numTelefono,
            HistorialMedico historial) {
        modificarPacienteR(raiz, idPaciente, nombre, apellido, numTelefono, historial);
    }

    private void modificarPacienteR(NodoAVL<CitaMedica> nodo, int idPaciente, String nombre, String apellido,
            int numTelefono, HistorialMedico historial) {
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
        modificarPacienteR(nodoCitaMedica.izquierda, idPaciente, nombre, apellido, numTelefono, historial);
        // Buscar en el subárbol derecho
        modificarPacienteR(nodoCitaMedica.derecha, idPaciente, nombre, apellido, numTelefono, historial);
    }

    public void modificarMedico(int idMedico, String nombre, String apellido, int numTelefono) {
        modificarPacienteR(raiz, idMedico, nombre, apellido, numTelefono);
    }

    private void modificarPacienteR(NodoAVL<CitaMedica> nodo, int idMedico, String nombre, String apellido,
            int numTelefono) {
        if (nodo == null) {
            return;
        }

        NodoCitaMedica nodoCitaMedica = (NodoCitaMedica) nodo;

        // Verificar si el paciente de la cita coincide con el paciente buscado
        if (nodoCitaMedica.entidad.getMedico().getIdMedico() == idMedico) {
            nodoCitaMedica.entidad.getMedico().setNombre(nombre);
            nodoCitaMedica.entidad.getMedico().setApellido(apellido);
            nodoCitaMedica.entidad.getMedico().setNumTelefono(numTelefono);
        }
        // Buscar en el subárbol izquierdo
        modificarPacienteR(nodoCitaMedica.izquierda, idMedico, nombre, apellido, numTelefono);
        // Buscar en el subárbol derecho
        modificarPacienteR(nodoCitaMedica.derecha, idMedico, nombre, apellido, numTelefono);
    }
    
    public void eliminarNodoPorPaciente(int idPaciente) {
        raiz = eliminarNodoPorPacienteR(raiz, idPaciente);
    }

    private NodoCitaMedica eliminarNodoPorPacienteR(NodoAVL<CitaMedica> nodo, int idPaciente) {
        if (nodo == null) {
            return null;
        }

        NodoCitaMedica nodoCitaMedica = (NodoCitaMedica) nodo;

        nodoCitaMedica.izquierda = eliminarNodoPorPacienteR(nodoCitaMedica.izquierda, idPaciente);
        nodoCitaMedica.derecha = eliminarNodoPorPacienteR(nodoCitaMedica.derecha, idPaciente);

        if (nodoCitaMedica.entidad.getPaciente().getIdPaciente() == idPaciente) {
            nodoCitaMedica = eliminarNodoPorCita(nodo, nodoCitaMedica.entidad.getIdCita());
        }
        return nodoCitaMedica;
    }

    private NodoCitaMedica eliminarNodoPorCita(NodoAVL<CitaMedica> nodo, int idCita) {
        if (nodo == null) {
            return null;
        }

        NodoCitaMedica nodoCitaMedica = (NodoCitaMedica) nodo;

        if (idCita < nodoCitaMedica.entidad.getIdCita()) {
            nodoCitaMedica.izquierda = eliminarNodoPorCita(nodoCitaMedica.izquierda, idCita);
        } else if (idCita > nodoCitaMedica.entidad.getIdCita()) {
            nodoCitaMedica.derecha = eliminarNodoPorCita(nodoCitaMedica.derecha, idCita);
        } else {
            if (nodoCitaMedica.izquierda == null) {
                return (NodoCitaMedica) nodoCitaMedica.derecha;
            } else if (nodoCitaMedica.derecha == null) {
                return (NodoCitaMedica) nodoCitaMedica.izquierda;
            }

            NodoCitaMedica temp = encontrarMenor(nodoCitaMedica.derecha);
            nodoCitaMedica.entidad = temp.entidad;
            nodoCitaMedica.derecha = eliminarNodoPorCita(nodoCitaMedica.derecha, temp.entidad.getIdCita());
        }

        nodoCitaMedica.altura = Math.max(altura(nodoCitaMedica.izquierda), altura(nodoCitaMedica.derecha)) + 1;

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

    private NodoCitaMedica encontrarMenor(NodoAVL<CitaMedica> nodo) {
        NodoCitaMedica actual = (NodoCitaMedica) nodo;
        while (actual.izquierda != null) {
            actual = (NodoCitaMedica) actual.izquierda;
        }
        return actual;
    }


    public String listarCita(){
        StringBuilder msj = new StringBuilder();
        listarRecursivo(raiz, msj);
        return msj.toString();
    }

    private void listarRecursivo(NodoAVL<CitaMedica> nodo, StringBuilder msj) {
        if (nodo != null) {
            NodoCitaMedica nodoCita = (NodoCitaMedica) nodo;
            listarRecursivo(nodoCita.izquierda, msj);
            msj.append(nodoCita.entidad.toString()).append("\n");
            listarRecursivo(nodoCita.derecha, msj);
        }
    }

}

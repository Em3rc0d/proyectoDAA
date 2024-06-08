package proyecto_daa.Gestionadores;
import java.util.ArrayList;
import java.util.List;

import proyecto_daa.Entidades.HistorialMedico;
import proyecto_daa.Entidades.Paciente;
import proyecto_daa.Nodos.NodoAVL;
import proyecto_daa.Nodos.NodoPaciente;

public class GestionadorPaciente extends GestionadorAVL<Paciente> {

    public GestionadorPaciente() {
        super();  // Llama al constructor del padre (GestionadorAVL)
    }

    public void insertarPaciente(Paciente p) {
        raiz = insertarRecursivo(raiz, p);
    }

    private NodoPaciente insertarRecursivo(NodoAVL<Paciente> nodo, Paciente paciente) {
        if (nodo == null) {
            return new NodoPaciente(paciente);
        }

        NodoPaciente nodoPaciente = (NodoPaciente) nodo;

        if (paciente.getApellido().compareTo(nodoPaciente.entidad.getApellido()) < 0) {
            nodoPaciente.izquierda = insertarRecursivo(nodoPaciente.izquierda, paciente);
        } else if (paciente.getApellido().compareTo(nodoPaciente.entidad.getApellido()) > 0){
            nodoPaciente.derecha = insertarRecursivo(nodoPaciente.derecha, paciente);
        } else{
            if(nodoPaciente.derecha == null){
                nodoPaciente.derecha = new NodoPaciente(paciente);
            }else{
                NodoPaciente temp = (NodoPaciente) nodoPaciente.derecha;
                NodoPaciente nodoNuevo = new NodoPaciente(paciente);
                nodoPaciente.derecha = nodoNuevo;
                nodoNuevo = temp;
            }
        }
            
        
        nodoPaciente.altura = 1 + max(altura(nodoPaciente.izquierda), altura(nodoPaciente.derecha));

        int balance = getBalance(nodoPaciente);

        if (balance > 1 && paciente.getApellido().compareTo(nodoPaciente.izquierda.entidad.getApellido()) < 0) {
            return (NodoPaciente) rotarDerecha(nodoPaciente);
        }

        if (balance < -1 && paciente.getApellido().compareTo(nodoPaciente.derecha.entidad.getApellido()) > 0) {
            return (NodoPaciente) rotarIzquierda(nodoPaciente);
        }

        if (balance > 1 && paciente.getApellido().compareTo(nodoPaciente.izquierda.entidad.getApellido()) > 0) {
            nodoPaciente.izquierda = (NodoPaciente) rotarIzquierda(nodoPaciente.izquierda);
            return (NodoPaciente) rotarDerecha(nodoPaciente);
        }

        if (balance < -1 && paciente.getApellido().compareTo(nodoPaciente.derecha.entidad.getApellido()) < 0) {
            nodoPaciente.derecha = (NodoPaciente) rotarDerecha(nodoPaciente.derecha);
            return (NodoPaciente) rotarIzquierda(nodoPaciente);
        }

        return nodoPaciente;
    }

   public String listarPacientes() {
       StringBuilder msj = new StringBuilder();
       listarRecursivo(raiz, msj);
       return msj.toString();
   }
//
   private void listarRecursivo(NodoAVL<Paciente> nodo, StringBuilder msj) {
       if (nodo != null) {
        NodoPaciente nodoPaciente = (NodoPaciente) nodo;
           listarRecursivo(nodoPaciente.izquierda, msj);
           msj.append(nodoPaciente.entidad.toString()).append("\n");
           listarRecursivo(nodoPaciente.derecha, msj);
       }
   }
    
    public void modificarPaciente(int idPaciente, String nombre, String apellido, int numTelefono,
        HistorialMedico historial) {
        NodoPaciente pacienteAModificar = buscarPacientePorIdNodo(idPaciente);

        Paciente pacienteModificado = pacienteAModificar.entidad;
        pacienteModificado.setNombre(nombre);
        pacienteModificado.setApellido(apellido);
        pacienteModificado.setNumTelefono(numTelefono);
        pacienteModificado.setHistorialMedico(historial);

        raiz = eliminarNodoR(raiz, apellido);
        insertarPaciente(pacienteModificado);
    }

    public void eliminarNodoPorPaciente(String apellido){
        raiz = eliminarNodoR(raiz, apellido);
    }

    private NodoPaciente eliminarNodoR(NodoAVL<Paciente> nodo, String apellido) {
        if (nodo == null) return null;

        NodoPaciente nodoPaciente = (NodoPaciente) nodo;

        if (apellido.compareTo(nodoPaciente.entidad.getApellido()) < 0) {
            nodoPaciente.izquierda = eliminarNodoR(nodoPaciente.izquierda, apellido);
        } else if (apellido.compareTo(nodoPaciente.entidad.getApellido()) > 0) {
            nodoPaciente.derecha = eliminarNodoR(nodoPaciente.derecha, apellido);
        } else {
            if (nodoPaciente.izquierda == null) return (NodoPaciente) nodoPaciente.derecha;
            else if (nodoPaciente.derecha == null) return (NodoPaciente) nodoPaciente.izquierda;
    
            nodoPaciente.entidad = encontrarMenor(nodoPaciente.derecha).entidad;
            nodoPaciente.derecha = eliminarNodoR(nodoPaciente.derecha, nodoPaciente.entidad.getApellido());
        }
    
        if (nodoPaciente == null) return null;
    
        nodoPaciente.altura = 1 + max(altura(nodoPaciente.izquierda), altura(nodoPaciente.derecha));

        int balance = getBalance(nodoPaciente);

        if (balance > 1 && getBalance(nodoPaciente.izquierda) >= 0) {
            return (NodoPaciente) rotarDerecha(nodoPaciente);
        }

        if (balance > 1 && getBalance(nodoPaciente.izquierda) < 0) {
            nodoPaciente.izquierda = (NodoPaciente) rotarIzquierda(nodoPaciente.izquierda);
            return (NodoPaciente) rotarDerecha(nodoPaciente);
        }

        if (balance < -1 && getBalance(nodoPaciente.derecha) <= 0) {
            return (NodoPaciente) rotarIzquierda(nodoPaciente);
        }

        if (balance < -1 && getBalance(nodoPaciente.derecha) > 0) {
            nodoPaciente.derecha = (NodoPaciente) rotarDerecha(nodoPaciente.derecha);
            return (NodoPaciente) rotarIzquierda(nodoPaciente);
        }

        return nodoPaciente;
    }

    private NodoPaciente encontrarMenor(NodoAVL<Paciente> node) {
        NodoPaciente temp = (NodoPaciente) node;
        while (temp.izquierda != null) {
            temp = (NodoPaciente) temp.izquierda;
        }
        return temp;
    }

    public List<Paciente> getListaPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        agregarPacientesALista(raiz, pacientes);
        return pacientes;
    }
    
    private void agregarPacientesALista(NodoAVL<Paciente> nodo, List<Paciente> pacientes) {
        if (nodo != null) {
            NodoPaciente nodoPaciente = (NodoPaciente) nodo;
            agregarPacientesALista(nodoPaciente.izquierda, pacientes);
            pacientes.add(nodoPaciente.entidad);
            agregarPacientesALista(nodoPaciente.derecha, pacientes);
        }
    }
    
    //esto parece funcionar todo bien

    public Paciente buscarPacientePorId(int idPaciente) {
        NodoPaciente nodoPaciente = buscarPacientePorIdRecursivo(raiz, idPaciente);
        if (nodoPaciente != null) {
            return nodoPaciente.entidad;
        } else {
            return null;
        }
    }

    public NodoPaciente buscarPacientePorIdNodo(int idPaciente) {
        NodoPaciente nodoPaciente = buscarPacientePorIdRecursivo(raiz, idPaciente);
        if (nodoPaciente != null) {
            return nodoPaciente;
        } else {
            return null;
        }
    }

    private NodoPaciente buscarPacientePorIdRecursivo(NodoAVL<Paciente> nodo, int idPaciente) {
        if (nodo == null) {
            return null;
        }
    
        NodoPaciente nodoPaciente = (NodoPaciente) nodo;
    
        if (nodoPaciente.entidad.getIdPaciente() == idPaciente) {
            return nodoPaciente;
        } else if (idPaciente < nodoPaciente.entidad.getIdPaciente()) {
            return buscarPacientePorIdRecursivo(nodoPaciente.izquierda, idPaciente);
        } else {
            return buscarPacientePorIdRecursivo(nodoPaciente.derecha, idPaciente);
        }
    }
    

}
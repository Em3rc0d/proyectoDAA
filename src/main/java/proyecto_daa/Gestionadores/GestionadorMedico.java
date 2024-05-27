package proyecto_daa.Gestionadores;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import proyecto_daa.Entidades.Medico;
import proyecto_daa.Entidades.Turno;
import proyecto_daa.Nodos.NodoMedico;

public class GestionadorMedico implements Serializable {

    public NodoMedico raiz;

    public GestionadorMedico() {
        this.raiz = null;
    }

    public void insertarMedico(String nombre, String apellido, int numTelefono, String contrasenia, String especialidad, Turno turno) {
        Medico m = new Medico(nombre, apellido, numTelefono, contrasenia, especialidad, turno);
        raiz = insertarRecursivo(raiz, m);
    }

    private NodoMedico insertarRecursivo(NodoMedico nodo, Medico medico) {
        if (nodo == null) {
            return new NodoMedico(medico);
        }

        if (medico.getApellido().compareTo(nodo.medico.getApellido()) < 0) {
            nodo.izquierda = insertarRecursivo(nodo.izquierda, medico);
        } else {
            nodo.derecha = insertarRecursivo(nodo.derecha, medico);
        }

        return nodo;
    }

    public String listarMedicos() {
        StringBuilder msj = new StringBuilder();
        listarRecursivo(raiz, msj);
        return msj.toString();
    }

    private void listarRecursivo(NodoMedico nodo, StringBuilder msj) {
        if (nodo != null) {
            listarRecursivo(nodo.izquierda, msj);
            msj.append(nodo.medico.toString()).append("\n");
            listarRecursivo(nodo.derecha, msj);
        }
    }

    public Medico obtenerMedico(int idMedico) {
        return obtenerRecursivo(raiz, idMedico);
    }

    private Medico obtenerRecursivo(NodoMedico nodo, int idMedico) {
        if (nodo == null) {
            return null;
        }
        if (idMedico == nodo.medico.getIdMedico()) {
            return nodo.medico;
        }
        if (idMedico < nodo.medico.getIdMedico()) {
            return obtenerRecursivo(nodo.izquierda, idMedico);
        }
        return obtenerRecursivo(nodo.derecha, idMedico);
    }

    // Nuevo método para obtener una lista de todos los médicos
    public List<Medico> getListaMedicos() {
        List<Medico> medicos = new ArrayList<>();
        agregarMedicosALista(raiz, medicos);
        return medicos;
    }

    private void agregarMedicosALista(NodoMedico nodo, List<Medico> lista) {
        if (nodo != null) {
            agregarMedicosALista(nodo.izquierda, lista);
            lista.add(nodo.medico);
            agregarMedicosALista(nodo.derecha, lista);
        }
    }

    public Medico obtenerMedicoPorId(int idMedico) {
        return obtenerRecursivoPorId(raiz, idMedico);
    }
    
    private Medico obtenerRecursivoPorId(NodoMedico nodo, int idMedico) {
        if (nodo == null) {
            return null;
        }
        if (idMedico == nodo.medico.getIdMedico()) {
            return nodo.medico;
        }
        if (idMedico < nodo.medico.getIdMedico()) {
            return obtenerRecursivoPorId(nodo.izquierda, idMedico);
        }
        return obtenerRecursivoPorId(nodo.derecha, idMedico);
    }    

}
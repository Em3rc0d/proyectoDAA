package proyecto_daa.Gestionadores;

import proyecto_daa.Entidades.Medico;
import proyecto_daa.Entidades.Turno;
import proyecto_daa.Nodos.NodoMedico;

public class GestionadorMedico {
    public NodoMedico raiz;

    public GestionadorMedico() {
        this.raiz = null;
    }

    public void insertarMedico(String nombre, String apellido, int numTelefono, int idMedico, String especialidad, Turno turno, int horarioDisponible[]) {
        Medico m = new Medico(nombre, apellido, numTelefono, idMedico, especialidad, turno, horarioDisponible);
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
    public Medico obtenerMedico(int idMedico){
        return obtenerRecursivo(raiz, idMedico);
    }
    private Medico obtenerRecursivo(NodoMedico nodo, int idMedico){
        if(nodo == null){
            return null;
        }
        if(idMedico == nodo.medico.getIdMedico()){
            return nodo.medico;
        }
        if(idMedico < nodo.medico.getIdMedico()){
            return obtenerRecursivo(nodo.izquierda, idMedico);
        }
        return obtenerRecursivo(nodo.derecha, idMedico);
    }
}   

package proyecto_daa.Gestionadores;

import proyecto_daa.Entidades.Medico;
import proyecto_daa.Entidades.Turno;
import proyecto_daa.Nodos.NodoMedico;

public class GestionadorMedico {
    public NodoMedico head;
    public NodoMedico tail;

    public GestionadorMedico() {
        this.head = null;
        this.tail = null;
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
            tail.next = nm;
        }
        tail = nm;
    }

    public String listarMedicos() { 
        String msj = "";
        NodoMedico nm = head;
        while(nm != null) {
            msj += nm.medico.toString() + "\n";
            nm = nm.next;
        }
        return msj; 
    }
}

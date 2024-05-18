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

    public void insertarMedico(String nombre, String apellido, int numTelefono, int idMedico, String especialidad, Turno turno, int horarioDisponible[]) {
        Medico m = new Medico(nombre, apellido, numTelefono, idMedico, especialidad, turno, horarioDisponible);
        NodoMedico nm = new NodoMedico(m);
        if(head == null) {
            head = nm;
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

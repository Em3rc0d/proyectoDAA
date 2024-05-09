package proyecto_daa.Gestionadores;

import proyecto_daa.Entidades.HistorialMedico;
import proyecto_daa.Entidades.Paciente;
import proyecto_daa.Nodos.NodoPaciente;

public class GestionadorPaciente {
    public NodoPaciente head;
    public NodoPaciente tail;

    public GestionadorPaciente() {
        this.head = null;
        this.tail = null;
    }

    public void insertarPaciente(String nombre, String apellido, int numTelefono, int idPaciente, HistorialMedico historialMedico) {
        Paciente p = new Paciente(nombre, apellido, numTelefono, idPaciente, historialMedico);
        NodoPaciente np = new NodoPaciente(p);
        if(head == null) {
            head = np;
        } else {
            tail.next = np;
        }
        tail = np;
    }

    public String listarPacientes() {
        String msj = "";
        NodoPaciente np = head;
        while(np != null) {
            msj += np.paciente.toString() + "\n";
            np = np.next;
        }
        return msj;
    }
}

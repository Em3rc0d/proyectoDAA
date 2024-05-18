package proyecto_daa.Nodos;

import proyecto_daa.Entidades.Medico;

public class NodoMedico {
    public Medico medico;
    public NodoMedico next;
    
    public NodoMedico(Medico medico) {
        this.medico = medico;
        this.next = null;
    }
    
    @Override
    public String toString() {
        return medico.toString();
    }
}

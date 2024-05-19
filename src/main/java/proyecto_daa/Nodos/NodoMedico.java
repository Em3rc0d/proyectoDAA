package proyecto_daa.Nodos;

import proyecto_daa.Entidades.Medico;

public class NodoMedico {
    public Medico medico;
    public NodoMedico izquierda, derecha;

    public NodoMedico(Medico medico) {
        this.medico = medico;
        this.izquierda = null;
        this.derecha = null;
    }
    
    @Override
    public String toString() {
        return medico.toString();
    }
    
}

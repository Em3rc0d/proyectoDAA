package proyecto_daa.Nodos;

import java.io.Serializable;

import proyecto_daa.Entidades.Medico;

public class NodoMedico implements Serializable{
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

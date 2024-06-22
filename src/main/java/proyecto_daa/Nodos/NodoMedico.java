package proyecto_daa.Nodos;

import java.io.Serializable;

import proyecto_daa.Entidades.Medico;

public class NodoMedico extends NodoAVL<Medico> implements Serializable{

    public NodoMedico(Medico medico) {
        super(medico);
    }
    
}

package proyecto_daa.Nodos;
import java.io.Serializable;

import proyecto_daa.Entidades.CitaMedica;
public class NodoCitaMedica extends NodoAVL<CitaMedica> implements Serializable{

    public NodoCitaMedica(CitaMedica cita) {
        super(cita);
    }

}

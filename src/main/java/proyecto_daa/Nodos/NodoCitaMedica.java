package proyecto_daa.Nodos;
import java.io.Serializable;

import proyecto_daa.Entidades.CitaMedica;
public class NodoCitaMedica implements Serializable{
    public CitaMedica CitaMedica;
    public NodoCitaMedica izquierda, derecha;
    public NodoCitaMedica(CitaMedica CitaMedica) {
        this.CitaMedica = CitaMedica;
        this.izquierda = null;
        this.derecha = null;
    }

    @Override   
    public String toString() {
        return CitaMedica.toString();
    }
}

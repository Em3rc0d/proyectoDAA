package proyecto_daa.Nodos;
import proyecto_daa.Entidades.CitaMedica;
public class NodoCitaMedica {
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

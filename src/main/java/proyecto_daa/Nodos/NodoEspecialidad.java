package proyecto_daa.Nodos;

import java.io.Serializable;

public class NodoEspecialidad implements Serializable{
    private String especialidadMedica;
    private NodoEspecialidad siguiente;
    public NodoEspecialidad(String especialidadMedica) {
        this.especialidadMedica = especialidadMedica;
        this.siguiente = null;
    }
    public String getEspecialidadMedica() {
        return especialidadMedica;
    }
    public void setEspecialidadMedica(String especialidadMedica) {
        this.especialidadMedica = especialidadMedica;
    }
    public NodoEspecialidad getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(NodoEspecialidad siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return especialidadMedica;
    }
}

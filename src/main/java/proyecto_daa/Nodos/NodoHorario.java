package proyecto_daa.Nodos;

import java.io.Serializable;

public class NodoHorario implements Serializable{
    private String horaInicio;
    private String horaFin;
    private boolean disponible;
    private NodoHorario siguiente;

    public NodoHorario(String horaInicio, String horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.disponible = true;
        this.siguiente = null;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public NodoHorario getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHorario siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return horaInicio + " - " + horaFin;
    }
}
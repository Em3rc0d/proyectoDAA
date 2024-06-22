package proyecto_daa.Especialidades;

import java.io.Serializable;

import proyecto_daa.Nodos.NodoEspecialidad;

public class ListaEspecialidades implements Serializable{

    private NodoEspecialidad cabeza;

    public ListaEspecialidades() {
        agregarEspecialidad("Medicina General");
        agregarEspecialidad("Pediatria");
        agregarEspecialidad("Cardiologia");
        agregarEspecialidad("Dermatologia");
        agregarEspecialidad("Neurologia");
        agregarEspecialidad("Cirugia");
        agregarEspecialidad("Cirugia Plastica");
        agregarEspecialidad("Cirugia Maxilofacial");
        agregarEspecialidad("Cirugia Oncologica");
        agregarEspecialidad("Cirugia Plastica");
        agregarEspecialidad("Cirugia Pedia");
        agregarEspecialidad("Cirugia Toracica");
        agregarEspecialidad("Cirugia Vascular");
    }

    public void agregarEspecialidad(String especialidadMedica) {
        NodoEspecialidad nuevoNodo = new NodoEspecialidad(especialidadMedica);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoEspecialidad actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    public NodoEspecialidad getCabeza() {
        return cabeza;  
    }

    public void setCabeza(NodoEspecialidad cabeza) {
        this.cabeza = cabeza;
    }

    public void eliminarEspecialidad(String especialidadMedica) {
        if (cabeza != null) {
            if (cabeza.getEspecialidadMedica().equals(especialidadMedica)) {
                cabeza = cabeza.getSiguiente();
            } else {
                NodoEspecialidad actual = cabeza;
                while (actual.getSiguiente() != null) {
                    if (actual.getSiguiente().getEspecialidadMedica().equals(especialidadMedica)) {
                        actual.setSiguiente(actual.getSiguiente().getSiguiente());
                        break;
                    }
                    actual = actual.getSiguiente();
                }
            }
        }
    }   
}

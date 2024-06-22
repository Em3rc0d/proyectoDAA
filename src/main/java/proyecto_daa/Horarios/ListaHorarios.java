package proyecto_daa.Horarios;

import java.io.Serializable;

import proyecto_daa.Nodos.NodoHorario;

public class ListaHorarios implements Serializable{
    private NodoHorario cabeza;

    public ListaHorarios(String turno) {
        if (turno.equals("Mañana")) {
            agregarHorario("08:00", "08:30");
            agregarHorario("08:30", "09:00");
            agregarHorario("09:00", "09:30");
            agregarHorario("09:30", "10:00");
            agregarHorario("10:00", "10:30");
            agregarHorario("10:30", "11:00");
            agregarHorario("11:00", "11:30");
            agregarHorario("11:30", "12:00");
        } else {
            agregarHorario("14:00", "14:30");
            agregarHorario("14:30", "15:00");
            agregarHorario("15:00", "15:30");
            agregarHorario("15:30", "16:00");
            agregarHorario("16:00", "16:30");
            agregarHorario("16:30", "17:00");
            agregarHorario("17:00", "17:30");
            agregarHorario("17:30", "18:00");
        }
    }

    private void agregarHorario(String horaInicio, String horaFin) {
        NodoHorario nuevoNodo = new NodoHorario(horaInicio, horaFin);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoHorario actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    public NodoHorario getCabeza() {
        return cabeza;
    }

    public NodoHorario seleccionarHorariosDisponibles(int index){
        NodoHorario temp = cabeza;
        int currentIndex = -1;
    
        while (temp != null) {
            if (temp.isDisponible()) {
                currentIndex++;
            }
            if (currentIndex == index) {
                temp.setDisponible(false);
                return temp;
            }
            temp = temp.getSiguiente();
        }
    
        // Si llegamos aquí, significa que index está fuera de los límites de la lista
        return null;
    }
    

}
package proyecto_daa.Gestionadores;

import proyecto_daa.Entidades.Medico;
import proyecto_daa.Entidades.Paciente;
import proyecto_daa.Entidades.Turno;

public class mainPrueba {
    
    
    public static void main(String[] args) {
        GestionadorPaciente arbolPaciente = new GestionadorPaciente();
        GestionadorMedico arbolMedico = new GestionadorMedico();
        GestionadorCitaMedica arbolCitas = new GestionadorCitaMedica();

        Paciente paciente1 = new Paciente("1", "1", 1, "1");
        Paciente paciente2 = new Paciente("2", "2", 2, "2");
        Paciente paciente3 = new Paciente("3", "3", 3, "3");
        Paciente paciente4 = new Paciente("4", "4", 4, "4");

        arbolPaciente.insertarPaciente(paciente1);
        arbolPaciente.insertarPaciente(paciente2);
        arbolPaciente.insertarPaciente(paciente3);
        arbolPaciente.insertarPaciente(paciente4);

        System.out.println(arbolPaciente.listarPacientes());

        Turno tarde = new Turno("Tarde");
        Turno maniana = new Turno("Mañana");

        Medico medico1 = new Medico("1", "1", 1, "1", "1", tarde);
        Medico medico2 = new Medico("2", "2", 2, "2", "2", maniana);
        Medico medico3 = new Medico("3", "3", 3, "3", "3", tarde);
        Medico medico4 = new Medico("4", "4", 4, "4", "4", maniana);

        arbolMedico.insertarMedico(medico1);
        arbolMedico.insertarMedico(medico2);
        arbolMedico.insertarMedico(medico3);
        arbolMedico.insertarMedico(medico4);

        System.out.println(arbolMedico.listarMedicos());

        arbolCitas.insertarCitaMedica(paciente1, medico1, medico1.getListaHorarios().seleccionarHorariosDisponibles(1), null);
        arbolCitas.insertarCitaMedica(paciente1, medico2, medico1.getListaHorarios().seleccionarHorariosDisponibles(1), null);
        arbolCitas.insertarCitaMedica(paciente1, medico1, medico2.getListaHorarios().seleccionarHorariosDisponibles(2), null);
        System.out.println(arbolCitas.listarCita());

        // arbolCitas.eliminarNodoPorPaciente(paciente1.getIdPaciente());
        // System.out.println("ELIMINACION");
        // System.out.println(arbolCitas.listarCita());


    }

}

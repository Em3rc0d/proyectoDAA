package proyecto_daa.Gestionadores;

import proyecto_daa.Entidades.CitaMedica;
import proyecto_daa.Entidades.Medico;
import proyecto_daa.Entidades.Paciente;
import proyecto_daa.Entidades.Turno;

public class mainPrueba {
    
    
    public static void main(String[] args) {
        GestionadorPaciente arbolPaciente = new GestionadorPaciente();
        GestionadorMedico arbolMedico = new GestionadorMedico();
        GestionadorCitaMedica arbolCitas = new GestionadorCitaMedica();

        Paciente paciente1 = new Paciente("Alvaro", "Poma", 941619270, "gol");
        Paciente paciente2 = new Paciente("ae", "Rivas", 941619270, "gol");
        Paciente paciente3 = new Paciente("se", "Poma", 941619270, "gol");
        Paciente paciente4 = new Paciente("sae", "Sarabia", 941619270, "gol");

        arbolPaciente.insertarPaciente(paciente1);
        arbolPaciente.insertarPaciente(paciente2);
        arbolPaciente.insertarPaciente(paciente3);
        arbolPaciente.insertarPaciente(paciente4);

        System.out.println(arbolPaciente.listarPacientes());

        Turno tarde = new Turno("Tarde");
        Turno mañana = new Turno("Mañana");

        Medico medico1 = new Medico("sdfa", "safd", 9840, "sfda", "asdf", tarde);
        Medico medico2 = new Medico("sdfa", "2afd", 9840, "sfda", "asdf", mañana);
        Medico medico3 = new Medico("sdfa", "safd", 9840, "sfda", "asdf", tarde);
        Medico medico4 = new Medico("sdfa", "3afd", 9840, "sfda", "asdf", mañana);

        arbolMedico.insertarMedico(medico1);
        arbolMedico.insertarMedico(medico2);
        arbolMedico.insertarMedico(medico3);
        arbolMedico.insertarMedico(medico4);

        System.out.println(arbolMedico.listarMedicos());

        //CitaMedica cita1 = new CitaMedica(paciente1, medico1, medico1.getListaHorarios().seleccionarHorariosDisponibles(1), null);
        //CitaMedica cita2 = new CitaMedica(paciente1, medico1, medico1.getListaHorarios().seleccionarHorariosDisponibles(1), null);

        arbolCitas.insertarCitaMedica(paciente1, medico1, medico1.getListaHorarios().seleccionarHorariosDisponibles(1), null);
        arbolCitas.insertarCitaMedica(paciente1, medico1, medico1.getListaHorarios().seleccionarHorariosDisponibles(2), null);
        
        System.out.println(arbolCitas.listarCita());

    }

}

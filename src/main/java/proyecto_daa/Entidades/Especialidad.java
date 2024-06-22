package proyecto_daa.Entidades;

public class Especialidad{
    String especialidadMedica;

    public Especialidad(String especialidadMedica) {  
        this.especialidadMedica = especialidadMedica;
    }


    public String getespecialidadMedica() {
        return especialidadMedica;
    }

    @Override
    public String toString() {
        return especialidadMedica;
    }

}

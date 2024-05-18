package proyecto_daa.Entidades;

public class HistorialMedico {
    private String tipoSangre;
    private int contactoEmergencia;
    private String antecMedicos;
    private String alergias;
    private String medicamentos;
    private String tratamientosAnteriores;

    public HistorialMedico(String tipoSangre, int contactoEmergencia, String antecMedicos, String alergias, String medicamentos, String tratamientosAnteriores) {
        this.tipoSangre = tipoSangre;
        this.contactoEmergencia = contactoEmergencia;
        this.antecMedicos = antecMedicos;
        this.alergias = alergias;
        this.medicamentos = medicamentos;
        this.tratamientosAnteriores = tratamientosAnteriores;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public int getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(int contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    public String getAntecMedicos() {
        return antecMedicos;
    }

    public void setAntecMedicos(String antecMedicos) {
        this.antecMedicos = antecMedicos;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getTratamientosAnteriores() {
        return tratamientosAnteriores;
    }

    public void setTratamientosAnteriores(String tratamientosAnteriores) {
        this.tratamientosAnteriores = tratamientosAnteriores;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HistorialMedico{");
        sb.append(", tipoSangre=").append(tipoSangre);
        sb.append(", contactoEmergencia=").append(contactoEmergencia);
        sb.append(", antecMedicos=").append(antecMedicos);
        sb.append(", alergias=").append(alergias);
        sb.append(", medicamentos=").append(medicamentos);
        sb.append(", tratamientosAnteriores=").append(tratamientosAnteriores);
        sb.append('}');
        return sb.toString();
    }


}

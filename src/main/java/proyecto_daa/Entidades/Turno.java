package proyecto_daa.Entidades;

public class Turno {
    private String categoria;

    public Turno(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String toString() {
        return this.categoria;
    }
}

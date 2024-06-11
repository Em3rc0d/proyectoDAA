package proyecto_daa.Entidades;

public class UsuarioActual<T> {
    private static UsuarioActual<?> instancia;
    private T usuarioActual;

    private UsuarioActual() {}

    @SuppressWarnings("unchecked")
    public static synchronized <T> UsuarioActual<T> getInstance() {
        if (instancia == null) {
            instancia = new UsuarioActual<>();
        }
        return (UsuarioActual<T>) instancia;
    }

    public T getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(T usuarioActual) {
        this.usuarioActual = usuarioActual;
    }   
    
    public void clearUsuarioActual() {
        this.usuarioActual = null;
    }
    
}
package proyecto_daa.Nodos;

import java.io.Serializable;

public class NodoAVL<T> implements Serializable {
    public NodoAVL<T> izquierda, derecha;
    public int altura;
    public T entidad;

    public NodoAVL(T entidad) {
        this.entidad = entidad;
        this.izquierda = null;
        this.derecha = null;
        this.altura = 1;
    }

    @Override
    public String toString() {
        return entidad.toString();
    }
}

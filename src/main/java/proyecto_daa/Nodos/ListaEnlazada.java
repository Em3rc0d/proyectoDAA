package proyecto_daa.Nodos;

import java.util.Comparator;

public class ListaEnlazada<T> {
    private NodoAVL<T> inicio;

    public ListaEnlazada() {
        this.inicio = null;
    }

    public NodoAVL<T> getInicio() {
        return inicio;
    }

    // public void insertar(T entidad) {
    //     NodoAVL<T> nuevoNodo = new NodoAVL<>(entidad);
    //     if (inicio == null) {
    //         inicio = nuevoNodo;
    //     } else {
    //         NodoAVL<T> temp = inicio;
    //         while (temp.derecha != null) {
    //             temp = temp.derecha;
    //         }
    //         temp.derecha = nuevoNodo;
    //     }
    // }

    public void insertarOrdenado(T entidad, Comparator<T> comparador) {
        NodoAVL<T> nuevoNodo = new NodoAVL<>(entidad);
        
        if (inicio == null || comparador.compare(entidad, inicio.entidad) <= 0) {
            nuevoNodo.derecha = inicio;
            inicio = nuevoNodo;
        } else {
            NodoAVL<T> actual = inicio;
            while (actual.derecha != null && comparador.compare(entidad, actual.derecha.entidad) > 0) {
                actual = actual.derecha;
            }
            nuevoNodo.derecha = actual.derecha;
            actual.derecha = nuevoNodo;
        }
    }

    public void imprimir() {
        NodoAVL<T> temp = inicio;
        while (temp != null) {
            System.out.println(temp.entidad);
            temp = temp.derecha;
        }
    }
}

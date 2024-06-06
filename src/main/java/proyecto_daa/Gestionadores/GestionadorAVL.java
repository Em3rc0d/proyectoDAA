package proyecto_daa.Gestionadores;

import java.io.Serializable;

import proyecto_daa.Nodos.NodoAVL;

public class GestionadorAVL<T> implements Serializable {
    public NodoAVL<T> raiz;

    public GestionadorAVL() {
        this.raiz = null;
    }

    int altura(NodoAVL<T> n) {
        return n == null ? 0 : n.altura;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    NodoAVL<T> rotarDerecha(NodoAVL<T> y) {
        NodoAVL<T> x = y.izquierda;
        NodoAVL<T> T2 = x.derecha;

        x.derecha = y;
        y.izquierda = T2;

        y.altura = max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = max(altura(x.izquierda), altura(x.derecha)) + 1;

        return x;
    }

    NodoAVL<T> rotarIzquierda(NodoAVL<T> x) {
        NodoAVL<T> y = x.derecha;
        NodoAVL<T> T2 = y.izquierda;

        y.izquierda = x;
        x.derecha = T2;

        x.altura = max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = max(altura(y.izquierda), altura(y.derecha)) + 1;

        return y;
    }

    int getBalance(NodoAVL<T> n) {
        return n == null ? 0 : altura(n.izquierda) - altura(n.derecha);
    }

}

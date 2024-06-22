package proyecto_daa.Gestionadores;
import java.util.ArrayList;
import java.util.List;

import proyecto_daa.Entidades.Medico;
import proyecto_daa.Nodos.NodoAVL;
import proyecto_daa.Nodos.NodoMedico;
import java.util.Comparator;
import proyecto_daa.Nodos.ListaEnlazada;

public class GestionadorMedico extends GestionadorAVL<Medico> {

    public GestionadorMedico() {
        super();
    }

    public void insertarMedico(Medico m) {
        raiz = insertarRecursivo(raiz, m);
    }

    private NodoMedico insertarRecursivo(NodoAVL<Medico> nodo, Medico medico) {
        if (nodo == null) {
            return new NodoMedico(medico);
        }

        NodoMedico nodoMedico = (NodoMedico) nodo;

        if (medico.getApellido().compareTo(nodoMedico.entidad.getApellido()) < 0) {
            nodoMedico.izquierda = insertarRecursivo(nodoMedico.izquierda, medico);
        } else if(medico.getApellido().compareTo(nodoMedico.entidad.getApellido()) > 0){
            nodoMedico.derecha = insertarRecursivo(nodoMedico.derecha, medico);
        }else{
            int comparacionNombre = medico.getNombre().compareTo(nodoMedico.entidad.getNombre());
            if (comparacionNombre < 0) {
                nodoMedico.izquierda = insertarRecursivo(nodoMedico.izquierda, medico);
            } else {
                nodoMedico.derecha = insertarRecursivo(nodoMedico.derecha, medico);
            }
        }

            nodoMedico.altura = 1 + max(altura(nodoMedico.izquierda), altura(nodoMedico.derecha));

            int balance = getBalance(nodoMedico);
    
            if (balance > 1 && medico.getApellido().compareTo(nodoMedico.izquierda.entidad.getApellido()) < 0) {
                return (NodoMedico) rotarDerecha(nodoMedico);
            }
    
            if (balance < -1 && medico.getApellido().compareTo(nodoMedico.derecha.entidad.getApellido()) > 0) {
                return (NodoMedico) rotarIzquierda(nodoMedico);
            }
    
            if (balance > 1 && medico.getApellido().compareTo(nodoMedico.izquierda.entidad.getApellido()) > 0) {
                nodoMedico.izquierda = (NodoMedico) rotarIzquierda(nodoMedico.izquierda);
                return (NodoMedico) rotarDerecha(nodoMedico);
            }
    
            if (balance < -1 && medico.getApellido().compareTo(nodoMedico.derecha.entidad.getApellido()) < 0) {
                nodoMedico.derecha = (NodoMedico) rotarDerecha(nodoMedico.derecha);
                return (NodoMedico) rotarIzquierda(nodoMedico);
            }
    
            return nodoMedico;
    }

    public List<Medico> getListaMedicos() {
        List<Medico> medicos = new ArrayList<>();
        agregarMedicosALista(raiz, medicos);
        medicos.sort(Comparator.comparingInt(Medico::getIdMedico));
        return medicos;
    }

    private void agregarMedicosALista(NodoAVL<Medico> nodo, List<Medico> lista) {
        if (nodo != null) {
            NodoMedico nodoMedico = (NodoMedico) nodo;
            agregarMedicosALista(nodoMedico.izquierda, lista);
            lista.add(nodoMedico.entidad);
            agregarMedicosALista(nodoMedico.derecha, lista);
        }
    }


    public Medico obtenerMedicoPorId(int idMedico) {
        NodoMedico nodoMedico = buscarMedicoPorIdRecursivo(raiz, idMedico);
        if (nodoMedico != null) {
            return nodoMedico.entidad;
        } else {
            return null;
        }
    }

    public NodoMedico obtenerMedicoPorNodo(int idMedico) {
        NodoMedico nodoMedico = buscarMedicoPorIdRecursivo(raiz, idMedico);
        if (nodoMedico != null) {
            return nodoMedico;
        } else {
            return null;
        }
    }

    private NodoMedico buscarMedicoPorIdRecursivo(NodoAVL<Medico> nodo, int idMedico) {
        if (nodo == null) {
            return null;
        }

        NodoMedico nodoMedico = (NodoMedico) nodo;

        if (nodoMedico.entidad.getIdMedico() == idMedico) {
            return nodoMedico; // Médico encontrado
        }

        NodoMedico resultadoIzquierda = buscarMedicoPorIdRecursivo(nodoMedico.izquierda, idMedico);
        if (resultadoIzquierda != null) {
            return resultadoIzquierda;
        }

        return buscarMedicoPorIdRecursivo(nodoMedico.derecha, idMedico);
    }

    public void modificarMedico(int idMedico, String nombre, String apellido, int numTelefono){
        NodoMedico medicoAModificar = obtenerMedicoPorNodo(idMedico);

        Medico medicoModificado = medicoAModificar.entidad;
        medicoModificado.setNombre(nombre);
        medicoModificado.setApellido(apellido);
        medicoModificado.setNumTelefono(numTelefono);

        raiz = eliminarNodoR(raiz, apellido);
        insertarMedico(medicoModificado);

    }

    public void eliminarNodoPorMedico(String apellido){
        raiz = eliminarNodoR(raiz, apellido);
    }

    private NodoMedico eliminarNodoR(NodoAVL<Medico> nodo, String apellido){
        if (nodo == null) return null;

        NodoMedico nodoMedico = (NodoMedico) nodo;

        if (apellido.compareTo(nodoMedico.entidad.getApellido()) < 0) {
            nodoMedico.izquierda = eliminarNodoR(nodoMedico.izquierda, apellido);
        } else if (apellido.compareTo(nodoMedico.entidad.getApellido()) > 0) {
            nodoMedico.derecha = eliminarNodoR(nodoMedico.derecha, apellido);
        } else {
            if (nodoMedico.izquierda == null) return (NodoMedico) nodoMedico.derecha;
            else if (nodoMedico.derecha == null) return (NodoMedico) nodoMedico.izquierda;
    
            nodoMedico.entidad = encontrarMenor(nodoMedico.derecha).entidad;
            nodoMedico.derecha = eliminarNodoR(nodoMedico.derecha, nodoMedico.entidad.getApellido());
        }
    
        if (nodoMedico == null) return null;
    
        nodoMedico.altura = 1 + max(altura(nodoMedico.izquierda), altura(nodoMedico.derecha));

        int balance = getBalance(nodoMedico);

        if (balance > 1 && getBalance(nodoMedico.izquierda) >= 0) {
            return (NodoMedico) rotarDerecha(nodoMedico);
        }

        if (balance > 1 && getBalance(nodoMedico.izquierda) < 0) {
            nodoMedico.izquierda = (NodoMedico) rotarIzquierda(nodoMedico.izquierda);
            return (NodoMedico) rotarDerecha(nodoMedico);
        }

        if (balance < -1 && getBalance(nodoMedico.derecha) <= 0) {
            return (NodoMedico) rotarIzquierda(nodoMedico);
        }

        if (balance < -1 && getBalance(nodoMedico.derecha) > 0) {
            nodoMedico.derecha = (NodoMedico) rotarDerecha(nodoMedico.derecha);
            return (NodoMedico) rotarIzquierda(nodoMedico);
        }

        return nodoMedico;
    }

    private NodoMedico encontrarMenor(NodoAVL<Medico> node) {
        NodoMedico temp = (NodoMedico) node;
        while (temp.izquierda != null) {
            temp = (NodoMedico) temp.izquierda;
        }
        return temp;
    }

    public String listarMedicos() {
        StringBuilder msj = new StringBuilder();
        listarRecursivo(raiz, msj);
        return msj.toString();
    }
 //
    private void listarRecursivo(NodoAVL<Medico> nodo, StringBuilder msj) {
        if (nodo != null) {
            NodoMedico nodoMedico = (NodoMedico) nodo;
            listarRecursivo(nodoMedico.izquierda, msj);
            msj.append(nodoMedico.entidad.toString()).append("\n");
            listarRecursivo(nodoMedico.derecha, msj);
        }
    }
    public ListaEnlazada<Medico> getListaMedicoId(){
    ListaEnlazada<Medico> listaMedicos = new ListaEnlazada<>();
    getListaMedicoIdRec(raiz, listaMedicos);
    return listaMedicos;
}

private void getListaMedicoIdRec(NodoAVL<Medico> raiz, ListaEnlazada<Medico> listaMedicos) {
    if (raiz != null) {
        getListaMedicoIdRec(raiz.izquierda, listaMedicos);
        listaMedicos.insertarOrdenado(raiz.entidad, Comparator.comparingInt(Medico::getIdMedico));
        getListaMedicoIdRec(raiz.derecha, listaMedicos);
    }
}


}

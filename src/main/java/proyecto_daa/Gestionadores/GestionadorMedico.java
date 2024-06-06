package proyecto_daa.Gestionadores;
import java.util.ArrayList;
import java.util.List;

import proyecto_daa.Entidades.Medico;
import proyecto_daa.Nodos.NodoAVL;
import proyecto_daa.Nodos.NodoMedico;

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
        }else
            return nodoMedico;

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


//    Nuevo método para obtener una lista de todos los médicos
    public List<Medico> getListaMedicos() {
        List<Medico> medicos = new ArrayList<>();
        agregarMedicosALista(raiz, medicos);
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

    private NodoMedico buscarMedicoPorIdRecursivo(NodoAVL<Medico> nodo, int idMedico) {
        if (nodo == null) {
            return null;
        }

        NodoMedico nodoMedico = (NodoMedico) nodo;

        if (nodoMedico.entidad.getIdMedico() == idMedico) {
            return nodoMedico;
        } else if (idMedico < nodoMedico.entidad.getIdMedico()) {
            return buscarMedicoPorIdRecursivo(nodoMedico.izquierda, idMedico);
        } else {
            return buscarMedicoPorIdRecursivo(nodoMedico.derecha, idMedico);
        }
    }

    // public void modificarMedico(int idMedico, Medico medico){

    // }





}

//        public String listarMedicos() {
//        StringBuilder msj = new StringBuilder();
//        listarRecursivo(raiz, msj);
//        return msj.toString();
//    }

//    private void listarRecursivo(NodoMedico nodo, StringBuilder msj) {
//        if (nodo != null) {
//            listarRecursivo(nodo.izquierda, msj);
//            msj.append(nodo.medico.toString()).append("\n");
//            listarRecursivo(nodo.derecha, msj);
//        }
//    }

//     public Medico obtenerMedico(int idMedico) {
//         return obtenerRecursivo(raiz, idMedico);
//     }

//     private Medico obtenerRecursivo(NodoMedico nodo, int idMedico) {
//         if (nodo == null) {
//             return null;
//         }
//         if (idMedico == nodo.medico.getIdMedico()) {
//             return nodo.medico;
//         }
//         if (idMedico < nodo.medico.getIdMedico()) {
//             return obtenerRecursivo(nodo.izquierda, idMedico);
//         }
//         return obtenerRecursivo(nodo.derecha, idMedico);
//     }

//     public Medico obtenerMedicoPorId(int idMedico) {
//         return obtenerRecursivoPorId(raiz, idMedico);
//     }
    
//     private Medico obtenerRecursivoPorId(NodoMedico nodo, int idMedico) {
//         if (nodo == null) {
//             return null;
//         }
//         if (idMedico == nodo.medico.getIdMedico()) {
//             return nodo.medico;
//         }
//         if (idMedico < nodo.medico.getIdMedico()) {
//             return obtenerRecursivoPorId(nodo.izquierda, idMedico);
//         }
//         return obtenerRecursivoPorId(nodo.derecha, idMedico);
//     }  
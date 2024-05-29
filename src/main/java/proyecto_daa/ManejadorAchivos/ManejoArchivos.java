package proyecto_daa.ManejadorAchivos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import proyecto_daa.Gestionadores.GestionadorPaciente;

public class ManejoArchivos {

    public static <T extends Serializable> void guardar(String nombreArchivo, T objeto) throws IOException {
        try (FileOutputStream archivo = new FileOutputStream(nombreArchivo); ObjectOutputStream salida = new ObjectOutputStream(archivo)) {
            salida.writeObject(objeto);
        } catch (IOException e) {
            throw new IOException("Error al guardar el archivo: " + nombreArchivo, e);
        }
    }

    public static <T extends Serializable> T cargar(String nombreArchivo) throws IOException, ClassNotFoundException {
        T objeto = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            objeto = (T) ois.readObject();
        } catch (EOFException e) {
            // Manejar EOFException cuando el archivo está vacío
            System.out.println("El archivo está vacío.");
        }
        return objeto;
    }

    public static boolean archivoExiste(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    public static <T extends Serializable> T cargarArbol(String nombreArchivo, T arbolVacio) {
        T arbolCargado;
        try {
            arbolCargado = cargar(nombreArchivo);
            if (arbolCargado == null) {
                arbolCargado = arbolVacio;
            }
        } catch (IOException | ClassNotFoundException e) {
            arbolCargado = arbolVacio;
            e.printStackTrace();
        }
        return arbolCargado;
    }

    public static GestionadorPaciente cargarArbol(String nombreArchivo, GestionadorPaciente arbolVacio) {
        GestionadorPaciente arbolCargado;
        try {
            arbolCargado = cargar(nombreArchivo);
            if (arbolCargado == null) {
                arbolCargado = arbolVacio;
            }
        } catch (IOException | ClassNotFoundException e) {
            arbolCargado = arbolVacio;
            e.printStackTrace();
        }
        return arbolCargado;
    }

}

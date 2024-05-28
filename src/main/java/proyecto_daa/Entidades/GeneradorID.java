package proyecto_daa.Entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GeneradorID {
    private static final String FILE_PATH = "id_counter.txt";
    private static int contadorMedico = 0;
    private static int contadorPaciente = 0;
    private static int contadorCita = 0;

    static {
        // Leer el archivo al iniciar la aplicación
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            contadorMedico = Integer.parseInt(reader.readLine());
            contadorPaciente = Integer.parseInt(reader.readLine());
            contadorCita = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            // Si hay un error al leer, inicializar los contadores a 0
            contadorMedico = 0;
            contadorPaciente = 0;
            contadorCita = 0;
        }
    }

    public static int getNextMedicoId() {
        contadorMedico++;
        saveCounters();
        return contadorMedico;
    }

    public static int getNextPacienteId() {
        contadorPaciente++;
        saveCounters();
        return contadorPaciente;
    }

    public static int getNextCitaId() {
        contadorCita++;
        saveCounters();
        return contadorCita;
    }

    private static void saveCounters() {
        // Guardar los contadores en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(contadorMedico + "\n");
            writer.write(contadorPaciente + "\n");
            writer.write(contadorCita + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
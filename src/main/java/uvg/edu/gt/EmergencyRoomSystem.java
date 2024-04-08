package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class EmergencyRoomSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de Priority Queue a usar:");
        System.out.println("1. VectorHeap personalizado");
        System.out.println("2. PriorityQueue del Java Collection Framework");
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la línea nueva restante

        switch (opcion) {
            case 1:
                emergencySystemWithCustomVectorHeap();
                break;
            case 2:
                emergencySystemWithJavaPriorityQueue();
                break;
            default:
                System.out.println("Opción no válida. Por favor, introduzca 1 o 2.");
                break;
        }

        scanner.close();
    }

    private static void emergencySystemWithCustomVectorHeap() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        cargarPacientesEnCola(heap);
        atenderPacientes(heap);
    }

    private static void cargarPacientesEnCola(VectorHeap<Paciente> heap) {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\uvg\\edu\\gt\\pacientes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    heap.add(new Paciente(parts[0], parts[1], parts[2].charAt(0)));
                } else {
                    System.out.println("Línea inválida: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void atenderPacientes(VectorHeap<Paciente> heap) {
        while (!heap.isEmpty()) {
            Paciente paciente = heap.remove();
            System.out.println("Atendiendo a: " + paciente);
            // Puedes agregar una pausa o esperar una confirmación del usuario aquí si lo deseas.
        }
    }

    private static void emergencySystemWithJavaPriorityQueue() {
        PriorityQueue<Paciente> queue = new PriorityQueue<>();
        cargarPacientesEnCola(queue);
        atenderPacientes(queue);
    }

    private static void cargarPacientesEnCola(java.util.PriorityQueue<Paciente> cola) {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\uvg\\edu\\gt\\pacientes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    cola.add(new Paciente(parts[0], parts[1], parts[2].charAt(0)));
                } else {
                    System.out.println("Línea inválida: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void atenderPacientes(java.util.PriorityQueue<Paciente> cola) {
        while (!cola.isEmpty()) {
            Paciente paciente = cola.poll();
            System.out.println("Atendiendo a: " + paciente);
            // Puedes agregar una pausa o esperar una confirmación del usuario aquí si lo deseas.
        }
    }
}


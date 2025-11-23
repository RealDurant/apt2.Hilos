//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        List<Pasajero> listaPasajeros = new ArrayList<>();
        Random generador = new Random();

        for (int codigo = 1; codigo <= 352; codigo++) {
            int valorTipo = generador.nextInt(4);
            String categoria;
            int nivelPrioridad;
            switch (valorTipo) {
                case 0 -> { categoria = "Niño";       nivelPrioridad = 1; }
                case 1 -> { categoria = "Adulto";     nivelPrioridad = 2; }
                case 2 -> { categoria = "Anciano";    nivelPrioridad = 3; }
                default -> { categoria = "Tripulacion"; nivelPrioridad = 4; }
            }
            listaPasajeros.add(new Pasajero(codigo, categoria, nivelPrioridad));
        }
        Barco barco = new Barco(listaPasajeros);

        // Crear las balsas
        List<Balsa> balsas = new ArrayList<>();
        balsas.add(new Balsa("Acasta", 1, 0.5));
        balsas.add(new Balsa("Banff", 2, 1));
        balsas.add(new Balsa("Cadiz", 3, 2));
        balsas.add(new Balsa("Deimos", 4, 4));
        balsas.add(new Balsa("Expedicion", 5, 8));


        // lanzar hilos de rescate
        List<Thread> hilos = new ArrayList<>();
        for (Balsa b : balsas) {
            Thread t = new Thread(new Rescate(b, barco));
            hilos.add(t);
            t.start();
        }

        for (Thread t : hilos) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Main interrumpido.");
            }
        }

        System.out.println(" Rescate finalizado. Pasajeros restantes: " + barco.ocupantesPendientes());
    }
}

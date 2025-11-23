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
    }
}
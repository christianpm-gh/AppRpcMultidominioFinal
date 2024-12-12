package cliente;

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class ClienteRPC {
    public static void main(String[] args) {
        try {
            XmlRpcClient cliente = new XmlRpcClient("http://localhost:7070/");
            Scanner scanner = new Scanner(System.in);
            Scanner scannerCadenas = new Scanner(System.in);

            imprimirCategorias();
            int categoria = scanner.nextInt();

            switch (categoria) {
                case 1:
                    procesarDominioTurismo(scanner, scannerCadenas, cliente);
                    break;

                case 2:
                    System.out.println("1. Ubicación UAM");
                    System.out.println("2. Datos profesor");
                    // Implementa las opciones para geografía
                    break;

                case 3:
                    System.out.println("1. Horarios de cines");
                    System.out.println("2. Horario de museos");
                    // Implementa las opciones para entretenimiento
                    break;

                case 4:
                    procesarDominioVideojuegos(scanner, scannerCadenas, cliente);
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } catch (Exception e) {
            System.err.println("JavaClient error: " + e);
        }
    }

    private static void procesarDominioTurismo(Scanner scanner, Scanner scannerCadenas, XmlRpcClient cliente) throws IOException, XmlRpcException {
        System.out.println("1. Convertir divisas");
        System.out.println("2. Clima de una ciudad");
        System.out.println("3. Hora exacta de una ciudad");
        System.out.print("Tu elección : ");
        int eleccionTurismo = scanner.nextInt();

        if (eleccionTurismo == 1) {
            System.out.print("Ingresa la divisa de origen (ej. MXN): ");
            String divisaOrigen = scannerCadenas.nextLine();
            System.out.print("Ingresa la divisa de destino (ej. USD): ");
            String divisaDestino = scannerCadenas.nextLine();
            System.out.print("Ingresa el monto: ");
            String monto = scannerCadenas.nextLine();

            Vector<String> paramsDivisas = new Vector<>();
            paramsDivisas.add(divisaOrigen);
            paramsDivisas.add(divisaDestino);
            paramsDivisas.add(monto);

            Object resultado = cliente.execute("turismo.cambiaDiv", paramsDivisas);
            System.out.println("Resultado de la conversión: " + resultado);

        } else if (eleccionTurismo == 2) {
            System.out.print("Ingresa el nombre de la ciudad: ");
            String ciudad = scannerCadenas.nextLine();

            Vector<String> paramsCiudad = new Vector<>();
            paramsCiudad.add(ciudad);

            Object clima = cliente.execute("turismo.getClima", paramsCiudad);
            if (clima != null) {
                System.out.println("El clima en " + ciudad + " es: " + clima);
            } else {
                System.out.println("No se encontró información climática para la ciudad.");
            }

        } else if (eleccionTurismo == 3) {
            System.out.print("Ingresa el nombre de la ciudad: ");
            String ciudad = scannerCadenas.nextLine();

            Vector<String> paramsCiudad = new Vector<>();
            paramsCiudad.add(ciudad);

            Object hora = cliente.execute("turismo.getHora", paramsCiudad);
            if (hora != null) {
                System.out.println("La hora exacta en " + ciudad + " es: " + hora);
            } else {
                System.out.println("No se encontró información horaria para la ciudad.");
            }

        } else {
            System.out.println("Opción no válida");
        }
    }

    private static void imprimirCategorias(){
        System.out.println("Selecciona una categoría:");
        System.out.println("1. Turismo");
        System.out.println("2. Geografía");
        System.out.println("3. Entretenimiento");
        System.out.println("4. Videojuegos");
        System.out.print("Tu elección : ");
    }

    private static void procesarDominioVideojuegos(Scanner scanner, Scanner scannerCadenas, XmlRpcClient cliente) throws IOException, XmlRpcException {
        System.out.println("1. Mostrar videojuegos por género");
        System.out.println("2. Mostrar videojuegos por estudio");
        System.out.println("3. Mostrar videojuegos en un año especifico");
        System.out.print("Tu elección : ");
        int eleccionVideojuegos = scanner.nextInt();
        if (eleccionVideojuegos == 1) {
            System.out.print("Teclea el género: ");
            String genero = scannerCadenas.nextLine();
            Vector<String> paramsGenero = new Vector<>();
            paramsGenero.add(genero);
            Vector<?> videojuegosPorGenero = (Vector<?>) cliente.execute("videojuegos.obtenerVideojuegosPorGenero", paramsGenero);
            if (videojuegosPorGenero.isEmpty()){
                System.out.println("No hay registro de videjuegos del genero introducido.");
            }else {
                System.out.println("Videojuegos del genero " + genero + ": ");
                for (Object juego : videojuegosPorGenero) {
                    System.out.println("\t- " + juego);
                }
            }
        } else if (eleccionVideojuegos == 2) {
            System.out.print("Teclea el estudio: ");
            String estudio = scannerCadenas.nextLine();
            Vector<String> paramsEstudio = new Vector<>();
            paramsEstudio.add(estudio);
            Vector<?> videojuegosPorEstudio = (Vector<?>) cliente.execute("videojuegos.obtenerVideojuegosPorEstudio", paramsEstudio);
            for (Object juego : videojuegosPorEstudio) {
                System.out.println("\t- " + juego);
            }
        } else if (eleccionVideojuegos == 3) {
            System.out.print("Teclea el año: ");
            int anio = scanner.nextInt();
            Vector<Integer> paramsAnio = new Vector<>();
            paramsAnio.add(anio);
            Vector<?> videojuegosPorAnio = (Vector<?>) cliente.execute("videojuegos.obtenerVideojuegosPorAnio", paramsAnio);
            if (videojuegosPorAnio.isEmpty()){
                System.out.println("No hay videojuegos registrados");
            }
            for (Object juego : videojuegosPorAnio) {
                System.out.println("\t- " + juego);
            }
        } else {
            System.out.println("Opcion no valida");
        }
    }

}

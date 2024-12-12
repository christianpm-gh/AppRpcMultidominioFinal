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
                    procesarDominioGeografia(scanner, scannerCadenas, cliente);
                    break;

                case 3:
                    procesarDominioEntretenimiento(scanner, scannerCadenas, cliente);
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

    private static void procesarDominioGeografia(Scanner scanner, Scanner scannerCadenas, XmlRpcClient cliente) throws IOException, XmlRpcException {
        System.out.println("1. Consultar ubicacion de espacios fisicos");
        System.out.println("2. Recuperar datos personales de un profesor");
        System.out.println("3. Listar materias impartidas por un profesor");
        System.out.print("Tu eleccion : ");
        int eleccionGeografia = scanner.nextInt();

        if (eleccionGeografia == 1) {
            System.out.print("Ingresa el tipo de espacio (ej. aula, laboratorio, cubiculo): ");
            String tipoEspacio = scannerCadenas.nextLine();

            Vector<String> paramsEspacio = new Vector<>();
            paramsEspacio.add(tipoEspacio);

            Vector<?> ubicaciones = (Vector<?>) cliente.execute("geografia.getUbicacionEspacioFisico", paramsEspacio);
            if (ubicaciones.isEmpty()) {
                System.out.println("No se encontraron ubicaciones para el tipo de espacio: " + tipoEspacio);
            } else {
                System.out.println("Ubicaciones para el tipo de espacio \"" + tipoEspacio + "\":");
                for (Object ubicacion : ubicaciones) {
                    System.out.println("\t- " + ubicacion);
                }
            }

        } else if (eleccionGeografia == 2) {
            System.out.print("Ingresa el id del profesor: ");
            int idProfesor = scanner.nextInt();

            Vector<Integer> paramsProfesor = new Vector<>();
            paramsProfesor.add(idProfesor);

            Object datosProfesor = cliente.execute("geografia.getDatosProfesor", paramsProfesor);
            if (datosProfesor != null) {
                System.out.println("Datos del profesor con id " + idProfesor + ":");
                System.out.println(datosProfesor);
            } else {
                System.out.println("No se encontró informacion para el profesor con id " + idProfesor + ".");
            }

        } else if (eleccionGeografia == 3) {
            System.out.print("Ingresa el id del profesor: ");
            int idProfesor = scanner.nextInt();

            Vector<Integer> paramsProfesor = new Vector<>();
            paramsProfesor.add(idProfesor);

            Vector<?> materias = (Vector<?>) cliente.execute("geografia.getMateriasProfesor", paramsProfesor);
            if (materias.isEmpty()) {
                System.out.println("No se encontraron materias impartidas por el profesor con ID " + idProfesor + ".");
            } else {
                System.out.println("Materias impartidas por el profesor con id " + idProfesor + ":");
                for (Object materia : materias) {
                    System.out.println("\t- " + materia);
                }
            }

        } else {
            System.out.println("Opción no válida.");
        }
    }

    private static void procesarDominioEntretenimiento(Scanner scanner, Scanner scannerCadenas, XmlRpcClient cliente) throws IOException, XmlRpcException {
        System.out.println("1. Cines y horarios donde se exhibe una pelicula");
        System.out.println("2. Horario de servicio de un museo");
        System.out.println("3. Costo de una obra por teatro");
        System.out.print("Tu eleccion : ");
        int eleccionEntretenimiento = scanner.nextInt();

        if (eleccionEntretenimiento == 1) {
            System.out.print("Ingresa el nombre de la pelicula: ");
            String pelicula = scannerCadenas.nextLine();

            Vector<String> paramsPelicula = new Vector<>();
            paramsPelicula.add(pelicula);

            Object horariosCine = cliente.execute("entretenimiento.getHorariosPorPelicula", paramsPelicula);
            if (horariosCine != null && !horariosCine.toString().isEmpty()) {
                System.out.println("Horarios para la pelicula \"" + pelicula + "\":");
                System.out.println(horariosCine);
            } else {
                System.out.println("No se encontraron horarios para la pelicula \"" + pelicula + "\".");
            }

        } else if (eleccionEntretenimiento == 2) {
            System.out.print("Ingresa el nombre del museo: ");
            String museo = scannerCadenas.nextLine();

            Vector<String> paramsMuseo = new Vector<>();
            paramsMuseo.add(museo);

            Object horarioMuseo = cliente.execute("entretenimiento.getHorarioMuseo", paramsMuseo);
            if (horarioMuseo != null && !horarioMuseo.toString().isEmpty()) {
                System.out.println("Horario para el museo \"" + museo + "\":");
                System.out.println(horarioMuseo);
            } else {
                System.out.println("No se encontro informacion para el museo \"" + museo + "\".");
            }

        } else if (eleccionEntretenimiento == 3) {
            System.out.print("Ingresa el nombre de la obra: ");
            String obra = scannerCadenas.nextLine();

            Vector<String> paramsObra = new Vector<>();
            paramsObra.add(obra);

            Object teatrosObra = cliente.execute("entretenimiento.getObra", paramsObra);
            if (teatrosObra != null && !teatrosObra.toString().isEmpty()) {
                System.out.println("Informacion para la obra \"" + obra + "\":");
                System.out.println(teatrosObra);
            } else {
                System.out.println("No se encontró informacion para la obra \"" + obra + "\".");
            }

        } else {
            System.out.println("Opción no válida.");
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

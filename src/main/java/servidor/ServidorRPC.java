package servidor;

import dominios.Entretenimiento;
import dominios.Turismo;
import dominios.Videojuego;
import org.apache.xmlrpc.WebServer;

public class ServidorRPC {

    public static void main(String[] args) {
        try {
            System.out.println("Iniciando el servidor XML-RPC...");

            WebServer server = new WebServer(7070);
            server.addHandler("turismo", new Turismo());
            server.addHandler("entretenimiento", new Entretenimiento());
            //server.addHandler("geografia", new Geografia());
            server.addHandler("videojuegos", new Videojuego());

            server.start();
            System.out.println("Servidor iniciado exitosamente.");

        } catch (Exception e) {
            System.err.println("Server error: " + e);
        }
    }
}

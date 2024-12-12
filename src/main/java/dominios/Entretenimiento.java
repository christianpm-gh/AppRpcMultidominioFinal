package dominios;

import servidor.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Entretenimiento {

    public String getHorariosPorPelicula(String nombrePelicula) throws SQLException {
        String query = "SELECT C.nom_cine, E.fecha, E.hora " +
                "FROM Exhibiciones E " +
                "JOIN Cines C ON E.id_cine = C.id_cine " +
                "JOIN Peliculas P ON E.id_pelicula = P.id_pelicula " +
                "WHERE P.titulo_pel = ?";

        StringBuilder horarios = new StringBuilder();

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nombrePelicula);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String cine = rs.getString("nom_cine");
                String fecha = rs.getString("fecha");
                String hora = rs.getString("hora");
                horarios.append(cine)
                        .append(", Fecha: ").append(fecha)
                        .append(", Hora: ").append(hora).append("\n");
            }
        }

        return horarios.toString();
    }


    public String getHorarioMuseo(String nombreMuseo) throws SQLException {
        String query = "SELECT M.nombre_museo, M.direccion_museo, H.dias_servicio, H.hora_apertura, H.hora_cierre " +
                "FROM Museos M " +
                "JOIN Horarios H ON M.id_museo = H.id_museo " +
                "WHERE M.nombre_museo = ?";
        String horarios = "";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nombreMuseo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre_museo");
                String direccion = rs.getString("direccion_museo");
                String dias = rs.getString("dias_servicio");
                String apertura = rs.getString("hora_apertura");
                String cierre = rs.getString("hora_cierre");
                horarios=nombre + "\nDirección: " + direccion +
                        "\nHorario: " + dias + " de " + apertura + " a " + cierre + " hrs\n";
            }
        }
        return horarios;
    }

    public String getObra(String nombreObra) throws SQLException {
        String query = "SELECT T.nombre_teatro, T.direccion_teatro, F.fecha, F.hora, F.costo " +
                "FROM Funciones F " +
                "JOIN Teatros T ON F.id_teatro = T.id_teatro " +
                "JOIN Obras O ON F.id_obra = O.id_obra " +
                "WHERE O.titulo_obra = ? " +
                "ORDER BY F.costo ASC";

        StringBuilder teatros = new StringBuilder();

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nombreObra);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String teatro = rs.getString("nombre_teatro");
                String direccion = rs.getString("direccion_teatro");
                String fecha = rs.getString("fecha");
                String hora = rs.getString("hora");
                String costo = rs.getString("costo");

                teatros.append(teatro).append("\nDirección: ").append(direccion)
                        .append("\nFecha: ").append(fecha).append(", Hora: ").append(hora).append("\nCosto: ")
                        .append(costo).append(" MXN\n\n");
            }
        }

        if (teatros.toString().equals(" ")) {
            teatros.append("No se encontraron teatros disponibles para la obra especificada.");
        }
        return teatros.toString();
    }

}

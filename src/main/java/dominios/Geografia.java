package dominios;

import servidor.DatabaseConfig;

import java.sql.*;
import java.util.Vector;

public class Geografia {

    public Vector<String> getUbicacionEspacioFisico(String tipoEspacio) throws SQLException {
        String sql = "SELECT ubicacion FROM EspacioFisico WHERE tipoEspacio LIKE ?";
        Vector<String> ubicaciones = new Vector<>();

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Configurar el parámetro de búsqueda
            stmt.setString(1, "%" + tipoEspacio + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ubicaciones.add(rs.getString("ubicacion"));
                }
            }
        }

        // Si no se encontraron resultados, registrar un mensaje
        if (ubicaciones.isEmpty()) {
            System.out.println("No se encontraron ubicaciones para el tipo de espacio: " + tipoEspacio);
        }

        return ubicaciones; // Devuelve un Vector compatible con XML-RPC
    }




    public String getDatosProfesor(int idProfesor) throws SQLException {
        String sql = """
            SELECT P.nombre, P.telefonoOficina, P.correo, E.ubicacion AS ubicacionCubiculo 
            FROM Profesor P
            LEFT JOIN EspacioFisico E ON P.ubicacionCubiculo = E.idEspacio
            WHERE P.idProfesor = ?
        """;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idProfesor);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return "Nombre: " + rs.getString("nombre") +
                            "\nTeléfono: " + rs.getString("telefonoOficina") +
                            "\nCorreo: " + rs.getString("correo") +
                            "\nUbicación del cubículo: " + rs.getString("ubicacionCubiculo");
                } else {
                    System.out.println("No se encontró un profesor con este ID.");
                    return null;
                }
            }
        }
    }

    public Vector<String> getMateriasProfesor(int idProfesor) throws SQLException {
        String sql = "SELECT nombreMateria FROM Materia WHERE idProfesor = ?";
        Vector<String> materias = new Vector<>();

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idProfesor);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    materias.add(rs.getString("nombreMateria"));
                }
            }
        }
        return materias;
    }
}

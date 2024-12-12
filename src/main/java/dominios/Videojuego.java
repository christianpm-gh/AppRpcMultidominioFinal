package dominios;

import servidor.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Videojuego {

    public String[] obtenerVideojuegosPorGenero(String genero) throws SQLException {
        String query = "SELECT v.nombre FROM videojuego v WHERE v.genero = ?";
        return getStrings(genero, query);
    }

    public String[] obtenerVideojuegosPorEstudio(String estudio) throws SQLException {
        String query = "SELECT v.nombre FROM videojuego v INNER JOIN estudio e ON v.estudio_id = e.id " +
                "WHERE e.nombre = ?";
        return getStrings(estudio, query);
    }

    public String[] obtenerVideojuegosPorAnio(int anio) throws SQLException {
        String query = "SELECT v.nombre FROM videojuego v WHERE YEAR(v.lanzamiento) = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, anio);
            try (ResultSet rs = stmt.executeQuery()) {
                ArrayList<String> videojuegos = new ArrayList<>();
                while (rs.next()) {
                    videojuegos.add(rs.getString("nombre"));
                }
                return videojuegos.toArray(new String[0]); // Convertir a arreglo
            }
        }
    }

    private String[] getStrings(String columna, String query) throws SQLException {
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, columna);
            try (ResultSet rs = stmt.executeQuery()) {
                ArrayList<String> videojuegos = new ArrayList<>();
                while (rs.next()) {
                    videojuegos.add(rs.getString("nombre"));
                }
                return videojuegos.toArray(new String[0]); // Convertir a arreglo
            }
        }
    }
}

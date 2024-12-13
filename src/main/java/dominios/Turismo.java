package dominios;

import servidor.DatabaseConfig;

import java.sql.*;

public class Turismo {

    public Double getFactorEx(String divisaO, String divisaD) throws SQLException {
        String sql = "SELECT factorEX FROM divisas WHERE divisaO = ? AND divisaD = ?";

        Connection conn = DatabaseConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        // Establecer los parámetros para la consulta SQL
        stmt.setString(1, divisaO);  // divO: moneda de origen
        stmt.setString(2, divisaD);  // divD: moneda de destino

        // Ejecutar la consulta
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                // Si se encuentra el factorEx, lo obtenemos
                return rs.getDouble("factorEX");
            } else {
                // Si no se encuentra el factorEx para las divisas, manejamos el error
                return -1.0;
            }
        }

    }

    public String getClima(String cd) throws SQLException {
        String query = "select clima from informacion_ciudad where ciudad = ?";

        Connection conn = DatabaseConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, cd);

        try(ResultSet rs = stmt.executeQuery()){
            if (rs.next()){
               return rs.getString("clima");
            }else {
                System.out.println("No se encontró registro de la ciudad elegida.");
                return null;
            }
        }
    }

    public String getHora(String cd) throws SQLException{
        String query = "select hora from informacion_ciudad where ciudad = ?";
        String hora = "";

        Connection conn = DatabaseConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, cd);

        try( ResultSet rs = stmt.executeQuery()){
            if(rs.next()){
                hora = rs.getString("hora");
                return hora;
            }else {
                System.out.println("No se encontró registro de la ciudad elegida.");
                return null;
            }
        }
    }

    public Double cambiaDiv(String div1, String div2, String monto) throws SQLException {
        Double ex= getFactorEx(div1,div2);
        return Double.parseDouble(monto)*ex;
    }

}

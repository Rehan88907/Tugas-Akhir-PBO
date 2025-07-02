package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {
    public static Connection getKoneksi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/perpustakaan", "root", ""
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

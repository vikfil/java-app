package datasource;

import model.Lector;
import repository.LectorRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) {

        Lector lector = new Lector("Ig", "Mick");
        LectorRepository lectorRepository = null;

        try {
            lectorRepository = new LectorRepository();
            lectorRepository.addLector(lector);
            lectorRepository.deleteLectorById(1);
            lectorRepository.selectAllLectors();

            System.out.println(lectorRepository.selectAllLectors());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
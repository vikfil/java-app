package repository;

import datasource.JDBCSingleton;
import model.Lector;
import model.Lesson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LectorRepository {
    private final static String INSERT_LECTOR = "INSERT INTO Lector(firstName, lastName) VALUES(?,?)";
    private final static String SELECT_ALL = "SELECT * FROM Lector";
    private final static String DELETE = "DELETE FROM Lector WHERE id = ?";
    private final static String UPDATE = "UPDATE lector SET firstName = ?, lastName = ? WHERE id  = ?";
    private final static String DROP_TABLE = "DROP TABLE Lector";
    private JDBCSingleton jdbc;

    public LectorRepository() throws SQLException {
        jdbc = JDBCSingleton.getInstance();
    }


    public boolean addLector(Lector lector) {
        boolean flag = false;
        try(Connection connection = jdbc.getConnection();
            PreparedStatement prep = connection.prepareStatement(INSERT_LECTOR)) {
          prep.setString(1, lector.getFirstName());
          prep.setString(2,lector.getLastName());
          prep.executeUpdate();
          flag = true;
        }catch (SQLException e) {e.printStackTrace();}

        return flag;
    }

    public List<Lector> selectAllLectors() {
        List<Lector> list = new ArrayList<>();
             try(Connection connection = jdbc.getConnection();
                 PreparedStatement prep = connection.prepareStatement(SELECT_ALL)) {
                 ResultSet resultSet = prep.executeQuery();
                 while (resultSet.next()) {
                    Lector lec = new Lector();
                    lec.setFirstName(resultSet.getString("firstName"));
                    lec.setLastName(resultSet.getString("lastName"));
                    list.add(lec);
                 }

             }catch (SQLException e) {
                e.printStackTrace();
             }
        return list;
    }

    public void updateLectorById(Lector lector, int id) {
        try(Connection connection = jdbc.getConnection();
            PreparedStatement prep = connection.prepareStatement(UPDATE)) {

            prep.setString(1, lector.getFirstName());
            prep.setString(2, lector.getLastName());
            prep.setInt(3, 2);
            prep.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLectorById(int id) {
        try(Connection connection = jdbc.getConnection();
            PreparedStatement prep = connection.prepareStatement(DELETE)) {
            prep.setInt(1, id);
            prep.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteLectorTable() {
        try(Connection connection = jdbc.getConnection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(DROP_TABLE);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

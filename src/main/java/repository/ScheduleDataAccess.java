package repository;

import datasource.JDBCSingleton;

public class ScheduleDataAccess {
    private final static String INSERT_LESSON = "INSERT INTO Lesson(weekday, lessonNumber, subjectId, groupId, lectorId, classroomId)"
                                                           + " VALUES(?,?,?,?,?,? )";
    private final static String SELECT_ALL = "SELECT * FROM Lector";
    private final static String DELETE = "DELETE FROM Lector WHERE id = ?";
    private final static String UPDATE = "UPDATE lector SET firstName = ?, lastName = ? WHERE id  = ?";
    private final static String DROP_TABLE = "DROP TABLE Lector";
    private JDBCSingleton jdbc;
}

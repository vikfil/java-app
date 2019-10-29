package model;

import java.util.Objects;

public class Classroom {
    private String classroomNumber;
    private String typeRoom;

    public Classroom() {}
    public Classroom(String classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    public Classroom(String classroomNumber, String typeRoom) {
        this.classroomNumber = classroomNumber;
        this.typeRoom = typeRoom;
    }

    public String getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(String classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(classroomNumber, typeRoom);
    }

    @Override
    public boolean equals(Object otherObject) {
        if(this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }

        if (getClass() != otherObject.getClass()) {
            return false;
        }
        Classroom other = (Classroom) otherObject;
        return Objects.equals(classroomNumber, other.classroomNumber) && Objects.equals(typeRoom, other.typeRoom);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classroomNumber='" + classroomNumber + '\'' +
                ", typeRoom='" + typeRoom + '\'' +
                '}';
    }
}

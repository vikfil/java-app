package model;

import java.util.List;
import java.util.Objects;

public class Group {
    private int groupNumber;
    private String groupName;
    private List<String> students;

    public Group() {}

    public Group(int groupNumber, String groupName, List<String> students) {
        this.groupNumber = groupNumber;
        this.students = students;
        this.groupName = groupName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public List<String> getStudents() {
        return students;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupNumber, students, groupName);
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
        Group other = (Group) otherObject;
        return groupNumber == other.groupNumber && Objects.equals(students, other.students) && Objects.equals(groupName, other.groupName);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupNumber=" + groupNumber +
                ", groupName='" + groupName + '\'' +
                ", students=" + students +
                '}';
    }
}

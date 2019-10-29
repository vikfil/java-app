package repository;

import model.Group;
import model.Lector;
import model.Lesson;
import java.util.*;
import java.util.stream.Collectors;

public class Schedule implements LessonRepository {
private   List<Lesson> lessons;

    public Schedule(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public boolean addNewLesson(Lesson lesson) {
        if (lessons.size() == 0) {
            lessons.add(lesson);
            return true;
        }
        for(Lesson les : lessons) {
            if (les.equals(lesson)) {
                return false;
            }
            return compareDayAndLessonNumber(les, lesson ) ? tripleEqualityBetweenLectorSubjectAndClassroom(les, lesson)
                                                           ? lessons.add(lesson) : tripleInequalityBetweenLectorSubjectAndClassroom(les, lesson)
                                                           ? lessons.add(lesson): false
                                                           : lessons.add(lesson);
        }
        return false;
    }

    @Override
    public List<Lesson> getAllLessons() {
        return new ArrayList<>(lessons);
    }

    @Override
    public List<Lesson> getScheduleForGroup(Group group) {
        if (group == null) {
            throw new IllegalArgumentException();
        }
        return lessons.stream()
                      .filter(Lesson -> Lesson.getGroup().equals(group))
                      .collect(Collectors.toList());
    }

    @Override
    public List<Lesson> getScheduleForLector(Lector lector) {
        if (lector == null) {
            throw new IllegalArgumentException();
        }
        return lessons.stream()
                      .filter(Lesson -> Lesson.getLector().equals(lector))
                      .collect(Collectors.toList());
    }

    private boolean compareDayAndLessonNumber(Lesson lesson1, Lesson lesson2) {
        return (lesson1.getWeekday().equals(lesson2.getWeekday())) && (lesson1.getNumberLesson() == lesson2.getNumberLesson());
    }

    private boolean tripleInequalityBetweenLectorSubjectAndClassroom(Lesson lesson1, Lesson lesson2) {
        return !(lesson1.getLector().equals(lesson2.getLector())) && !(lesson1.getClassroom().equals(lesson2.getClassroom()))
                && !(lesson1.getSubject().equals(lesson2.getSubject()));
    }

    private boolean tripleEqualityBetweenLectorSubjectAndClassroom(Lesson lesson1, Lesson lesson2) {
        return (lesson1.getLector().equals(lesson2.getLector())) && (lesson1.getClassroom().equals(lesson2.getClassroom()))
                   && (lesson1.getSubject().equals(lesson2.getSubject()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessons);
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
        Schedule other = (Schedule) otherObject;
        return Objects.equals(lessons, other.lessons);
    }

    @Override
    public String toString() {
        return "ScheduleDao{" +
                "lessons=" + lessons +
                '}';
    }
}

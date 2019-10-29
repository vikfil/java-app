package jsonTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.*;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonTester {

    public static void main(String[] args) {
        ScheduleToJson scheduleToJson = new ScheduleToJson("JsonFile.json");
        List<Lesson> listLessons = lessonGenerator(125);
        scheduleToJson.addLessonToFile(listLessons);
        List<Lesson> lessonFromJson =scheduleToJson.getAllLessonsFromFile();
        System.out.println(lessonFromJson);
    }


   private  static List<Lesson> lessonGenerator(int quantityLesson) {
        Lesson lesson = new Lesson();
        lesson.setWeekday(Week.MONDAY);
        lesson.setNumberLesson(2);
        lesson.setSubject(new Subject("Algebra"));
        lesson.setGroup(new Group(23, "Cybersecure", new ArrayList<>(Arrays.asList("Ivan", "Petro"))));
        lesson.setLector(new Lector("Ivan", "Petrovich"));
        lesson.setClassroom(new Classroom("23", "Lection"));

        List<Lesson> list = new ArrayList<>();
        for (int i = 0; i < quantityLesson; i++) {
            list.add(lesson);
        }
        return list;
    }
}

package repository;

import model.*;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ScheduleInMemoryTest {
    Group groupNull;
    Lector lectorNull;

    private Lesson lesson;
    private Lesson lesson1;
    private Lesson lesson2;
    private Lesson lesson3;
    private Lesson lesson4;
    private Lesson lesson5;
    private Lesson lesson6;
    private Lesson lesson7;


    @Before
    public void setUp() throws Exception {

        lesson = new Lesson(Week.MONDAY, 1, new Subject("History"), new Group(1, "one",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolayovich"), new Classroom("13"));
        lesson1 = new Lesson(Week.MONDAY, 2, new Subject("History"), new Group(1, "one",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolayovich"), new Classroom("13"));
        lesson2 = new Lesson(Week.MONDAY, 1, new Subject("Math"), new Group(1, "one",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolayovich"), new Classroom("13"));
        lesson3 = new Lesson(Week.MONDAY, 1, new Subject("History"), new Group(1, "one",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolay"), new Classroom("13"));
        lesson4 = new Lesson(Week.MONDAY, 1, new Subject("History"), new Group(1, "one",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolayovich"), new Classroom("12"));
        lesson5 = new Lesson(Week.MONDAY, 1, new Subject("History"), new Group(3, "three",new ArrayList<>(Arrays.asList("ivan","petro", "sergiy"))), new Lector("Igor", "Mykolayovich"), new Classroom("13"));
        lesson6 = new Lesson(Week.MONDAY, 1, new Subject("History"), new Group(1, "one",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolayovich"), new Classroom("13"));
        lesson7 = new Lesson(Week.MONDAY, 1, new Subject("Algebra"), new Group(3, "three",new ArrayList<>(Arrays.asList("ivan","petro", "sergiy"))), new Lector("Ivan", "Viktorovich"), new Classroom("1"));
    }

    @Test
    public void addLesson() {
         List<Lesson> lessonsList = new ArrayList<>();
         ScheduleInMemory scheduleInMemory = new ScheduleInMemory(lessonsList);
         Assert.assertEquals(true, scheduleInMemory.addNewLesson(lesson));
         Assert.assertEquals(false, scheduleInMemory.addNewLesson(lesson));
         Assert.assertEquals(true, scheduleInMemory.addNewLesson(lesson1));
         Assert.assertEquals(false, scheduleInMemory.addNewLesson(lesson2));
         Assert.assertEquals(false, scheduleInMemory.addNewLesson(lesson3));
         Assert.assertEquals(false, scheduleInMemory.addNewLesson(lesson4));
         Assert.assertEquals(true, scheduleInMemory.addNewLesson(lesson5));
         Assert.assertEquals(false, scheduleInMemory.addNewLesson(lesson6));
         Assert.assertEquals(true, scheduleInMemory.addNewLesson(lesson7));
    }
    @Test(expected = IllegalArgumentException.class)
    public void getScheduleForNullGroup() {
        ScheduleInMemory scheduleInMemory = scheduleWithLesson();
        scheduleInMemory.getScheduleForGroup(groupNull);
    }

    @Test
    public void getScheduleForGroup() {

        Group one = new Group(1, "one",new ArrayList<>(Arrays.asList("ivan","petro")));
        Group two = new Group(2, "two",new ArrayList<>(Arrays.asList("ivan","petro")));
        Group three = new Group(3, "three",new ArrayList<>(Arrays.asList("ivan","petro")));

        List<Lesson> listOne = new ArrayList<>();
        listOne.add(new Lesson(Week.MONDAY, 1, new Subject("History"), new Group(1, "one",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolayovich"), new Classroom("13")));
        listOne.add(new Lesson(Week.MONDAY, 2, new Subject("History"), new Group(1, "one",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolayovich"), new Classroom("13")));
        List<Lesson> listOneWrong = new ArrayList<>();
        listOneWrong.add(new Lesson(Week.MONDAY, 1, new Subject("History"), new Group(1, "one",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolayovich"), new Classroom("13")));

        List<Lesson> listTwo = new ArrayList<>();
        listTwo.add(new Lesson(Week.MONDAY, 1, new Subject("Math"), new Group(2, "two",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Ivan", "Dmytrovich"), new Classroom("3")));
        ScheduleInMemory scheduleInMemory = scheduleWithLesson();

        Assert.assertEquals(listOne, scheduleInMemory.getScheduleForGroup(one));
        Assert.assertNotEquals(listOneWrong, scheduleInMemory.getScheduleForGroup(one));
        Assert.assertEquals(listTwo, scheduleInMemory.getScheduleForGroup(two));
        Assert.assertNotEquals(listOne, scheduleInMemory.getScheduleForGroup(three));
        Assert.assertEquals((new ArrayList<>()), scheduleInMemory.getScheduleForGroup(three));


    }
    @Test(expected = IllegalArgumentException.class)
    public void getScheduleForNullLector() {
        ScheduleInMemory scheduleInMemory = scheduleWithLesson();
        scheduleInMemory.getScheduleForLector(lectorNull);
    }

    @Test
    public void getScheduleForLector() {
        Lector lector1 = new Lector("Igor", "Mykolayovich");
        Lector lector2 = new Lector("Ivan", "Dmytrovich");

        List<Lesson> listLectorOne = new ArrayList<>();
        listLectorOne.add(new Lesson(Week.MONDAY, 1, new Subject("History"), new Group(1, "one",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolayovich"), new Classroom("13")));
        listLectorOne.add(new Lesson(Week.MONDAY, 2, new Subject("History"), new Group(1, "one",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolayovich"), new Classroom("13")));

        List<Lesson> listLectorOneWrong = new ArrayList<>();
        listLectorOneWrong.add(new Lesson(Week.MONDAY, 1, new Subject("History"), new Group(1, "one",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolayovich"), new Classroom("13")));

        List<Lesson> listLectorTwo = new ArrayList<>();
        listLectorTwo.add(new Lesson(Week.MONDAY, 1, new Subject("Math"), new Group(2, "two",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Ivan", "Dmytrovich"), new Classroom("3")));

        ScheduleInMemory scheduleInMemory = scheduleWithLesson();

       Assert.assertEquals(listLectorOne, scheduleInMemory.getScheduleForLector(lector1));
       Assert.assertNotEquals(listLectorOneWrong, scheduleInMemory.getScheduleForLector(lector1));
       Assert.assertEquals(listLectorTwo, scheduleInMemory.getScheduleForLector(lector2));


    }
    @Test
    public void getAllLessons(){
        List<Lesson> expectedList = new ArrayList<>();
        expectedList.add(new Lesson(Week.MONDAY, 1, new Subject("History"), new Group(1, "one",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolayovich"), new Classroom("13")));
        expectedList.add(new Lesson(Week.MONDAY, 2, new Subject("History"), new Group(1, "one",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolayovich"), new Classroom("13")));
        expectedList.add(new Lesson(Week.MONDAY, 1, new Subject("Math"), new Group(2, "two",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Ivan", "Dmytrovich"), new Classroom("3")));
        expectedList.add(new Lesson(Week.MONDAY, 4, new Subject("History"), new Group(4, "four",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolay"), new Classroom("13")));

        List<Lesson> wrongList = new ArrayList<>();
        wrongList.add(new Lesson(Week.MONDAY, 1, new Subject("History"), new Group(1, "one",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolayovich"), new Classroom("13")));

        ScheduleInMemory scheduleInMemory = scheduleWithLesson();

        Assert.assertEquals(expectedList, scheduleInMemory.getAllLessons());
        Assert.assertNotEquals(wrongList, scheduleInMemory.getAllLessons());

    }

    private ScheduleInMemory scheduleWithLesson() {
         List<Lesson> lessonsList = new ArrayList<>();
         lesson = new Lesson(Week.MONDAY, 1, new Subject("History"), new Group(1, "one",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolayovich"), new Classroom("13"));
         lesson1 = new Lesson(Week.MONDAY, 2, new Subject("History"), new Group(1, "one",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolayovich"), new Classroom("13"));
         lesson2 = new Lesson(Week.MONDAY, 1, new Subject("Math"), new Group(2, "two",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Ivan", "Dmytrovich"), new Classroom("3"));
         lesson3 = new Lesson(Week.MONDAY, 4, new Subject("History"), new Group(4, "four",new ArrayList<>(Arrays.asList("ivan","petro"))), new Lector("Igor", "Mykolay"), new Classroom("13"));
         lessonsList.add(lesson);
         lessonsList.add(lesson1);
         lessonsList.add(lesson2);
         lessonsList.add(lesson3);
         ScheduleInMemory scheduleInMemory = new ScheduleInMemory(lessonsList);
         return scheduleInMemory;
    }
}
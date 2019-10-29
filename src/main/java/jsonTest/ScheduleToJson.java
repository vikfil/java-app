package jsonTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import model.Group;
import model.Lector;
import model.Lesson;
import repository.LessonRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScheduleToJson {
   private  final String jsonFile;

    public ScheduleToJson(String file) {
        jsonFile = file;
    }

    public void addLessonToFile(List<Lesson> lesson) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(jsonFile), lesson);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<Lesson> getAllLessonsFromFile() {
        List<Lesson> list = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            list = mapper.readValue(new File(jsonFile), List.class);
        }
        catch (JsonParseException e) { e.printStackTrace(); }
        catch (JsonMappingException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        return list;
    }

}

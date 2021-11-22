package grade.filesreader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class GradesReader {

    private final List<String> gradesList;

    public GradesReader(String filePath) {

        this.gradesList = readGradesFromFile(filePath);
    }

    private List<String> readGradesFromFile(String filePath) throws NoSuchElementException {

        List<String> fileLines = new ArrayList<>();
        try  {
           fileLines = Files.readAllLines(Paths.get(filePath));
        } catch (FileNotFoundException ex) {
            System.out.println("No such file: "+ filePath);
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        if (fileLines.size() < 1){
            throw new NoSuchElementException("Empty file content");
        }
        else {
            return fileLines;
        }
    }

    public List<String> getGradesList() {
        return gradesList;
    }
}

package grade.filesreader;

import grade.filesreader.GradesReader;
import grade.model.Grade;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class GradesParser {

    private List<Grade> gradesList;
    private final GradesReader gradesReader;

    public GradesParser(GradesReader gradesReader) {
        this.gradesReader = gradesReader;
        loadGradesToList();
    }

    private void loadGradesToList(){

        gradesList = new ArrayList<>();
        for (String s : gradesReader.getGradesList()) {
            try {
                String[] parts = s.split(";");
                Grade grade = new Grade();
                List<Float> list = new ArrayList<>();
                long toSkip = 3;
                for (String part : parts) {
                    if (toSkip > 0) {
                        toSkip--;
                        continue;
                    }
                    Float parseFloat = Float.parseFloat(part);
                    list.add(parseFloat);
                }
                grade.setGradesList(list);
                grade.setFirstName(parts[0]);
                grade.setLastName(parts[1]);
                grade.setClassName(parts[2]);
                gradesList.add(grade);
            } catch (PatternSyntaxException ex) {
                System.out.println("Unexpected pattern.");
            }
        }
    }

    public List<Grade> getGradesList() {
        return gradesList;
    }
}

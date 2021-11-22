package grade.program;

import grade.filesreader.GradesParser;
import grade.filesreader.GradesReader;
import grade.service.GradeManager;

public class GradesProgram {


    public static void main(String[] args) {

        String filePath = "grades.txt";
        GradeManager gradeManager = new GradeManager(new GradesParser(new GradesReader(filePath)));

        long startTime = System.nanoTime();
        System.out.println(gradeManager.findBestAverageClass());
        long endTime = System.nanoTime();
        System.out.println("method 1 : " + (endTime - startTime));

        startTime = System.nanoTime();
        System.out.println(gradeManager.findBestAverageClassByStreams());
        endTime = System.nanoTime();
        System.out.println("method 2 : " + (endTime - startTime));

    }
}

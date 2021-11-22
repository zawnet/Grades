package grade;

import grade.filesreader.GradesParser;
import grade.filesreader.GradesReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;


import static org.junit.Assert.*;

@RunWith(BlockJUnit4ClassRunner.class)
public class GradesReaderTest {
    String filePath = "grades.txt";


 @Test
 public void loadDataFromFileTest(){
     GradesReader gradesReader = new GradesReader(filePath);
     assertEquals(20, gradesReader.getGradesList().size());
 }

@Test
public void parseDataFromFileTest(){
     GradesParser gradesParser = new GradesParser(new GradesReader(filePath));
     assertEquals(20, gradesParser.getGradesList().size());
 }



}

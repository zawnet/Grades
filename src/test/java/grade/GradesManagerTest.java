package grade;

import grade.filesreader.GradesParser;
import grade.filesreader.GradesReader;
import grade.model.Grade;
import grade.service.GradeManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


@RunWith(BlockJUnit4ClassRunner.class)
public class GradesManagerTest {

    private GradeManager gradeManager;
    String filePath = "grades.txt";
    
    @Test
    public void findBestAverageClassTest(){

        // given
        gradeManager = new GradeManager(new GradesParser(new GradesReader(filePath)));
        // when
        Map.Entry<String, Double> result = gradeManager.findBestAverageClass();
        //then
        assertEquals("Expected the following result: \"3A=4.08\"", result, new AbstractMap.SimpleEntry<String,Double>("3A",4.08));
    }
}

package grade.service;

import grade.filesreader.GradesParser;
import grade.model.Grade;
import org.decimal4j.util.DoubleRounder;

import java.util.*;
import java.util.stream.Collectors;

public class GradeManager {

    private  final GradesParser gradesParser;

    public GradeManager(GradesParser gradesParser) {
        this.gradesParser = gradesParser;
    }

    public Map.Entry<String, Double> findBestAverageClass() throws NoSuchElementException {

        Map<String,Double> classAveragesMap = new HashMap<>();
        String maxAverageKey = null;
        Double maxValue = 0d;

        for (Grade grade : gradesParser.getGradesList()) {
            Double sum = 0.0d;
            int count = 0;
            for (Float value : grade.getGradesList()) {
                sum += value;
                count++;
            }

            try {
                double tmpAverage = sum / (double) count;
                double tmpAverage2 = 0;
                grade.setAverage(tmpAverage);
                if (classAveragesMap.containsKey(classAveragesMap.get(grade.getClassName()))) {
                    double currentAverageValue = classAveragesMap.get(grade.getClassName());
                    tmpAverage2 = (currentAverageValue + tmpAverage) / 2;
                    classAveragesMap.put(grade.getClassName(), currentAverageValue);
                } else {
                    tmpAverage2 = tmpAverage;
                    classAveragesMap.put(grade.getClassName(), tmpAverage);
                }
                maxValue = Math.max(Collections.max(classAveragesMap.values()), tmpAverage2);
                if (maxValue <= tmpAverage2) {
                    maxAverageKey = grade.getClassName();
                }
            }
            catch (ArithmeticException ex){
                if(count == 0){
                    System.out.println("Empty set of grades");
                }
            }
        }

        if(classAveragesMap.containsKey(maxAverageKey)) {
            return new java.util.AbstractMap.SimpleEntry<String, Double>(maxAverageKey, DoubleRounder.round(maxValue,2));
        }
        else {
            throw new NoSuchElementException("Not found class with maximum average.");
        }
    }

    public Map.Entry<String, Double> findBestAverageClassByStreams(){

        for (Grade grade : gradesParser.getGradesList()) {
            double tmpAverage = grade.getGradesList().stream()
                    .collect(Collectors.averagingDouble(Float::doubleValue)).doubleValue();
            grade.setAverage(tmpAverage);
        }
        Optional<Map.Entry<String, Double>> averages = gradesParser.getGradesList().stream()
                .collect(Collectors.groupingBy(Grade::getClassName,Collectors.averagingDouble(value -> DoubleRounder.round(value.getAverage(),2))))
                .entrySet().stream()
                .max(Comparator.comparingDouble(value -> value.getValue()));

        return averages.orElseThrow(() -> new NoSuchElementException("Not found class with maximum average."));
    }
}

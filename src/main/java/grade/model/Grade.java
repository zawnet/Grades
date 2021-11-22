package grade.model;

import java.util.List;

public class Grade {
    private String firstName;
    private String lastName;
    private String className;
    private Double average;
    private List<Float> gradesList;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getClassName() {
        return className;
    }

    public List<Float> getGradesList() {
        return gradesList;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setGradesList(List<Float> gradesList) {
        this.gradesList = gradesList;
    }


    public void setAverage(Double average) {
        this.average = average;
    }

    public Double getAverage() {
        return average;
    }

    @Override
    public String toString() {
        return "grade.model.Grade{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", className='" + className + '\'' +
                ", average=" + average +
                ", gradesList=" + gradesList +
                '}';
    }

}

package myLessons.lambda.function;

public class Student3 {
    String name;
    char sex;
    int age;
    int course;
    double avdGrade;

    public Student3(String name, char sex, int age, int course, double avdGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avdGrade = avdGrade;
    }

    @Override
    public String toString() {
        return "Student {" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avdGrade=" + avdGrade +
                '}';
    }
}

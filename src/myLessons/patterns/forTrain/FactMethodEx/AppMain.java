package myLessons.patterns.forTrain.FactMethodEx;

public class AppMain {
    public static void main(String[] args) {

        EmployeeFactory employeeFactory = new EmployeeFactory();

       Employee driver = employeeFactory.getEmployee(EmployeeType.DRIVER);
       Employee painter = employeeFactory.getEmployee(EmployeeType.PAINTER);
       Employee builder = employeeFactory.getEmployee(EmployeeType.BUILDER);

       driver.doWork();
       painter.doWork();
       builder.doWork();

    }
}

package myLessons.patterns.forTrain.FactMethodEx;

public class EmployeeFactory{

    public Employee getEmployee(EmployeeType type) {
        Employee toReturn = null;
        switch (type) {
            case DRIVER:
                toReturn = new DriverEmployee();
                break;
            case PAINTER:
                toReturn = new PainterEmployee();
                break;
            case BUILDER:
                toReturn = new BuilderEmployee();
                break;
            default:
                throw new RuntimeException("Employee is not found");

        }
        return toReturn;
    }



}

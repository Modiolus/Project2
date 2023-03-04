package myLessons.tasks_stepik.Stepik3_3;

public class Robot {

    public Direction getDirection() {
        // текущее направление взгляда
        return null;
    }

    public int getX() {
        // текущая координата X
        return 0;
    }

    public int getY() {
        // текущая координата Y
        return 0;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }

    public static void main(String[] args) {

    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int x = robot.getX();
        int y = robot.getY();
        Direction dir = robot.getDirection();
        if (x < toX) {
            turnTo(robot, Direction.RIGHT);
            while (x != toX) {
                robot.stepForward();
                x = robot.getX();
            }
        } else if (x > toX) {
            turnTo(robot, Direction.LEFT);
            while (x != toX) {
                robot.stepForward();
                x = robot.getX();
            }
        }
        if (y < toY) {
            turnTo(robot, Direction.UP);
            while (y != toY) {
                robot.stepForward();
                y = robot.getY();
            }
        } else if (y > toY) {
            turnTo(robot, Direction.DOWN);
            while (y != toY) {
                robot.stepForward();
                y = robot.getY();
            }
        }
    }

    public static void turnTo(Robot robot, Direction dir) {
        while (robot.getDirection() != dir)
            robot.turnRight();
    }

}

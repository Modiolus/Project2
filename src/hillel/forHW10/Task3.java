package hillel.forHW10;

public class Task3 {
    double x;
    double y;
    double a;
    double b;
    double c;

    public Task3(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void quadraticEquation() {
        double temp = (b * b) - (4 * a * c);
        double d = Math.sqrt(temp);
        if (temp < 0) {
            System.out.println("Ошибка! В корне отрицательное число");
        } else if (a == 0) {
            System.out.println("Ошибка! Делить на 0 нельзя!");
        } else {
            x = (-b + d) / (2 * a);
            System.out.println("x = " + x);
            y = (-b - d) / (2 * a);
            System.out.println("y = " + y);
        }
    }

    public static void main(String[] args) {
        Task3 task3 = new Task3(2, 4, 1);
        task3.quadraticEquation();
    }
}

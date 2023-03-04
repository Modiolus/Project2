package hillel.train;

public class SwitchCase {
    public static void main(String[] args) {
        int week = 1;

        System.out.println(day(4));
       System.out.println(dayNumber("Понедельник"));
    }

    static String day(Integer i) {
        String weekDay = null;
        switch (i) {

            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                weekDay = "Work Day";
                break;
            case 6:
            case 7:
                weekDay = "Weekend";
                break;
            default:
                weekDay = "End off earth ....";
                break;
        }
        return weekDay;
    }

    static int dayNumber(String day) {
        int number = 0;

        switch (day.toLowerCase()) {
            case "понедельник":
            case "monday":
                number = 1;
                break;
            case "Sunday":
                number = 2;
                break;
            default:
                number = 3;
        }
        return number;

    }
}

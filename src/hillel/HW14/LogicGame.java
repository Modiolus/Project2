package hillel.HW14;

import java.io.IOException;
import java.util.Scanner;

public class LogicGame {

    static int countGames = 0;
    static int scoringComp = 0;
    static int scoringUser = 0;

    static void codeGame() throws IOException {
        User user = new User();
        System.out.println(ResManager.getString("inputName"));
        Scanner scan = new Scanner(System.in);
        String n = scan.nextLine();
        user.setName(n);
        System.out.println(ResManager.getString("enteredName") + user.getName());
        System.out.println(ResManager.getString("inputNumberGames"));
        int numbersGames = scan.nextInt();

        if (numbersGames <= 0) {
            System.out.println(ResManager.getString("enterMoreThan"));
        } else {
            System.out.println(ResManager.getString("instructionChoiceOfMove"));
            do {
                System.out.println(ResManager.getString("choiceOfMove"));

                int enterUser = scan.nextInt();
                if (enterUser == 1) {
                    System.out.println(ResManager.getString("youInputRock"));
                } else if (enterUser == 2) {
                    System.out.println(ResManager.getString("youInputScissors"));
                } else if (enterUser == 3) {
                    System.out.println(ResManager.getString("youInputPaper"));
                } else if (enterUser == 4) {
                    System.out.println(ResManager.getString("youInterruptedTheGame"));
                    break;
                } else {
                    System.out.println(ResManager.getString("wrongChoice"));
                    break;
                }

                int randomComp = (int) (Math.random() * 3 + 1);

                switch (randomComp) {
                    case 1:
                        System.out.println(ResManager.getString("computerInputRock"));
                        break;
                    case 2:
                        System.out.println(ResManager.getString("computerInputScissors"));
                        break;
                    case 3:
                        System.out.println(ResManager.getString("computerInputPaper"));
                        break;
                }

                if (randomComp == 1 && enterUser == 2) {
                    System.out.println(ResManager.getString("computerWon"));
                    scoringComp++;
                } else if (randomComp == 2 && enterUser == 3) {
                    System.out.println(ResManager.getString("computerWon"));
                    scoringComp++;
                } else if (randomComp == 3 && enterUser == 1) {
                    System.out.println(ResManager.getString("computerWon"));
                    scoringComp++;
                } else if (randomComp == enterUser) {
                    System.out.println(ResManager.getString("draw"));
                } else {
                    System.out.println(ResManager.getString("youWon"));
                    scoringUser++;
                }
                countGames++;

            }
            while (countGames < numbersGames);

            System.out.println("================================");

            System.out.println(ResManager.getString("scoringComp") + scoringComp);
            System.out.println(ResManager.getString("scoringUser") + scoringUser);


            if (scoringComp > scoringUser) {
                System.out.println(ResManager.getString("name") + user.getName() +
                        ResManager.getString("resultGameComputerWin") + scoringComp + " : " + scoringUser);

                WriteAndTime.write(WriteAndTime.time(ResManager.getString("dateAndTime")) + ResManager.getString("name") + user.getName() + ResManager.getString("resultGameComputerWin") + scoringComp
                        + " : " + scoringUser + "\n================================================");

            } else if (scoringComp < scoringUser) {
                System.out.println(ResManager.getString("name") + user.getName() +
                        ResManager.getString("resultGameYouWin") + scoringUser + " : " + scoringComp);

                WriteAndTime.write(WriteAndTime.time(ResManager.getString("dateAndTime")) + ResManager.getString("name") + user.getName() + ResManager.getString("resultGameYouWin") + scoringUser
                        + " : " + scoringComp + "\n================================================");

            } else {
                System.out.println(ResManager.getString("name") + user.getName() +
                        ResManager.getString("resultGameDraw") + scoringComp + " : " + scoringUser);


                WriteAndTime.write(WriteAndTime.time(ResManager.getString("dateAndTime")) + ResManager.getString("name") + user.getName() + ResManager.getString("resultGameDraw") + scoringComp
                        + " : " + scoringUser + "\n================================================");

            }
        }
    }

}

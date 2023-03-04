package myLessons.generics.igra;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> { // при созданни экземпляра в <> может быть только наследник
    private String name;
    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addNewParticipant(T participant) {// при вызове метода в параметрах может быть только ссылка соотв. экземпляра
        participants.add(participant);
        System.out.println("V komandu " + name + " bil dobavlen noviy uchastnik"
                + " po imeni " + participant.getName());

    }

    public void playWith(Team<T> team) { // при вызове метода в параметрах может быть только соотв. команда
        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2); // return 0 or 1
        if (i == 0) {
            winnerName = this.name;
        } else {
            winnerName = team.name;
        }
        System.out.println("Viygrala comanda winnerName " + winnerName);
    }
}

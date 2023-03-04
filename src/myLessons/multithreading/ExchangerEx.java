package myLessons.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.stream.Collectors;

public class ExchangerEx {
    /* Exchanger - это синхронизатор, позволяющй обмениваться данными между двумя потоками, обеспечивает то что оба потока
     * получат информацию друг от друга одновременно
     * Когда первый поток вызывает метод exchange(), то он хочет поделиться информацией и при этом он будет заблокирован до тех пор
     * пока второй поток тоже не захочет поделиться информацией
     * Только после того как второй поток тоже захочет поделиться информацией(вызов метода exchange()) - происходит обмен информацией
     * и первый поток выходит из блокировки
     * Эти оба потока получают информацию в одно и тоже время. Информация которой они обмениваются должна быть одного типа данных
     */
    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();

        List<Action> friend1Action = new ArrayList<>();
        friend1Action.add(Action.NOJNICI);
        friend1Action.add(Action.BUMAGA);
        friend1Action.add(Action.NOJNICI);

        List<Action> friend2Action = new ArrayList<>();
        friend2Action.add(Action.BUMAGA);
        friend2Action.add(Action.KAMEN);
        friend2Action.add(Action.KAMEN);
        new BestFriend("Vanya", friend1Action, exchanger);
        new BestFriend("Petya", friend2Action, exchanger);
    }
}

enum Action {
    KAMEN, NOJNICI, BUMAGA;
}

class BestFriend extends Thread {
    private String name;
    private List<Action> myActions;
    private Exchanger<Action> exchanger;

    public BestFriend(String name, List<Action> myActions, Exchanger<Action> exchanger) {
        this.name = name;
        this.myActions = myActions;
        this.exchanger = exchanger;
        this.start();
    }

    private void whoWins(Action myAction, Action friendAction) {
        if ((myAction == Action.KAMEN && friendAction == Action.NOJNICI)
                || (myAction == Action.NOJNICI && friendAction == Action.BUMAGA)
                || (myAction == Action.BUMAGA && friendAction == Action.KAMEN)) {
            System.out.println(name + " WINS!!!");
        }
    }

    @Override
    public void run() {
        Action reply;
        for (Action action : myActions) {
            try {
                reply = exchanger.exchange(action);
                whoWins(action, reply);
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
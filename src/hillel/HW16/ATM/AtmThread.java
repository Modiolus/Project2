package hillel.HW16.ATM;

public class AtmThread extends Thread {

    public AtmThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {

            int put = (int) (Math.random() * 51 + 50);
            int withdraw = (int) (Math.random() * 51 + 50);

            System.out.println(getName() + " - put: " + put + "/" + "withdraw: " + withdraw + " - " + "amount: "
                    + (Amount.amount = Amount.amount + put - withdraw));
        }
    }

}

class Amount {
    public static int amount = 1000;

}

public class Withdraw extends Thread {

    private SharedAccount account;
    private int numberOfResources;


    public Withdraw(SharedAccount account,int numberOfResources) {
        this.account = account;
        this.numberOfResources = numberOfResources;
    }

    public void run() {
        int val = 0;
        do {
            try {
                Thread.sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                System.err.println(e.toString());
            }
            account.withdrawBalance();
            val++;
        } while (val != numberOfResources);
    }
}


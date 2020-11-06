public class Withdraw extends Thread {

    private ShareAccount account;

    public Withdraw(ShareAccount account) {
        this.account = account;
    }

    public void run() {
        while (account.getStill()) {
            try {
                Thread.sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                System.err.println(e.toString());
            }
            account.withdrawBalance();
        }
    }
}


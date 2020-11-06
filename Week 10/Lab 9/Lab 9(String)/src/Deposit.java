public class Deposit extends Thread {

    private ShareAccount account;
    private Double[] amount;
    private String[] currency;
    private int depositTime;
    private int count;

    public Deposit(ShareAccount account, Double[] amount, String[] currency) {
        this.account = account;
        this.amount = amount;
        this.currency = currency;
        depositTime = amount.length;
        count = 0;
    }

    public void run() {
        while (account.getStill()) {
            try {
                Thread.sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                System.err.println(e.toString());
            }
            account.depositBalance(amount[count], currency[count]);
            count++;
            if(count == depositTime) {
                account.setStill(false);
            }
        }
    }
}


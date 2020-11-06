public class Deposit extends Thread {

    private SharedAccount account;
    private int totalOfResources;
    private int numberOfResources;

//    private Double amount;
//    private String currency;
//    private int count;

    public Deposit(SharedAccount account, int totalOfResources) {
        this.account = account;
        this.totalOfResources = totalOfResources;
        this.numberOfResources = totalOfResources;
//        count = 0;
//        this.amount = amount;
//        this.currency = currency;
    }

    public void run() {
        synchronized (this) {
            //for (int count = 0; count < totalOfResources; count++) {
            while (numberOfResources > 0) {
                try {
                    Thread.sleep((int) (Math.random() * 2000));
                } catch (InterruptedException e) {
                    System.err.println(e.toString());
                }
                account.depositBalance(numberOfResources);
                numberOfResources--;
            }
        }
    }
}


public class SharedAccount {
    private Double balance;
//    private String currency;
//    private boolean still;

    SharedAccount() {
        balance = 0.0;
//        currency = null;
//        still = true;
    }

//    SharedAccount(Double balance, String currency) {
//        if (balance > 0 && currency != null) {
//            this.balance = balance;
//            this.currency = currency;
//        }
//    }

    public synchronized void depositBalance(int numberOfResources) {
        if (this.getBalance() != 0) {
            try {
                System.out.println("Waiting for withdraw...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (this.getBalance() == 0) {
            balance += numberOfResources;
            //this.setCurrency(currency);
        }
        System.out.println(toString() + " after deposit.");
        this.notify();
    }

    public synchronized void withdrawBalance() {
        if (this.getBalance() == 0) {
            try {
                System.out.println("Waiting for deposit...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (this.getBalance() > 0) {
            //if (this.getBalance() > 0) {
                balance -= ((int) Math.round(Math.random() * balance));
                if(balance < 0){
                    balance = 0.0;
                }
                System.out.println(toString() + " after withdraw.");
            //}
        }
        this.notify();
    }

    public double getBalance() {
        return balance;
    }

//    public void setCurrency(String currency) {
//        if (currency != null) {
//            this.currency = currency;
//        }
//    }
//
//    public String getCurrency() {
//        return currency;
//    }
//
//    public void setStill(boolean still) {
//        this.still = still;
//    }
//
//    public boolean getStill() {
//        return still;
//    }

    @Override
    public String toString() {
        return "Your account has: " + getBalance();
    }

//    @Override
//    public String toString() {
//        return "Your account has: " + getBalance() + " " + getCurrency();
//    }
}

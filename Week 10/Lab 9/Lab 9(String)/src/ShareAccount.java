public class ShareAccount {
    private Double balance;
    private String currency;
    private boolean still;

    ShareAccount() {
        balance = 0.0;
        currency = null;
        still = true;
    }

    ShareAccount(Double balance, String currency) {
        if (balance > 0 && currency != null) {
            this.balance = balance;
            this.currency = currency;
        }
    }

    public synchronized void depositBalance(Double amount, String currency) {
        while (this.getBalance() != 0) {
            try {
                System.out.println("Bank has money. Please withdraw first...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (this.getBalance() == 0) {
            balance += amount;
            this.setCurrency(currency);
        }
        System.out.println(toString()+ " after deposit");
        notify();
    }

    public synchronized void withdrawBalance() {
        while (this.getBalance() == 0) {
            try {
                System.out.println("Bank has no money. Please deposit first...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (this.getBalance() > 0) {
            balance -= ((int) Math.round(Math.random() * balance));
            if(balance < 0){
                balance = 0.0;
            }
            System.out.println(toString() + " after withdraw.");
        }
        notify();
    }

    public double getBalance() {
        return balance;
    }

    public void setCurrency(String currency) {
        if (currency != null) {
            this.currency = currency;
        }
    }

    public String getCurrency() {
        return currency;
    }

    public void setStill(boolean still) {
        this.still = still;
    }

    public boolean getStill(){
        return still;
    }

    @Override
    public String toString() {
        return "Your account has: " + getBalance() + " " + getCurrency();
    }
}

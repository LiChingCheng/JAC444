public class StrangeBank {
    public static void main(String[] args) {

        ShareAccount account = new ShareAccount();
        Double[] balance = {1.0, 2.0, 3.0};
        String[] currency = {"Dollar", "Euros", "Pounds"};

        Thread deposit = new Thread(new Deposit(account, balance, currency));
        Thread withdraw = new Thread(new Withdraw(account));

        deposit.start();
        withdraw.start();
    }
}


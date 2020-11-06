public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("usage: java SharedResource <number of resources>");
            System.exit(0);
        }

        int numberOfResources = 0;
        try {
            numberOfResources = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("String: <" + args[0] + "> must be an integer number.");
        }

        SharedAccount account = new SharedAccount();

        Deposit deposit = new Deposit(account, numberOfResources);
        Withdraw withdraw = new Withdraw(account, numberOfResources);

        deposit.start();
        withdraw.start();

    }
}


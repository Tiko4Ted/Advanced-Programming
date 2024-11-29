import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Calendar date = Calendar.getInstance();
        BankAccount account = new BankAccount(1000);

        DepositTransaction deposit = new DepositTransaction(500, date, "TXN001");
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(700, date, "TXN002");

        deposit.apply(account);
        System.out.println("Account Balance: " + account.getBalance());

        try {
            withdrawal.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Account Balance after withdrawal: " + account.getBalance());

        // Reverse withdrawal
        withdrawal.reverse(account);
        System.out.println("Account Balance after reversal: " + account.getBalance());
    }
}
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
@Override
public void apply(BankAccount ba) throws InsufficientFundsException {
    if (ba.getBalance() >= getAmount()) {
        ba.withdraw(getAmount());
        System.out.println("Withdrawal successful.");
    } else if (ba.getBalance() > 0) {
        double remaining = getAmount() - ba.getBalance();
        ba.withdraw(ba.getBalance());
        System.out.println("Partial withdrawal successful. Remaining: " + remaining);
    } else {
        throw new InsufficientFundsException("Insufficient funds for withdrawal.");
    }
}
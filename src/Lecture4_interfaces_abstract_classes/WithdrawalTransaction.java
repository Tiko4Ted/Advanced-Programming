public class WithdrawalTransaction extends BaseTransaction {
    private boolean reversed = false;

    public WithdrawalTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    @Override
    public void apply(BankAccount ba) {
        if (ba.getBalance() >= getAmount()) {
            ba.withdraw(getAmount());
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    public boolean reverse(BankAccount ba) {
        if (!reversed) {
            ba.deposit(getAmount());
            reversed = true;
            System.out.println("Withdrawal reversed.");
            return true;
        }
        return false;
    }
}
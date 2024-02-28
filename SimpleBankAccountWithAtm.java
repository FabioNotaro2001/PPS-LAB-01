package example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount{
    private double fee;    // Specified in order to follow AOC principle.

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance, double fee) {
        super(holder, balance);
        this.fee = fee;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if(amount > 0){
            super.deposit(userID, amount - this.fee);
        } else {
            throw new IllegalStateException("Deposit operation with illegal value!");
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        super.withdraw(userID, amount + this.fee);
    }
}

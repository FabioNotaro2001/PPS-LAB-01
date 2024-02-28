import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;

public class SimpleBankAccountWithAtmTest {
    private static final double FEE = 1;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0, FEE);
    }

    @Test
    void testCorrectDepositWithFee(){
        double amount = 10;
        bankAccount.deposit(accountHolder.getId(), amount);
        assertEquals(bankAccount.getBalance(), amount - FEE);
    }

    @Test 
    void testDepositWithIllegalValue(){
        double amount = -5;
        assertThrows(IllegalStateException.class, () -> bankAccount.deposit(accountHolder.getId(), amount));
    }

    @Test
    void correctWithdrawWithFee(){
        double depositAmount = 100;
        double withdrawAmount = 10;
        bankAccount.deposit(bankAccount.getHolder().getId(), depositAmount);
        bankAccount.withdraw(accountHolder.getId(), withdrawAmount);
        assertEquals(bankAccount.getBalance(), depositAmount - FEE - withdrawAmount - FEE);
    }

    @Test
    void wrongWithdrawWithFee(){
        double depositAmount = 100;
        double withdrawAmount = 200;
        bankAccount.deposit(bankAccount.getHolder().getId(), depositAmount);
        assertThrows(IllegalStateException.class, () -> bankAccount.withdraw(accountHolder.getId(), withdrawAmount));
    }
}

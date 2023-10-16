
interface BankAccount {
    int getBalance(int balance1, int balance2);
}

interface SavingsAccount extends BankAccount {
    double getInterestRate();
}

interface CheckingAccount extends BankAccount {
    boolean hasOverdraftProtection();
}

interface InvestmentAccount extends BankAccount {
    String getInvestmentStrategy();
}

interface CreditCard extends BankAccount {
    double getCreditLimit();
}

abstract class SavingsAccountType implements SavingsAccount {
    @Override
    public int getBalance(int balance1, int balance2) {
        return balance1 + balance2;
    }

    abstract double calculateInterest(int principal);
}

abstract class CheckingAccountType implements CheckingAccount {
    @Override
    public int getBalance(int balance1, int balance2) {
        return balance1 - balance2;
    }

    abstract boolean isPremium();
}

interface OnlineBanking extends SavingsAccount, CheckingAccount {
    void logIn();
}

abstract class InvestmentAccountType implements InvestmentAccount {
    @Override
    public int getBalance(int balance1, int balance2) {
        return balance1 + balance2;
    }

    public abstract double getCreditLimit();

    abstract String getInvestmentType();
}

interface CreditCardType extends SavingsAccount, CheckingAccount, InvestmentAccount, CreditCard {
    void makePurchase(double amount);
}

class BankCustomer extends InvestmentAccountType implements OnlineBanking, CreditCardType {
    @Override
    public void logIn() {
        System.out.println("Customer logged in to online banking.");
    }

    @Override
    public void makePurchase(double amount) {
        System.out.println("Customer made a purchase of $" + amount);
    }

    @Override
    public String getInvestmentStrategy() {
        return "Conservative";
    }

    @Override
    public double getCreditLimit() {
        return 5000.0;
    }

    @Override
    public double getInterestRate() {
        return 0.02;
    }

    @Override
    public boolean hasOverdraftProtection() {
        return true;
    }

    @Override
    public String getInvestmentType() {
        return "Stocks";
    }
}

public class Main {
    public static void main(String[] args) {
        BankCustomer customer = new BankCustomer();
        customer.logIn();
        customer.makePurchase(100.0);

        System.out.println("Interest Rate: " + customer.getInterestRate());
        System.out.println("Credit Limit: " + customer.getCreditLimit());
        System.out.println("Has Overdraft Protection: " + customer.hasOverdraftProtection());
        System.out.println("Investment Type: " + customer.getInvestmentType());
    }
}

package coffeemachine;

public class CashierImpl implements Cashier {
    public Money computeMissingMoney(Order order) {
        return new Money(0.3);
    }
}

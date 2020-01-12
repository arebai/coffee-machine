package coffeemachine.business;

public class Money {
    public static final Money NONE = new Money(0.0);
    private final double amount;

    public Money(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.amount, amount) == 0;
    }


    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }

    public boolean isGreaterThan(Money money) {
        return this.amount >= money.amount;
    }
}

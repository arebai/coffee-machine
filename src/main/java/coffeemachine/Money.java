package coffeemachine;

public class Money {

    public static final Money NONE = new Money(0);
    private final double amount;

    public Money(double amount) {
        this.amount = amount;
    }


}

package coffeemachine.business;

import coffeemachine.Drink;
import coffeemachine.business.impl.MenuMemoryImpl;
import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CashierTest {

    private static Offset<Double> OFFSET = Offset.offset(0.0000001);
    private Cashier cashier = new Cashier(new MenuMemoryImpl());

    @Test
    public void should_compute_tea_missing_money() {
        assertThat(cashier.checkout(Drink.TEA, new Money(0.3)).getAmount()).isCloseTo(new Money(0.1).getAmount(), OFFSET);
        assertThat(cashier.checkout(Drink.TEA, new Money(0.1)).getAmount()).isCloseTo(new Money(0.3).getAmount(), OFFSET);
        assertThat(cashier.checkout(Drink.TEA, new Money(0.2)).getAmount()).isCloseTo(new Money(0.2).getAmount(), OFFSET);
    }

    @Test
    public void should_compute_coffee_missing_money() {
        assertThat(cashier.checkout(Drink.COFFEE, new Money(0.4)).getAmount()).isCloseTo(new Money(0.2).getAmount(), OFFSET);
    }


    @Test
    public void should_compute_chocolate_missing_money() {
        assertThat(cashier.checkout(Drink.CHOCOLATE, new Money(0.3)).getAmount()).isCloseTo(new Money(0.2).getAmount(), OFFSET);
    }


}

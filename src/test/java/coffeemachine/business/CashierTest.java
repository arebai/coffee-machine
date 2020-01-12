package coffeemachine.business;

import coffeemachine.Drink;
import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CashierTest {

    private static Offset<Double> OFFSET = Offset.offset(0.0000001);

    @Test
    public void should_return_tea_missing_money() {
        Cashier cashier = new Cashier();
        assertThat(cashier.checkout(Drink.TEA, new Money(0.3)).getAmount()).isCloseTo(new Money(0.1).getAmount(), OFFSET);
        assertThat(cashier.checkout(Drink.TEA, new Money(0.1)).getAmount()).isCloseTo(new Money(0.3).getAmount(), OFFSET);
        assertThat(cashier.checkout(Drink.TEA, new Money(0.2)).getAmount()).isCloseTo(new Money(0.2).getAmount(), OFFSET);
    }


}

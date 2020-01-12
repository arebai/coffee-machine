package coffeemachine.business;

import coffeemachine.Drink;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CashierTest {

    @Test
    public void should_return_missing_money(){
        Cashier cashier = new Cashier();
        Money missingMoney = cashier.checkout(Drink.TEA, new Money(0.3));
        assertThat(missingMoney).isEqualTo(new Money(0.1));
    }
}

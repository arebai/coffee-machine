package coffeemachine.api;

import coffeemachine.api.impl.CashierImpl;
import coffeemachine.model.Drink;
import coffeemachine.model.Money;
import coffeemachine.model.Order;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class MissingMoneyTest {

    @Test
    public void should_generate_tea_missing_money_instruction() {
        // given
        DrinkMaker drinkMaker = mock(DrinkMaker.class);

        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker, new CashierImpl());
        Order order = Order.Builder
                .anOrder()
                .drink(Drink.TEA)
                .money(new Money(0.1))
                .build();
        // when
        coffeeMachine.process(order);
        // then
        Mockito.verify(drinkMaker).send("MISSING_MONEY:0,30");
    }

    @Test
    public void should_generate_coffee_missing_money_instruction() {
        // given
        DrinkMaker drinkMaker = mock(DrinkMaker.class);

        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker, new CashierImpl());
        Order order = Order.Builder
                .anOrder()
                .drink(Drink.COFFEE)
                .money(new Money(0.1))
                .build();
        // when
        coffeeMachine.process(order);
        // then
        Mockito.verify(drinkMaker).send("MISSING_MONEY:0,50");
    }
}

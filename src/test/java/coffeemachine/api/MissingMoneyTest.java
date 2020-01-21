package coffeemachine.api;

import coffeemachine.api.impl.CashierImpl;
import coffeemachine.model.Drink;
import coffeemachine.model.Money;
import coffeemachine.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class MissingMoneyTest {

    @Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[][]{
                        {anOrder(Drink.TEA, new Money(0.1)), "MISSING_MONEY:0,30"},
                        {anOrder(Drink.COFFEE, new Money(0.1)), "MISSING_MONEY:0,50"},
                        {anOrder(Drink.COFFEE, new Money(0.2)), "MISSING_MONEY:0,40"},
                        {anOrder(Drink.CHOCOLATE, new Money(0.2)), "MISSING_MONEY:0,30"},
                        {anOrder(Drink.CHOCOLATE, new Money(0.4)), "MISSING_MONEY:0,10"},
                        {anOrder(Drink.TEA, new Money(0.4)), "T::"},
                        {anOrder(Drink.CHOCOLATE, new Money(0.8)), "H::"},
                        {anOrder(Drink.JUICE, new Money(0.2)), "MISSING_MONEY:0,40"},

                }
        );
    }

    private Order order;
    private String expectedInstruction;

    public MissingMoneyTest(Order order, String expectedInstruction) {
        this.order = order;
        this.expectedInstruction = expectedInstruction;
    }

    @Test
    public void should_generate_missing_money_instruction() {
        // given
        DrinkMaker drinkMaker = mock(DrinkMaker.class);
        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker, new CashierImpl());

        // when
        coffeeMachine.process(order);

        // then
        Mockito.verify(drinkMaker).send(this.expectedInstruction);
    }


    private static Order anOrder(Drink drink, Money money) {
        return Order.Builder
                .anOrder()
                .drink(drink)
                .money(money)
                .build();
    }
}

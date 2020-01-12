package coffeemachine.api;

import coffeemachine.Drink;
import coffeemachine.Order;
import coffeemachine.api.impl.DrinkMakerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class DrinkMakerTest {

    @Test
    public void should_notify_missing_coffee_drink() {
        EmailNotifier emailNotifier = Mockito.mock(EmailNotifier.class);
        DrinkMaker drinkMaker = new DrinkMakerImpl(emailNotifier);
        Order coffeeOrder = Order.Builder.anOrder().drink(Drink.COFFEE).build();

        drinkMaker.process(coffeeOrder);

        Mockito.verify(emailNotifier, Mockito.times(1)).notifyMissingDrink(Drink.COFFEE);
    }
}

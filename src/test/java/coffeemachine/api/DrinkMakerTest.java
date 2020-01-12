package coffeemachine.api;

import coffeemachine.Drink;
import coffeemachine.Order;
import coffeemachine.api.impl.DrinkMakerImpl;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class DrinkMakerTest {

    @Test
    public void should_notify_when_missing_coffee_drink() {
        EmailNotifier emailNotifier = mock(EmailNotifier.class);
        BeverageQuantityChecker beverageQuantityChecker = mock(BeverageQuantityChecker.class);
        Mockito.when(beverageQuantityChecker.isEmpty(Drink.COFFEE)).thenReturn(true);

        DrinkMaker drinkMaker = new DrinkMakerImpl(beverageQuantityChecker, emailNotifier);
        Order coffeeOrder = Order.Builder.anOrder().drink(Drink.COFFEE).build();

        drinkMaker.process(coffeeOrder);

        verify(emailNotifier, times(1)).notifyMissingDrink(Drink.COFFEE);
        verify(beverageQuantityChecker, times(1)).isEmpty(Drink.COFFEE);
    }
}

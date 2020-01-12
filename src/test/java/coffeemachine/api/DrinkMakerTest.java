package coffeemachine.api;

import coffeemachine.Drink;
import coffeemachine.Order;
import coffeemachine.api.impl.DrinkMakerImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class DrinkMakerTest {

    private DrinkMaker drinkMaker;
    private BeverageQuantityChecker beverageQuantityChecker;
    private EmailNotifier emailNotifier;

    @Before
    public void init() {
        beverageQuantityChecker = mock(BeverageQuantityChecker.class);
        when(beverageQuantityChecker.isEmpty(Drink.COFFEE)).thenReturn(true);
        when(beverageQuantityChecker.isEmpty(Drink.JUICE)).thenReturn(false);
        emailNotifier = mock(EmailNotifier.class);
        drinkMaker = new DrinkMakerImpl(beverageQuantityChecker, emailNotifier);

    }

    @Test
    public void should_notify_when_missing_coffee_drink() {

        Order coffeeOrder = Order.Builder.anOrder().drink(Drink.COFFEE).build();
        drinkMaker.process(coffeeOrder);

        verify(emailNotifier, times(1)).notifyMissingDrink(Drink.COFFEE);
        verify(beverageQuantityChecker, times(1)).isEmpty(Drink.COFFEE);
    }


    @Test
    public void should_not_notify_when_juice_drink_is_no_missing() {

        Order juiceOrder = Order.Builder.anOrder().drink(Drink.JUICE).build();

        drinkMaker.process(juiceOrder);

        verify(beverageQuantityChecker, times(1)).isEmpty(Drink.JUICE);
        verify(emailNotifier, never()).notifyMissingDrink(Mockito.any());
    }

}

package coffeemachine.management;

import coffeemachine.business.Menu;
import coffeemachine.business.Money;
import coffeemachine.business.impl.MenuMemoryImpl;
import coffeemachine.model.Drink;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ManagementTest {

    private static final Menu MENU = new MenuMemoryImpl();

    @Test
    public void should_generate_report_with_tea_count() {
        Management management = new Management(() -> Collections.singletonList(Drink.TEA), MENU);
        Report report = management.generate();
        Map<Drink, Long> countByDrink = report.getCountByDrink();
        assertThat(countByDrink.get(Drink.TEA)).isEqualTo(1);
        assertThat(report.getTotalEarned()).isEqualTo(new Money(0.4));
    }

    @Test
    public void should_generate_report_when_pass_two_tea_one_juice() {
        // given
        Management management = new Management(() -> Arrays.asList(Drink.TEA, Drink.JUICE, Drink.TEA), MENU);

        // when
        Report report = management.generate();

        // then
        Map<Drink, Long> countByDrink = report.getCountByDrink();
        assertThat(countByDrink.get(Drink.TEA)).isEqualTo(2);
        assertThat(countByDrink.get(Drink.JUICE)).isEqualTo(1);
        assertThat(report.getTotalEarned()).isEqualTo(new Money(1.4));
    }

}

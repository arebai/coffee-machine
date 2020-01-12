package coffeemachine.management;

import coffeemachine.Drink;
import coffeemachine.business.Money;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ManagementTest {

    @Test
    public void should_generate_report_with_tea_count() {
        Management management = new Management();
        Report report = management.generate();
        Map<Drink, Long> countByDrink = report.getCountByDrink();
        assertThat(countByDrink.get(Drink.TEA)).isEqualTo(1);
        assertThat(report.getTotalEarned()).isEqualTo(new Money(0.4));
    }

}

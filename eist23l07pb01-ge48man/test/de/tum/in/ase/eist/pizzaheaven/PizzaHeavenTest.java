package de.tum.in.ase.eist.pizzaheaven;


import de.tum.in.ase.eist.foodpalace.Employee;
import de.tum.in.ase.eist.foodpalace.ShopManager;
import de.tum.in.ase.eist.pizzaheaven.pizza.Pizza;
import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
public class PizzaHeavenTest {

    private final PizzaHeaven restaurant = new PizzaHeaven();
    @Mock
    private Employee maliciousEmployee;
    @TestSubject
    private ShopManager shopManager;

    @Test
    public void testThatTheCorrectTypeOfPizzaIsCreated() {
        final var orderedPizza = restaurant.orderPizza("Margherita", true);

        // TODO this has been added to the solution
        assertEquals("Margherita Pizza", orderedPizza.getName());
        assertThrows(NullPointerException.class, () -> restaurant.orderPizza("Hawaii", false));
    }

    @Test
    public void testThatTakeawayPizzasAreBoxed() {
        final var pizza = restaurant.orderPizza("Bufalina", true);
        final var unboxedPizza = restaurant.orderPizza("Bufalina", false);

        // TODO this has been added to the solution
        assertTrue(pizza.isBoxed());
        assertFalse(unboxedPizza.isBoxed());
    }

    @Test
    public void infiltrateAniruddhsRestaurant() {
        expect(maliciousEmployee.getName()).andReturn("Aniruddh's Son");

        // prepare the mock here (don't forget to replay it)
        expect(maliciousEmployee.isQualified()).andReturn(false);
        replay(maliciousEmployee);
        this.shopManager = new ShopManager(List.of(maliciousEmployee));

        // test for yourself that the mock works as expected by observing the output of this method
        shopManager.testCurry();

        verify(maliciousEmployee);
    }
}
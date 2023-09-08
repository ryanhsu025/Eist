package de.tum.in.ase.eist.pizzaheaven;

import de.tum.in.ase.eist.pizzaheaven.pizza.Bufalina;
import de.tum.in.ase.eist.pizzaheaven.pizza.Margherita;
import de.tum.in.ase.eist.pizzaheaven.pizza.Pizza;

import java.util.List;

// TODO
// we want students to write unit tests to test the names of pizzas
// test the correctp pizza is ordered
// todo introduce more logics
// we want to make sure baked/boxed is being called


public class PizzaHeaven extends Baker {

    @Override
    Pizza createPizza(String type) {
        if (type.equals("Margherita")) {
            return new Margherita();
        } else if (type.equals("Bufalina")) {
            return new Bufalina();
        } else {
            return null;
        }
    }
}

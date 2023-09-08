package de.tum.in.ase.eist.pizzaheaven;

import de.tum.in.ase.eist.pizzaheaven.pizza.Pizza;

abstract class Baker {
    abstract Pizza createPizza(String type);

    Pizza orderPizza(String type, boolean isTakeaway) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.box(isTakeaway);
        return pizza;
    }
}
package de.tum.in.ase.eist.pizzaheaven;

import de.tum.in.ase.eist.pizzaheaven.pizza.Pizza;

public class PizzaManager {

    private final String name = "Chris";

    private final Baker restaurant;


    public PizzaManager() {
        this.restaurant = new PizzaHeaven();
    }

    public static void main(String[] args) {
        PizzaManager pizzaManager = new PizzaManager();
        Pizza pizza = pizzaManager.restaurant.orderPizza("Margherita", true);
        System.out.println("You ordered a " + pizza.getName());

        Pizza pizza2 = pizzaManager.restaurant.orderPizza("Bufalina", false);
        System.out.println("You ordered a " + pizza2.getName());
    }
}
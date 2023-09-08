package de.tum.in.ase.eist.foodpalace;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ShopManager {

    private final String name = "Aniruddh";

    private final int id = 1;

    private FoodPalace foodPalace;

    private List<Employee> employees;

    public ShopManager(final List<Employee> employees) {
        this.foodPalace = new FoodPalace(new SaladBar(), new Curry(), new IceCreamStand());
        this.employees = employees;
    }

    public ShopManager() {
        this(Collections.emptyList());
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void testSalad() {
        foodPalace.makeSalad();
    }

    public void testCurry() {
        // Delegating curry to our first employee
        if (employees.size() >= 1) {
            foodPalace.makeCurry(employees.get(0));
        } else {
            throw new IllegalStateException("We need to hire more people!");
        }
    }

    public void testIceCream() {
        foodPalace.makeIceCream();
    }

    public static void main(String[] args) {
        final var employees = new LinkedList<Employee>();
        employees.add(new Employee("Aniruddh's son", true));
        ShopManager shopManager = new ShopManager(employees);
        shopManager.testSalad();
        shopManager.testCurry();
        shopManager.testIceCream();
    }

}
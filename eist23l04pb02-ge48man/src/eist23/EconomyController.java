package eist23;

import java.util.HashMap;
import java.util.Map;

public class EconomyController {
    private double credits;
    private Map<String, Integer> resources;

    public EconomyController() {
        this.credits = 100000;
        this.resources = new HashMap<>();
        resources.put("durasteel", 500);
        resources.put("plasma converters", 100);
        resources.put("hyperdrive units", 50);
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public int getResourceQuantity(String resource) {
        return resources.getOrDefault(resource, 0);
    }

    public void collectTax(Planet planet, double taxQuantity) {
        planet.setBankBalance(planet.getBankBalance()-taxQuantity);
        this.setCredits(this.getCredits()+taxQuantity);
    }

    public void addResource(String resource, int quantity) {
        resources.put(resource, resources.getOrDefault(resource, 0) + quantity);
    }

    public void removeResource(String resource, int quantity) {
        int currentQuantity = resources.getOrDefault(resource, 0);
        if (currentQuantity >= quantity) {
            resources.put(resource, currentQuantity - quantity);
        } else {
            System.out.println("Insufficient quantity of " + resource);
        }
    }

    public void tradeCredits(int amount) {
        if (credits >= amount) {
            credits -= amount;
            System.out.println("Credits traded: " + amount);
        } else {
            System.out.println("Insufficient credits for trade");
        }
    }
}


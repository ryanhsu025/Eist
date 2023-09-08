package eist23;

import java.util.List;

public class ManagementSystem {
    private EconomyController economyController;
    private MilitaryController militaryController;

    public ManagementSystem() {
        economyController = new EconomyController();
        militaryController = new MilitaryController();
    }

    public void collectTax(Planet planet, double taxQuantity) {
        economyController.collectTax(planet, taxQuantity);
    }

    public void tradeCredits(int amount) {
        economyController.tradeCredits(amount);
    }

    public void addResource(String resource, int quantity) {
        economyController.addResource(resource, quantity);
    }

    public void removeResource(String resource, int quantity) {
        economyController.removeResource(resource, quantity);
    }

    public void enlistTrooper(Personnel personnel) {
        militaryController.enlistTrooper(personnel);
    }

    public void dismissTrooper(Personnel personnel) {
        militaryController.dismissTrooper(personnel);
    }

    public void fireDeathStar(Planet planet) {
        militaryController.fireDeathStar(planet);
    }

    public void updateLaws(Planet planet, List<String> laws) {
        militaryController.updateLaws(planet, laws);
    }

    public void declareWar(Planet planet1, Planet planet2) {
        militaryController.declareWar(planet1, planet2);
    }

    public EconomyController getEconomyController() {
        return economyController;
    }

    public MilitaryController getMilitaryController() {
        return militaryController;
    }
}

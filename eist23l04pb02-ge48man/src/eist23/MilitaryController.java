package eist23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MilitaryController {
    private List<Planet> conqueredPlanets;
    private int armySize;
    private boolean isDeathStarOperational;
    private Set<Personnel> personnelSet;

    public MilitaryController() {
        conqueredPlanets = new ArrayList<>();
        armySize = 0;
        isDeathStarOperational = false;
        personnelSet = new HashSet<>();
    }

    public void enlistTrooper(Personnel personnel) {
        //TODO 1: Implement this method
        if ((personnel.getRole() == Roles.StormTrooper || personnel.getRole() == Roles.Lieutenant) && !personnelSet.contains(personnel)) {
            personnelSet.add(personnel);
            armySize++;
        } else {
            System.out.println(personnel.getName() + " cannot be enlisted as a trooper.");
        }
    }

    public void dismissTrooper(Personnel personnel) {
        //TODO 1: Implement this method
        if (personnelSet.remove(personnel)) {
            armySize--;
        } else {
            System.out.println(personnel.getName() + " is not enlisted as a trooper.");
        }
    }

    public void fireDeathStar(Planet planet) {
        //TODO 1: Implement this method
        if (isDeathStarOperational) {
            int population = planet.getPopulation();
            planet.setPopulation(population / 2);
            System.out.println("Death Star fired upon " + planet.getName() + ", population reduced to " + planet.getPopulation());
        } else {
            System.out.println("The Death Star is not operational.");
        }
    }

    public void updateLaws(Planet planet, List<String> laws) {
        //TODO 1: Implement this method
        planet.setLaws(laws);
    }

    public void declareWar(Planet planet1, Planet planet2) {
        //TODO 1: Implement this method
        if (planet1.isInhabitable() && planet2.isInhabitable()) {
            System.out.println("War declared between " + planet1.getName() + " and " + planet2.getName());
        } else {
            System.out.println("Both planets must be inhabitable to declare war.");
        }
    }

    public List<Planet> getConqueredPlanets() {
        return conqueredPlanets;
    }

    public int getArmySize() {
        return armySize;
    }

    public boolean isDeathStarOperational() {
        return isDeathStarOperational;
    }

    public Set<Personnel> getPersonnelSet() {
        return personnelSet;
    }

    public void setDeathStarOperational(boolean deathStarOperational) {
        isDeathStarOperational = deathStarOperational;
    }
}


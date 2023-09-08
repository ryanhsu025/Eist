package eist23;

import java.util.ArrayList;

public class Admiral {
    private String name;
    private ManagementSystem managementSystem;

    public Admiral(String name, ManagementSystem managementSystem) {
        this.name = name;
        this.managementSystem = managementSystem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ManagementSystem getManagementSystem() {
        return managementSystem;
    }

    public void setManagementSystem(ManagementSystem managementSystem) {
        this.managementSystem = managementSystem;
    }

    public static void main(String[] args) {

        Admiral admiral = new Admiral("Admiral", new ManagementSystem());
        Personnel personnel = new Personnel("person", 18, Roles.Medic);
        admiral.managementSystem.enlistTrooper(personnel);
        admiral.managementSystem.dismissTrooper(personnel);
        Planet planet = new Planet("earth", new ArrayList<>(), 1, 1, true);
        Planet planet2 = new Planet("mars", new ArrayList<>(), 1, 1, true);
        admiral.managementSystem.fireDeathStar(planet);
        admiral.managementSystem.updateLaws(planet, new ArrayList<>());
        admiral.managementSystem.declareWar(planet, planet2);

    }

}

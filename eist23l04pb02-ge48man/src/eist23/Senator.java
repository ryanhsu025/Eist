package eist23;

import java.util.ArrayList;

public class Senator {
    private String name;
    private ManagementSystem managementSystem;

    public Senator(String name, ManagementSystem managementSystem) {
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
        Senator senator = new Senator("Senator", new ManagementSystem());
        senator.managementSystem.collectTax(new Planet("earth", new ArrayList<>(), 1, 1, true), 1);
        senator.managementSystem.tradeCredits(1);
        senator.managementSystem.addResource("wood",1);
        senator.managementSystem.removeResource("wood", 1);
    }
}

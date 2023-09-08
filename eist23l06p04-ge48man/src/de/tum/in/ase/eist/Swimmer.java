package de.tum.in.ase.eist;

public class Swimmer {
    // private final String name;
    private static int counter = 0;
    private final int id;

    public Swimmer() {
        this.id = counter++;
    }

    public int getId() {
        return this.id;
    }

    public void goToSwimmingPool(SwimmingPool swimmingPool, SwimmingPoolActionOrder order) {
        swimmingPool.handleEntryRequestDeadlockFree(this, order);
    }
}

package de.tum.in.ase.eist.restaurant.profitCalculation.dead;

public class WorkingDay extends Thread {
    private BusinessSoftwareEngineer salespenguin;

    public WorkingDay(BusinessSoftwareEngineer salesman) {
        this.salespenguin = salesman;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            System.out.println(
                    salespenguin.getName() + "'s Customer buys a dish. Dish number: " + i);
            salespenguin.sellDish(20);
        }
    }
}

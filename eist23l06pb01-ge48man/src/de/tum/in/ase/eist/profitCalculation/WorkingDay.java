package de.tum.in.ase.eist.profitCalculation;

public class WorkingDay extends Thread {
    private BusinessSoftwareEngineer salesman;

    public WorkingDay(BusinessSoftwareEngineer salesman) {
        this.salesman = salesman;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            System.out.println(
                    salesman.getName() + "'s Customer buys a dish. Dish number: " + i);

            salesman.sellDish(20);
        }
    }
}

package de.tum.in.ase.eist.restaurant.profitCalculation.dead;

public class Main {
    public static void main(String[] args) {
        BusinessSoftwareEngineer aniruddh = new BusinessSoftwareEngineer("Aniruddh");
        BusinessSoftwareEngineer simon = new BusinessSoftwareEngineer("Simon");

        aniruddh.setPartner(simon);
        simon.setPartner(aniruddh);

        WorkingDay aniruddhsWorkingDay = new WorkingDay(aniruddh);
        WorkingDay simonsWorkingDay = new WorkingDay(simon);
        Thread aniruddhsCustomerThread = new Thread(aniruddhsWorkingDay);
        Thread simonsCustomerThread = new Thread(simonsWorkingDay);

        aniruddhsCustomerThread.start();
        simonsCustomerThread.start();

        try {
            aniruddhsCustomerThread.join();
            simonsCustomerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Something went wrong. Interrupted!");
            return;
        }

        System.out.println("Aniruddh has " + aniruddh.getBalance());
        System.out.println("Simon has " + simon.getBalance());
    }
}

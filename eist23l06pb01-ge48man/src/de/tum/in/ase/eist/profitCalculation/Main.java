package de.tum.in.ase.eist.profitCalculation;

public class Main {

    static BusinessSoftwareEngineer aniruddh;
    static BusinessSoftwareEngineer simon;

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

    public static BusinessSoftwareEngineer getAniruddh() {
        return aniruddh;
    }

    public static BusinessSoftwareEngineer getSimon() {
        return simon;
    }
}
// Todo 4.5 Make sure the end of your Output is the same
    /*
    Aniruddh has 100000
    Simon has 100000
    */

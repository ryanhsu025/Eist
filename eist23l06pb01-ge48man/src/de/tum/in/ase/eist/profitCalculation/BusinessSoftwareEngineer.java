package de.tum.in.ase.eist.profitCalculation;

public class BusinessSoftwareEngineer {
    private String name;
    private int balance;
    private BusinessSoftwareEngineer partner;

    public BusinessSoftwareEngineer(String name) {
        this.name = name;
        this.balance = 0;
    }

    public void setPartner(BusinessSoftwareEngineer partner) {
        this.partner = partner;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    // TODO 4.2 Run the main Method, do both Software Engineers earn 10000? If not why could this be?
    // TODO 4.3 Try Synchronizing sellDish and addMoney. What happens?
    // TODO 4.4 What would the solution to this problem be, so that the Threads work properly and the expected Money is earned?
    public void sellDish(int price) {
        // TODO 4.1 Implement this method as described in the problem statement
        this.addMoney(price/2);
        partner.addMoney(price/2);
    }

    public synchronized void addMoney(int amount) {
        balance += amount;
    }
}

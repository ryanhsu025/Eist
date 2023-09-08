package de.tum.in.ase.eist.restaurant.profitCalculation.dead;

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

    public synchronized int getBalance() {
        return balance;
    }

    public void sellDish(int price) {
        this.addMoney(price / 2);
        partner.addMoney(price / 2);
    }

    public synchronized void addMoney(int amount) {
        balance += amount;
    }
}

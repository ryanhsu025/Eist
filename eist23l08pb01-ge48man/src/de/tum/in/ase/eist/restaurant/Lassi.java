package de.tum.in.ase.eist.restaurant;

public class Lassi extends Dishes {

    private final static String name = "Lassi";

    public void makeLassi() {
        System.out.println("Your Lassi (Indian Drink) has been made!");
    }

    public void serveLassi() {
        if(Table.currentTableRepresentation.compareTo(Table.cleanTableRepresentation)!=0) {
            Table.cleanTable();
        }
        if(Table.areCandlesLighted == false) {
            Table.lightCandles();
        }
        if(Table.waterLevel  <= 0.5) {
            Table.fillWater();
        }
        Table.readDaysMenu();
        Table.askForFurtherRequests();
    }

    public String getName() {
        return name;
    }
}

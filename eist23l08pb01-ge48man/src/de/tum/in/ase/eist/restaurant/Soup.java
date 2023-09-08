package de.tum.in.ase.eist.restaurant;

public class Soup extends Dishes {

    private final static String name = "Soup";

    public void makeSoup() {
        System.out.println("Your Soup has been made!");
    }

    public void serveSoup() {
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

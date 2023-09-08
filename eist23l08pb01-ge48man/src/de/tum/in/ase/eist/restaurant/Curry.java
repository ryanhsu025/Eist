package de.tum.in.ase.eist.restaurant;

public class Curry extends Dishes {

    private final static String name = "Curry";

    public void makeCurry() {
        System.out.println("Your Curry has been made!");
    }

    public void serveCurry() {
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

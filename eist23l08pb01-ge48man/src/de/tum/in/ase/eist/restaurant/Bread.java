package de.tum.in.ase.eist.restaurant;

public class Bread extends Dishes {

    private static final String name = "Bread";

    public void makeBread() {
        System.out.println("Your Bread has been made!");
    }

    public void serveBread() {
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

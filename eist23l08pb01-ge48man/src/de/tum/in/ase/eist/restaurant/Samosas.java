package de.tum.in.ase.eist.restaurant;

public class Samosas extends Dishes {

    private final static String name = "Samosas";

    public void makeSamosas() {
        System.out.println("Your Samosas (Indian Snack) has been made!");
    }

    public void serveSamosas() {
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

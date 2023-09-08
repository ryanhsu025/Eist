package de.tum.in.ase.eist.restaurant;

public class Rice extends Dishes {

    private final static String name = "Rice";

    public void makeRice() {
        System.out.println("Your Rice has been made!");
    }

    public void serveRice() {
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

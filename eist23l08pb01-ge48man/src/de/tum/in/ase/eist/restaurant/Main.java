package de.tum.in.ase.eist.restaurant;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Curry curry = new Curry();
        IceCreamStand iceCreamStand = new IceCreamStand();
        Samosas samosas = new Samosas();

        System.out.println(Table.currentTableRepresentation);
        System.out.println("Currently the table is not clean enough, to avoid customer complaints, we have to clean it!");
        Table.cleanTable();
        System.out.println(Table.currentTableRepresentation);
        System.out.println("Now the table is clean.");
        Table.addFlowers("Rose", 3);
        System.out.println("Currently we have these flowers on the table:");
        for (Map.Entry<String, Integer> flowers : Table.flowersOnTable.entrySet()) {
            System.out.println(flowers.getKey() + ":" + flowers.getValue());
        }
        System.out.println(Table.readDaysMenu());
        curry.makeCurry();
        samosas.makeSamosas();
        System.out.println("While preparing the food, we have to entertain our customers, let's sing a song!");
        Table.singSong();
        curry.serveCurry();
        samosas.serveSamosas();
        System.out.println(Table.askForFurtherRequests());
        Table.waterLevel = 0.1;
        Table.areCandlesLighted = false;
        Table.currentTableRepresentation =  "|||||||\n" +
                "|&  **|\n" +
                "|' & '|\n" +
                "|* *'*|\n" +
                "| &   |\n" +
                "|||||||" ;
        iceCreamStand.makeIceCream();
        iceCreamStand.serveIceCream();
        System.out.println(Table.askForFurtherRequests());

    }
}

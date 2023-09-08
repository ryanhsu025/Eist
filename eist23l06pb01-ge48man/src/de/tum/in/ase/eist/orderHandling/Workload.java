package de.tum.in.ase.eist.orderHandling;

import de.tum.in.ase.eist.orderReceival.SynchronizedRestaurantList;

import java.util.*;

public class Workload {

    public static void main(String[] args) {

        SynchronizedRestaurantList<String> files = new SynchronizedRestaurantList<>();
        // Represent different incoming Orders
        String[] orders = {
                "Aniruddh ordered Salad",
                "Aniruddh ordered Curry",
                "Aniruddh ordered IceCream",
                "Aniruddh ordered Salad",
                "Aniruddh ordered Curry",
                "Aniruddh ordered IceCream",
                "Aniruddh ordered Bread",
                "Aniruddh ordered Lassi",
                "Aniruddh ordered Rice",
        };

        for (int i = 0; i < orders.length; i++) {
            try {
                files.add(i, orders[i]);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Map to keep track how many times a Word/Order was placed
        Map<String, Integer> wordCounter = new LinkedHashMap<>();

        for (int i = 0; i < files.size(); i++) {
            // TODO 2.1 Map Reduce Each file
            try {
                WordReducer.reduce(files.get(i), wordCounter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // for demonstrational purposes, I have left the outputfile without the filtering inside
        StringBuilder outputfile = new StringBuilder();
        for (String word : wordCounter.keySet()) {
            WordReducer.append(outputfile, word, wordCounter);
        }

        System.out.println("Outputfile: ");
        System.out.println(outputfile);
        System.out.println();

        // After Map Reducing the Orders we want to only show what was ordered
        StringBuilder orderfile = new StringBuilder();

        // TODO 2.2 Make sure that only Dishes Related Information is added to the orderFile
        for (String word : wordCounter.keySet()) {
            switch (word) {
                case "Bread", "Curry", "IceCream", "Lassi", "Rice", "Salad", "Samosas", "Soup" -> {
                    WordReducer.append(orderfile, word, wordCounter);
                }
                default -> {
                }
            }
        }
        System.out.println("Orderfile: ");
        System.out.println(orderfile);

    }
}

// TODO 2.3 Run the main Method, the output should be following:
    /*
    Outputfile:
    Aniruddh - 9
    ordered - 9
    Salad - 2
    Curry - 2
    IceCream - 2
    Bread - 1
    Lassi - 1
    Rice - 1


    Orderfile:
    Salad - 2
    Curry - 2
    IceCream - 2
    Bread - 1
    Lassi - 1
    Rice - 1
     */
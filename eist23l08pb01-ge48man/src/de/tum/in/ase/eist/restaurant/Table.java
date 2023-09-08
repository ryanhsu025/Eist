package de.tum.in.ase.eist.restaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {

    static boolean areCandlesLighted = false;
    static double waterLevel = 0.4;
    public final static List<String> daysMenu = List.of("soup", "curry", "samosas");

    static String currentTableRepresentation =   "|||||||\n" +
                                                        "|  *  |\n" +
                                                        "|'   '|\n" +
                                                        "|    *|\n" +
                                                        "| &   |\n" +
                                                        "|||||||" ;

    public final static String cleanTableRepresentation = "|||||||\n" +
                                                    "|     |\n" +
                                                    "|     |\n" +
                                                    "|     |\n" +
                                                    "|     |\n" +
                                                    "|||||||" ;

    final static Map<String, Integer> flowersOnTable = new HashMap<>();

    public static void addFlowers(String flowerType, Integer number) {
        flowersOnTable.put(flowerType, number);
    }

    public static void cleanTable() {
        currentTableRepresentation = cleanTableRepresentation;
    }

    public static void lightCandles() {
        areCandlesLighted = true;
    }

    public static void fillWater() {
        waterLevel = 1.0;
    }

    public static void drinkWater(double drankWater) {
        waterLevel = Math.max(0, waterLevel - drankWater);
    }

    public static String readDaysMenu() {
        return "Today's specials include: Aniruddhs mystery " + daysMenu.get(0) + ", delicious " + daysMenu.get(1) +
                ", and world class " + daysMenu.get(2) + ".";
    }

    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("DM_DEFAULT_ENCODING")
    public static void singSong() {
                try {
                    FileReader fileReader = new FileReader("src/de/tum/in/ase/eist/restaurant/Music.txt");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println(line);
                    }
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

    }

    public static String askForFurtherRequests() {
        return "Dear Sir/Madam hope you are enjoying your evening and food. Is there anything else that I can get for you?";
    }

}

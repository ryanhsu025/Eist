package de.tum.in.eist;

import net.datafaker.Faker;

public class HelloFake {
    public static void main(String[] args) {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        System.out.println(returnHello(firstName));
    }

    static String returnHello(String name) {
        return "Hello " + name + "!";
    }
}

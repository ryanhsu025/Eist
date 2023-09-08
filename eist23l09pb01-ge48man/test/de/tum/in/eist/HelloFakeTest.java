package de.tum.in.eist;

import org.junit.jupiter.api.Test;

import static de.tum.in.eist.HelloFake.returnHello;
import static org.junit.jupiter.api.Assertions.*;

class HelloFakeTest {
    @Test
    void shouldPrintHelloCorrectly() {
        String firstName = "World";
        String expected = "Hello World!";

        String actual = returnHello(firstName);

        assertEquals(expected, actual);
    }

}
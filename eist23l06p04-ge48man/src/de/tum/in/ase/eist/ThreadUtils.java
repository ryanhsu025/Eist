package de.tum.in.ase.eist;

public class ThreadUtils {
    // An artificial sleep for when the swimmer needs some time to perform an operation (required to actually observer deadlocks)
    public static void takeSomeTime() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException("A thread threw an error when trying to sleep: " + e);
        }
    }
}

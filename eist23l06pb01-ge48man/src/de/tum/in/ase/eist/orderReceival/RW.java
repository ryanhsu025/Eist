package de.tum.in.ase.eist.orderReceival;

public class RW {
    private int countCustomersOrdering = 0;

    // TODO 1.2 Add Synchronized to the methods
    public synchronized void startRead() throws InterruptedException {
        while (countCustomersOrdering < 0)
            wait();
        countCustomersOrdering++;
    }

    public synchronized void endRead() {
        countCustomersOrdering--;
        if (countCustomersOrdering == 0)
            notify();
    }

    public synchronized void startWrite() throws InterruptedException {
        while (countCustomersOrdering != 0)
            wait();
        countCustomersOrdering = -1;
    }

    public synchronized void endWrite() {
        countCustomersOrdering = 0;
        notifyAll();
    }
}

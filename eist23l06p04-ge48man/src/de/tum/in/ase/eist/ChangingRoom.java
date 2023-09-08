package de.tum.in.ase.eist;

import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

import static de.tum.in.ase.eist.ThreadUtils.takeSomeTime;

public class ChangingRoom {
    private static int counter = 0;
    private final int id;
    private Optional<Swimmer> occupant;
    private final ReentrantLock mutex;

    public ChangingRoom() {
        this.id = counter++;
        this.occupant = Optional.empty();
        this.mutex = new ReentrantLock();
    }

    public void acquireKey(Swimmer newOccupant) {
        // TODO 1
        mutex.lock();
        occupant=Optional.of(newOccupant);
        takeSomeTime(); // take some time to change in changing room
        System.out.printf("Swimmer %d has has acquired the key to the changing room %d\n", newOccupant.getId(), this.id);
    }

    public void releaseKey() {
        System.out.printf("Swimmer %d has has released the key to the changing room %d\n", this.occupant.get().getId(), this.id);
        occupant=Optional.empty();
        mutex.unlock();
        // TODO 1
    }

    public Optional<Swimmer> getOccupant() {
        return occupant;
    }

    public ReentrantLock getMutex() {
        return mutex;
    }
}

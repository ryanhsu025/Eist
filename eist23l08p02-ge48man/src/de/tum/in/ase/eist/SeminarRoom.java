package de.tum.in.ase.eist;

import java.util.concurrent.Semaphore;

public class SeminarRoom implements Room {
    private Student[] places;
    private int in;
    private int out;
    private int occupancy;
    private Semaphore free;
    private Semaphore occupied;
    public SeminarRoom(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Seminar room must contain positive number of places!");
        }
        this.places = new Student[capacity];
        this.in = 0;
        this.out = 0;
        this.occupancy = 0;
        this.free = new Semaphore(capacity);
        this.occupied = new Semaphore(0);
    }
    public synchronized int getOccupancy() {
        return occupancy;
    }
    public void enter(Student student) throws InterruptedException {
        free.acquire();
        synchronized (this) {
            places[in++] = student;
            in %= places.length;
            occupancy++;
        }
        occupied.release();
    }
    public Student leave() throws InterruptedException {
        occupied.acquire();
        Student student;
        synchronized (this) {
            student = places[out++];
            out %= places.length;
            occupancy--;
        }
        free.release();
        return student;
    }
}

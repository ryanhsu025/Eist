package de.tum.in.ase.eist;

public interface Room {
    void enter(Student student) throws InterruptedException;
    Student leave() throws InterruptedException;
}

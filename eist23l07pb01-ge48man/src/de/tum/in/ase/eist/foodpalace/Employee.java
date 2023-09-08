package de.tum.in.ase.eist.foodpalace;

public class Employee {
    public Employee(String name, boolean isQualified) {
        this.name = name;
        this.isQualified = isQualified;
    }

    private String name;

    public String getName() {
        return name;
    }

    public boolean isQualified() {
        return isQualified;
    }

    private boolean isQualified;

}

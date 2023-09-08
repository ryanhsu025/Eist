package eist23;

import java.util.List;

public class Planet {

    private String name;
    private List<String> laws;
    private double bankBalance;
    private int population;
    private boolean inhabitable;

    public Planet(String name, List<String> laws, double bankBalance, int population, boolean inhabitable) {
        this.name = name;
        this.laws = laws;
        this.bankBalance = bankBalance;
        this.population = population;
        this.inhabitable = inhabitable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLaws() {
        return laws;
    }

    public void setLaws(List<String> laws) {
        this.laws = laws;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isInhabitable() {
        return inhabitable;
    }

    public void setInhabitable(boolean inhabitable) {
        this.inhabitable = inhabitable;
    }
}

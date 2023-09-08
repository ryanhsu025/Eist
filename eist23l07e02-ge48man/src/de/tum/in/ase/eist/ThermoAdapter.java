package de.tum.in.ase.eist;

public class ThermoAdapter implements ThermoInterface {
    private FahrenheitThermo thermo;
    public ThermoAdapter() {
        this.thermo = new FahrenheitThermo();
    }
    @Override
    public double getTempC() {
        double tempF = thermo.getFahrenheitTemperature();
        return (tempF - 32.0) * 5.0 / 9.0;
    }
}

package de.tum.in.ase.eist.push;

public final class WeatherMainView implements Observer {

    private final WeatherController controller;
    private final WeatherModel model;
    private int temperature;

    public WeatherMainView(WeatherController controller, WeatherModel model) {
        this.controller = controller;
        this.model = model;
        model.addObserver(this);
        // TODO: subscribe this view to the updates from model
    }

    public void display() {
        // TODO come up with a funny message
        System.out.printf("The temperature at main view now is %d.\n", temperature);
    }

    public void update(final int temperature) {
        // TODO: implement update state function
        this.temperature = temperature;
    }
}

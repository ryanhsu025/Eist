package eist23;

public class FoodPalace {
    private SaladBar saladBar;
    private Curry curry;
    private IceCreamStand iceCreamStand;

    /*
    TODO 1: Implement FoodPlace as shown in the UML diagram with the respective 
    attributes and methods. Do not forget the constructor and the getter-methods
    */


    public FoodPalace(SaladBar saladBar, Curry curry, IceCreamStand iceCreamStand) {
        this.saladBar = saladBar;
        this.curry = curry;
        this.iceCreamStand = iceCreamStand;
    }

    public void makeSalad() {
        saladBar.makeSalad();
    }

    public void makeCurry() {
        curry.makeCurry();
    }

    public void makeIceCream() {
        iceCreamStand.makeIceCream();
    }

    public SaladBar getSaladBar() {
        return saladBar;
    }

    public Curry getCurry() {
        return curry;
    }

    public IceCreamStand getIceCreamStand() {
        return iceCreamStand;
    }
}

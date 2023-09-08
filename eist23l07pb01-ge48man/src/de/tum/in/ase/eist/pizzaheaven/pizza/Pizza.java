package de.tum.in.ase.eist.pizzaheaven.pizza;

public abstract class Pizza {
    String name;
    boolean isBoxed;

    public void prepare() {
        System.out.println("Preparing " + name);
    }

    public void bake() {
        System.out.println("Baking " + name);
    }

    public void box(boolean isTakeaway) {
        if (isTakeaway) {
            this.isBoxed = true;
            System.out.println("Boxing " + name);
        }
    }

    public boolean isBoxed() {
        return isBoxed;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pizza pizza = (Pizza) o;
        return name == pizza.name;
    }
}
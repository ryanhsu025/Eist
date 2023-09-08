package eist23;
import org.json.JSONObject;

import java.util.Arrays;

public class ShopManager {
    private final String name = "Aniruddh";

    private final int id = 1;

    private FoodPalace foodPalace;


    // TODO 2 Implement as described in the UML diagram and the problem statement.

    public ShopManager() {
        this.foodPalace = new FoodPalace(new SaladBar(), new Curry(), new IceCreamStand());
    }

    public void testSalad() {
        foodPalace.makeSalad();
    }

    public void testCurry() {
        foodPalace.makeCurry();
    }

    public void testIceCream() {
        foodPalace.makeIceCream();
    }

    public static void main(String[] args) {
        // TODO 3 Uncomment the first part and test your implementation

        ShopManager shopManager = new ShopManager();
        shopManager.testSalad();
        shopManager.testCurry();
        shopManager.testIceCream();


        JSONObject jsonObject = new JSONObject(shopManager);
        jsonObject.put("name", shopManager.name);
        jsonObject.put("id", shopManager.id);
        // TODO 4 Add the id attribute to the jsonObject.
        jsonObject.put("foodPalace", Arrays.asList(shopManager.foodPalace.getSaladBar().getName(),shopManager.foodPalace.getCurry().getName(),shopManager.foodPalace.getIceCreamStand().getName()));
        System.out.println(jsonObject);
    }

}

package ohrman.max;

public class Main {

    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger("Soft", "BeefSoGood", 100);

        //The following lines are tests
        hamburger.addIngredient("lettuce");
        System.out.println("Current price = " + hamburger.getPrice());

        System.out.println("");

        hamburger.getBurger();

        Hamburger healthyBurger = new HealthyBurger("Vegan", 110);
        System.out.println("");
        healthyBurger.addIngredient("avocado");
        healthyBurger.addIngredient("avocado");
        healthyBurger.addIngredient("meat");
        healthyBurger.addIngredient("onion");
        healthyBurger.addIngredient("tomato");
        healthyBurger.addIngredient("tomato");
        healthyBurger.addIngredient("lettuce");
        System.out.println(healthyBurger.getPrice());
        System.out.println("");

        healthyBurger.getBurger();

        System.out.println("");
        Hamburger deluxeBurger = new DeluxeHamburger(130);
        deluxeBurger.addIngredient("fanta");
        deluxeBurger.addIngredient("coke");
        deluxeBurger.addIngredient("chips");
        System.out.println("");

        deluxeBurger.getBurger();

    }

}

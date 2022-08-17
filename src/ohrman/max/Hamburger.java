package ohrman.max;

public class Hamburger {
    private String rollType;
    private String meat;
    private int price;
    //List of prices for additions
    private int lettucePrice = 5;
    private int tomatoPrice = 12;
    private int onionPrice = 6;
    private int meatPrice = 25;
    //How many are added?
    private int lettuce = 0;
    private int tomato = 0;
    private int onion = 0;
    private int extraMeat = 0;

    public Hamburger(String rollType, String meat, int basePrice) {
        this.rollType = rollType;
        this.meat = meat;
        this.price = basePrice;
    }

    public void removeIngredient(String ingredient) {
        boolean isNull = false;
        switch (ingredient.toLowerCase()) {
            case "lettuce":
                if (lettuce == 0) {
                    isNull = true;
                    break;
                }
                lettuce -= 1;
                this.price -= lettucePrice;
                break;
            case "tomato":
                if (tomato == 0) {
                    isNull = true;
                    break;
                }
                tomato -= 1;
                this.price -= tomatoPrice;
                break;
            case "onion":
                if (onion == 0) {
                    isNull = true;
                    break;
                }
                onion -= 1;
                this.price -= onionPrice;
                break;
            case "meat":
                if (extraMeat == 0) {
                    isNull = true;
                    break;
                }
                extraMeat -= 1;
                this.price -= meatPrice;
                break;
            default:
                System.out.println("Invalid ingredient");
                break;
        }
        if (isNull) {
            System.out.println("Cannot remove " + ingredient.toLowerCase() + ". There is none added.");
        } else {
            System.out.println("Removed " + ingredient.toLowerCase() + ".");
        }
    }

    public void addIngredient(String ingredient) {
        switch (ingredient.toLowerCase()) {
            case "lettuce":
                lettuce += 1;
                this.price += lettucePrice;
                break;
            case "tomato":
                tomato += 1;
                this.price += tomatoPrice;
                break;
            case "onion":
                onion += 1;
                this.price += onionPrice;
                break;
            case "meat":
                extraMeat += 1;
                this.price += meatPrice;
                break;
            default:
                System.out.println("Invalid ingredient");
                break;
        }
        System.out.println("Added " + ingredient + ".");
    }

    public void setRollType(String rollType) {
        this.rollType = rollType;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public int getPrice() {
        //Calculate additions
        return this.price;
    }

    public void setPrice(int price) {
        this.price += price;
    }

    public void getBurger() {
        System.out.println("Your burger consists of " + rollType + " bread with the beef" + meat);
        System.out.println("The total price of your order is " + getPrice() + " :-");
        if (lettuce > 0 || tomato > 0 || onion > 0 || extraMeat > 0) {
            System.out.println(":::::Extras:::::");
            if (lettuce > 0) {
                System.out.println(lettuce + " Lettuce" + " (" + lettucePrice * lettuce + ":-)");
            }
            if (tomato > 0) {
                System.out.println(tomato + " Tomato" + " (" + tomatoPrice * tomato + ":-)");
            }
            if (onion > 0) {
                System.out.println(onion + " Onion" + " (" + onionPrice * onion + ":-)");
            }
            if (extraMeat > 0) {
                System.out.println(extraMeat + " extra meat" + " (" + meatPrice * extraMeat + ":-)");
            }
        }
    }
}

class HealthyBurger extends Hamburger {
    private int avocadoPrice = 18;
    private int cucumberPrice = 7;

    private int avocado = 0;
    private int cucumber = 0;

    public HealthyBurger(String meat, int basePrice) {
        super("brown rye bread roll", meat, basePrice);
    }

    @Override
    public void addIngredient(String ingredient) {
        switch (ingredient.toLowerCase()) {
            case "avocado":
                setPrice(avocadoPrice);
                avocado += 1;
                System.out.println("Added " + ingredient + ".");
                break;
            case "cucumber":
                setPrice(cucumberPrice);
                cucumber += 1;
                System.out.println("Added " + ingredient + ".");
                break;
            default:
                super.addIngredient(ingredient);
                break;
        }
    }

    @Override
    public void removeIngredient(String ingredient) {
        boolean isNull = false;

        switch (ingredient.toLowerCase()) {
            case "avocado":
                if (avocado == 0) {
                    isNull = true;
                    break;
                }
                setPrice(-avocadoPrice);
                avocado -= 1;
                System.out.println("Removed " + ingredient + ".");
                break;
            case "cucumber":
                if (cucumber == 0) {
                    isNull = true;
                    break;
                }
                setPrice(-cucumberPrice);
                cucumber -= 1;
                System.out.println("Removed " + ingredient + ".");
                break;
            default:
                super.removeIngredient(ingredient);
                break;
        }

        if (isNull) {
            System.out.println("Cannot remove " + ingredient.toLowerCase() + ". There is none added.");
        }
    }

    @Override
    public void getBurger() {
        super.getBurger();
        if (avocado > 0) {
            System.out.println(avocado + " Avocado" + " (" + avocadoPrice * avocado + ":-)");
        }
        if (cucumber > 0) {
            System.out.println(cucumber + " Cucumber" + " (" + cucumberPrice * cucumber + ":-)");
        }
    }
}

class DeluxeHamburger extends Hamburger {
    private int chipsPrice = 16;
    private int drinksPrice = 25;

    private int chips;
    private int drinks;

    public DeluxeHamburger(int basePrice) {
        super("soft Bun", "Elk Meat", basePrice);
    }

    @Override
    public void addIngredient(String ingredient) {
        switch (ingredient.toLowerCase()) {
            case "chips":
                chips += 1;
                setPrice(chipsPrice);
                System.out.println("Added " + ingredient.toLowerCase());
                break;
            case "coke":
            case "sprite":
            case "fanta":
                drinks += 1;
                System.out.println("Added " + ingredient.toLowerCase());
                setPrice(drinksPrice);
                break;
            default:
                System.out.println("Invalid ingredient: " + ingredient.toLowerCase());
                break;
        }
    }

    @Override
    public void removeIngredient(String ingredient) {
        boolean isNull = false;

        switch (ingredient.toLowerCase()) {
            case "chips":
                if (chips == 0) {
                    isNull = true;
                    break;
                }
                chips -= 1;
                setPrice(chipsPrice);
                System.out.println("Removed " + ingredient.toLowerCase());
                break;
            case "coke":
            case "sprite":
            case "fanta":
                if (drinks == 0) {
                    isNull = true;
                    break;
                }
                drinks -= 1;
                System.out.println("Removed " + ingredient.toLowerCase());
                setPrice(-drinksPrice);
                break;
            default:
                System.out.println("Invalid ingredient: " + ingredient.toLowerCase());
                break;
        }

        if (isNull) {
            System.out.println("Cannot remove " + ingredient.toLowerCase() + ". There is none added.");
        }
    }

    @Override
    public void getBurger() {
        super.getBurger();
        if (chips > 0 || drinks > 0) {
            System.out.println(":::::Extras:::::");
        }
        if (chips > 0) {
            System.out.println(chips + " Chips" + " (" + chipsPrice * chips + ":-)");
        }
        if (drinks > 0) {
            System.out.println(drinks + " Drinks" + " (" + drinksPrice * drinks + ":-)");
        }
    }
}

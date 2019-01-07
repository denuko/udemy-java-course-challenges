package com.denuko;

public class DeluxeBurger extends Hamburger {

    public DeluxeBurger(String breadRollType, String meat, double price) {
        super("Deluxe Burger", breadRollType, meat, price);

        setChips(new Chips(2.5));
        setDrink(new Drink(3));
    }

    @Override
    protected boolean checkAddAddition(Addition addition) {
        boolean addAddition = false;
        if (addition.getClass().getSimpleName().equals("Chips") && getChips() == null || addition.getClass().getSimpleName().equals("Drink") && getDrink() == null) {
            addAddition = super.checkAddAddition(addition);
        } else {
            System.out.println("Attempt to add extra addition to Deluxe Burger.");
        }

        return addAddition;
    }
}

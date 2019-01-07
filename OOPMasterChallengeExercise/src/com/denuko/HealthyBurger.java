package com.denuko;

public class HealthyBurger extends Hamburger{

    public HealthyBurger(String meat, double price) {
        super("Healthy Burger", "brown", meat, price);
        setAdditionsLimit(6);
    }
}

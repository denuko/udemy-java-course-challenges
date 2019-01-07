package com.denuko;

public class Main {

    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger("Basic Burger", "white", "ham", 6.0);
        hamburger.setTomato(new Tomato(1.0));
        hamburger.setTomato(new Tomato(1.0));
        hamburger.setCarrot(new Carrot(1.0));
        hamburger.setLettuce(new Lettuce(1.0));
        hamburger.setChips(new Chips(1.0));
        hamburger.setDrink(new Drink(2.0));
        hamburger.showPrices();

        HealthyBurger healthyBurger = new HealthyBurger( "turkey", 8.0);
        healthyBurger.setTomato(new Tomato(1.0));
        healthyBurger.setTomato(new Tomato(1.0));
        healthyBurger.setCarrot(new Carrot(1.0));
        healthyBurger.setLettuce(new Lettuce(1.0));
        healthyBurger.setMushroom(new Mushroom(3.0));
        healthyBurger.setDrink(new Drink(2.0));
        healthyBurger.showPrices();

        DeluxeBurger deluxeBurger = new DeluxeBurger("white", "ham", 10.0);
        deluxeBurger.setTomato(new Tomato(1.0));
        deluxeBurger.showPrices();
    }
}

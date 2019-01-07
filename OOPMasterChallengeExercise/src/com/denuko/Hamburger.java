package com.denuko;

public class Hamburger {

    private String name;
    private String breadRollType;
    private String meat;
    private double price;
    private int additionsLimit;
    private Tomato tomato;
    private Lettuce lettuce;
    private Carrot carrot;
    private Mushroom mushroom;
    private Chips chips;
    private Drink drink;

    public Hamburger(String name, String breadRollType, String meat, double price) {
        System.out.println("\nCreate burger of type " + getClass().getSimpleName() + ".");

        this.name = name;
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.price = price;
        this.additionsLimit = 4;
    }

    public Chips getChips() {
        return chips;
    }

    public Drink getDrink() {
        return drink;
    }

    protected void setAdditionsLimit(int additionsLimit) {
        this.additionsLimit = additionsLimit;
    }

    public void setTomato(Tomato tomato) {
        if (checkAddAddition(tomato)) {
            this.tomato = tomato;
        }
    }

    public void setLettuce(Lettuce lettuce) {
        if (checkAddAddition(lettuce)) {
            this.lettuce = lettuce;
        }
    }

    public void setCarrot(Carrot carrot) {
        if (checkAddAddition(carrot)) {
            this.carrot = carrot;
        }
    }

    public void setMushroom(Mushroom mushroom) {
        if (checkAddAddition(mushroom)) {
            this.mushroom = mushroom;
        }
    }

    public void setChips(Chips chips) {
        if (checkAddAddition(chips)) {
            this.chips = chips;
        }
    }

    public void setDrink(Drink drink) {
        if (checkAddAddition(drink)) {
            this.drink = drink;
        }
    }

    private boolean checkAdditionsLimit(String additionType) {
        boolean limitReached = false;

        if (this.additionsLimit == 0) {
            limitReached = true;
            System.out.println("Cannot add " + additionType + ". Additions limit reached.");
        }

        return limitReached;
    }

    protected boolean checkAddAddition(Addition addition) {
        String additionType = addition.getClass().getSimpleName();

        boolean addAddition = !checkAdditionsLimit(additionType);

        if (addAddition) {
            boolean additionExists = true;

            switch (additionType.toLowerCase()) {
                case "tomato":
                    if (this.tomato == null) {
                        additionExists = false;
                    }
                    break;
                case "lettuce":
                    if (this.lettuce == null) {
                        additionExists = false;
                    }
                    break;
                case "carrot":
                    if (this.carrot == null) {
                        additionExists = false;
                    }
                    break;
                case "mushroom":
                    if (this.mushroom == null) {
                        additionExists = false;
                    }
                    break;
                case "chips":
                    if (this.chips == null) {
                        additionExists = false;
                    }
                    break;
                case "drink":
                    if (this.drink == null) {
                        additionExists = false;
                    }
                    break;
            }

            if (additionExists) {
                addAddition = false;
                System.out.println(additionType + " already added.");
            } else {
                this.additionsLimit--;
            }
        }

        return addAddition;
    }

    public void showPrices() {
        double additionsPrice = showAdditionsPrices();

        System.out.println("Base price: €" + this.price);
        System.out.println("Additions total price: €" + additionsPrice);
        System.out.println("Total price: €" + (this.price + additionsPrice));
    }

    private double showAdditionsPrices() {
        double additionsPrice = 0.0;
        System.out.println("\nAdditions:");
        String additionsString = "";

        if (this.tomato != null) {
            additionsPrice += this.tomato.getPrice();

            additionsString += this.tomato.getAdditionNameAndPriceString();
        }

        if (this.lettuce != null) {
            additionsPrice += this.lettuce.getPrice();

            additionsString += this.lettuce.getAdditionNameAndPriceString();
        }

        if (this.carrot != null) {
            additionsPrice += this.carrot.getPrice();

            additionsString += this.carrot.getAdditionNameAndPriceString();
        }

        if (this.mushroom != null) {
            additionsPrice += this.mushroom.getPrice();

            additionsString += this.mushroom.getAdditionNameAndPriceString();
        }

        if (this.chips != null) {
            additionsPrice += this.chips.getPrice();

            additionsString += this.chips.getAdditionNameAndPriceString();
        }

        if (this.drink != null) {
            additionsPrice += this.drink.getPrice();

            additionsString += this.drink.getAdditionNameAndPriceString();
        }

        if (additionsString != "") {
            System.out.println(additionsString);
        } else {
            System.out.println("No additions added.\n");
        }

        return additionsPrice;
    }

}

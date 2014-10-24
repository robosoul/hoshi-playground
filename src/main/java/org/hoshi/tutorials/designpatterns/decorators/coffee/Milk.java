package org.hoshi.tutorials.designpatterns.decorators.coffee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Luka Obradovic (luka@vast.com)
 */
public class Milk extends CoffeeDecorator {
    public static final Logger log = LoggerFactory.getLogger(Milk.class);

    public Milk(final Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + INGREDIENT_SEPARATOR + "Milk";
    }
}

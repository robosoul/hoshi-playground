package org.hoshi.tutorials.designpatterns.decorators.coffee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Luka Obradovic (luka@vast.com)
 */
public class Cream extends CoffeeDecorator {
    public static final Logger log = LoggerFactory.getLogger(Cream.class);

    public Cream(final Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.7;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + INGREDIENT_SEPARATOR + "Cream";
    }
}

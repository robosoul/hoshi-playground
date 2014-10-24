package org.hoshi.tutorials.designpatterns.decorators.coffee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Luka Obradovic (luka@vast.com)
 */
public class Sprinkles extends CoffeeDecorator {
    public static final Logger log = LoggerFactory.getLogger(Sprinkles.class);

    public Sprinkles(final Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.2;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + INGREDIENT_SEPARATOR + "Sprinkles";
    }
}

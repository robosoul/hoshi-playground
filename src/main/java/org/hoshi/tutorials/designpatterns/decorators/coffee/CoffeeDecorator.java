package org.hoshi.tutorials.designpatterns.decorators.coffee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract decorator class - note that it extends Coffee abstract class.
 *
 * @author Luka Obradovic (luka@vast.com)
 */
public abstract class CoffeeDecorator extends Coffee {
    public static final Logger log = LoggerFactory.getLogger(CoffeeDecorator.class);

    protected static final String INGREDIENT_SEPARATOR = ", ";

    private final Coffee coffee;

    public CoffeeDecorator(final Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public String getIngredients() {
        return coffee.getIngredients();
    }
}

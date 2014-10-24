package org.hoshi.tutorials.designpatterns.decorators.coffee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Luka Obradovic (luka@vast.com)
 */
public class SimpleCoffee extends Coffee {
    public static final Logger log = LoggerFactory.getLogger(SimpleCoffee.class);

    @Override
    public double getCost() {
        return 1;
    }

    @Override
    public String getIngredients() {
        return "Coffee";
    }
}

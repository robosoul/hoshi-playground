package org.hoshi.tutorials.designpatterns.decorators.coffee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Luka Obradovic (luka@vast.com)
 */
public abstract class Coffee {
    public static final Logger log = LoggerFactory.getLogger(SimpleCoffee.class);

    public abstract double getCost();
    public abstract String getIngredients();
}

/**
 * Copyright Vast 2014. All Rights Reserved.
 *
 * http://www.vast.com
 */
package org.hoshi.tutorials.designpatterns.decorators.number;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Luka Obradovic (luka@vast.com)
 */
public abstract class NumberDecorator extends AbstractNumber {
    public static final Logger log = LoggerFactory.getLogger(NumberDecorator.class);

    private final AbstractNumber number;

    public NumberDecorator(final AbstractNumber number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number.getNumber();
    }
}

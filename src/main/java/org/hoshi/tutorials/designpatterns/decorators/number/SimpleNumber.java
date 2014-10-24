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
public class SimpleNumber extends AbstractNumber {
    public static final Logger log = LoggerFactory.getLogger(SimpleNumber.class);

    private final int number;

    public SimpleNumber(final int n) {
        number = n;
    }

    @Override
    public int getNumber() {
        return number;
    }
}

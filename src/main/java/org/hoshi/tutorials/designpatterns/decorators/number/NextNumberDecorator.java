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
public class NextNumberDecorator extends NumberDecorator {
    public static final Logger log = LoggerFactory.getLogger(NextNumberDecorator.class);

    public NextNumberDecorator(final AbstractNumber number) {
        super(number);
    }

    @Override
    public int getNumber() {
        return super.getNumber() + 1;
    }
}

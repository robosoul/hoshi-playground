package org.hoshi.tutorials.designpatterns.decorators.number;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Luka Obradovic (luka@vast.com)
 */
public abstract class AbstractNumber {
    public static final Logger log = LoggerFactory.getLogger(AbstractNumber.class);

    public abstract int getNumber();
}

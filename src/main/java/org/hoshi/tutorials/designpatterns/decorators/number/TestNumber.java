package org.hoshi.tutorials.designpatterns.decorators.number;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Create decorator for printing numbers from 1 to 10.
 * @author Luka Obradovic (luka@vast.com)
 */
public class TestNumber {
    public static final Logger log = LoggerFactory.getLogger(TestNumber.class);

    public static void main(String[] args) {
        AbstractNumber number = new SimpleNumber(0);

        for (int i = 0; i < 9; ++i) {
            number = new NextNumberDecorator(number);
            System.out.println(number.getNumber());
        }
    }
}

package org.hoshi.tutorials.designpatterns.decorators.room;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Advantages of Decorator Design Pattern
 *     - It is flexible than inheritance because inheritance adds responsibility
 *       at compile time but decorator pattern adds at run time.
 *     - We can have any number of decorators and also in any order.
 *     - It extends functionality of object without affecting any other object.
 *
 * Disadvantage of Decorator Design Pattern
 *     - The main disadvantage of decorator design pattern is code maintainability
 *       because this pattern creates lots of similar decorators which are sometimes
 *       hard to maintain and distinguish.
 *
 * @author Luka Obradovic (luka@vast.com)
 */
public class TestRoom {
    public static final Logger log = LoggerFactory.getLogger(TestRoom.class);

    public static void main(String[] args) {
        final Room room = new CurtainDecorator(new ColorDecorator(new SimpleRoom(), "Green"));
        System.out.println(room.showRoom());
    }
}

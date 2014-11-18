/**
 * The MIT License (MIT)
 *
 * Copyright (C) 2014 Luka Obradovic.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public class TestRoom {
    public static final Logger log = LoggerFactory.getLogger(TestRoom.class);

    public static void main(String[] args) {
        final Room room = new CurtainDecorator(new ColorDecorator(new SimpleRoom(), "Green"));
        System.out.println(room.showRoom());
    }
}

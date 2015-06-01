/**
 * The MIT License (MIT)
 *
 * Copyright (C) 2015 Luka Obradovic.
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
package org.hoshi.playground.designpatterns.singleton;

/**
 * From wikipedia:
 * In the second edition of his book Effective Java, Joshua Bloch claims that
 * "a single-element enum type is the best way to implement a singleton" for any
 * Java that supports enums. The use of an enum is very easy to implement and
 * has no drawbacks regarding serializable objects, which have to be
 * circumvented in the other ways.
 *
 * The public method can be written to take any desired types of arguments; a
 * single String argument is used here as an example.
 *
 * This approach implements the singleton by taking advantage of Java's
 * guarantee that any enum value is instantiated only once in a Java program.
 * Since Java enum values are globally accessible, so is the singleton,
 * initialized lazily by the class loader. The drawback is that the enum type
 * is somewhat inflexible.
 *
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public enum EnumSingleton {
    INSTANCE;

    public void doSomething(final String name) {
        System.out.println("Hello " + name);
    }
}

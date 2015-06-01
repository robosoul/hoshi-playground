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
 * If the program will always need an instance, or if the cost of creating the
 * instance is not too large in terms of time/resources, eager initialization
 * pattern can be used, which always creates an instance.
 *
 * Several advantages:
 *   - The static initializer is run when the class is initialized, after class
 *     loading but before the class is used by any thread.
 *   - There is no need to synchronize the getInstance() method, meaning all
 *     threads will see the same instance and no (expensive) locking is required.
 *   - The final keyword means that the instance cannot be redefined, ensuring
 *     that one (and only one) instance ever exists.
 *
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public final class EagerInitializationSingleton {
    private static final EagerInitializationSingleton INSTANCE =
            new EagerInitializationSingleton();

    private EagerInitializationSingleton() {

    }

    public static EagerInitializationSingleton getInstance() {
        return INSTANCE;
    }

    public void doSomething(final String name) {
        System.out.println("Hello " + name);
    }
}
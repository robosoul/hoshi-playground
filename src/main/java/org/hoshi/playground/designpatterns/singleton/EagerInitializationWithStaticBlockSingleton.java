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
 * Same as 'EagerInitializationSingleton' example, but some pre-processing is
 * allowed, eg error handling.
 *
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public final class EagerInitializationWithStaticBlockSingleton {
    private static final EagerInitializationWithStaticBlockSingleton INSTANCE;

    static {
        try {
            INSTANCE = new EagerInitializationWithStaticBlockSingleton();
        } catch (Exception ex) {
            throw new RuntimeException("Failed creating singleton.", ex);
        }
    }

    private EagerInitializationWithStaticBlockSingleton() {

    }

    public static EagerInitializationWithStaticBlockSingleton getInstance() {
        return INSTANCE;
    }

    public void doSomething(final String name) {
        System.out.println("Hello " + name);
    }
}
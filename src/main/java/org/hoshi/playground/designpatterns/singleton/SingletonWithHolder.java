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
 * University of Maryland Computer Science researcher Bill Pugh has written
 * about the code issues underlying the Singleton pattern when implemented in
 * Java. Pugh's efforts on the "Double-checked locking" idiom led to changes in
 * the Java memory model in Java 5 and to what is generally regarded as the
 * standard method to implement Singletons in Java. The technique known as the
 * initialization-on-demand holder idiom is as lazy as possible, and works in
 * all known versions of Java. It takes advantage of language guarantees about
 * class initialization, and will therefore work correctly in all Java-compliant
 * compilers and virtual machines.
 *
 * The nested class is referenced no earlier (and therefore loaded no earlier by
 * the class loader) than the moment that getInstance() is called. Thus, this
 * solution is thread-safe without requiring special language constructs
 * (i.e. volatile or synchronized).
 *
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public final class SingletonWithHolder {
    private static final class SINGLETON_HOLDER {
        private static final SingletonWithHolder INSTANCE = new SingletonWithHolder();
    }

    private SingletonWithHolder() {

    }

    public static SingletonWithHolder getInstance() {
        return SINGLETON_HOLDER.INSTANCE;
    }

    public void doSomething(final String name) {
        System.out.println("Hello " + name);
    }
}

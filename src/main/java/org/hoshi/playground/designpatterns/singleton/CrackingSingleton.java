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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Here described are the ways for cracking singleton.
 *
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public class CrackingSingleton {
    /**
     * The same class could be loaded by two different class loaders, as such,
     * two instances of singleton class can be created by simply invoking
     * getInstance() method in a class loaded by two different class loaders.
     *
     * This approach would work without having to resort to violating the
     * private constructor.
     */
    public static void classLoader()
    throws MalformedURLException,
    ClassNotFoundException,
    NoSuchMethodException,
    InvocationTargetException,
    IllegalAccessException {
        final URL jar = new URL("file:libs/singleton.jar");

        // create two different class loaders for the same jar
        final ClassLoader cl1 = new URLClassLoader(new URL[] {jar}, null);
        final ClassLoader cl2 = new URLClassLoader(new URL[] {jar}, null);

        // load same class from different class loaders
        final Class<?> singletonClass1 =
                cl1.loadClass("org.hoshi.playground.designpatterns.singleton.ClassicSingleton");

        final Class<?> singletonClass2 =
                cl2.loadClass("org.hoshi.playground.designpatterns.singleton.ClassicSingleton");

        // create two different instances of getInstance() method
        final Method getInstance1 =
                singletonClass1.getDeclaredMethod("getInstance");

        final Method getInstance2 =
                singletonClass2.getDeclaredMethod("getInstance");

        // call getInstance() method to create two instances of singleton class
        final Object singleton1 = getInstance1.invoke(null);
        final Object singleton2 = getInstance2.invoke(null);

        System.out.println("Are singleton1 and singleton2 equal? " + (singleton1 == singleton2));
        System.out.println("singleton1.hashCode() = " + singleton1.hashCode());
        System.out.println("singleton2.hashCode() = " + singleton2.hashCode());
        System.out.println("singleton1.toString() = " + singleton1.toString());
        System.out.println("singleton2.toString() = " + singleton2.toString());
    }

    /**
     * Using reflection we can retrieve private default constructor, set it to
     * visible, and call it more than once.
     */
    public static void reflection()
    throws ClassNotFoundException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        // retrieve Class of our singleton class
        final Class<?> singletonClass =
                Class.forName("org.hoshi.playground.designpatterns.singleton.SingletonWithHolder");

        // retrieve private Constructor of our singleton class
        final Constructor<?> constructor =
                singletonClass.getDeclaredConstructors()[0];

        // since the constructor is private, we need to change visibility
        constructor.setAccessible(true);

        // create first instance
        final Object singleton1 = constructor.newInstance(new Object[] {null});

        // create second instance
        final Object singleton2 = constructor.newInstance(new Object[] {null});

        System.out.println("Are singleton1 and singleton2 equal? " + (singleton1 == singleton2));
        System.out.println("singleton1.hashCode() = " + singleton1.hashCode());
        System.out.println("singleton2.hashCode() = " + singleton2.hashCode());
        System.out.println("singleton1.toString() = " + singleton1.toString());
        System.out.println("singleton2.toString() = " + singleton2.toString());
    }

    public static void main(final String[] args)
    throws ClassNotFoundException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException,
            MalformedURLException,
            NoSuchMethodException {

        System.out.println("Cracking with reflection...");
        reflection();

        System.out.println("Cracking with two class loaders...");
        classLoader();
    }
}
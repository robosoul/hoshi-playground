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
package org.hoshi.playground.threads.joins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public class ThreeCountingThreadsJoinApp {
    public static final Logger log =
            LoggerFactory.getLogger(ThreeCountingThreadsJoinApp.class);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main: 0");

        final Thread t1 = new Thread(new Counter(1, 5));
        final Thread t2 = new Thread(new Counter(6, 10));
        final Thread t3 = new Thread(new Counter(11, 14));

        // count from 1 to 5
        t1.start();
        t1.join();

        // count from 6 to 10 only when we already counted from 1 to 5
        t2.start();
        t2.join();

        // count from 11 to 14 only when we already counted from 1 to 10
        t3.start();
        t3.join();

        System.out.println("main: 15");
    }
}
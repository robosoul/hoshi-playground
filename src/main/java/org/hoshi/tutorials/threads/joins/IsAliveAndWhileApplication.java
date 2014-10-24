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
package org.hoshi.tutorials.threads.joins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates joining threads using while + isAlive() + sleep()
 *
 * @author Luka Obradovic (luka@vast.com)
 */
public class IsAliveAndWhileApplication {
    public static final Logger log = LoggerFactory.getLogger(
            IsAliveAndWhileApplication.class);

    public static void main(String[] args) {
        System.out.println("main: 0");

        final Thread counter = new Thread(new Counter(1, 9));
        counter.start();

        // without following code we could end up with: 0,10,1,2,3,4,5,6,7,8,9
        // here we ENSURE that counter thread finishes before main continues
        while (counter.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // nothing to do
            }
        }

        System.out.println("main: 10");
    }
}

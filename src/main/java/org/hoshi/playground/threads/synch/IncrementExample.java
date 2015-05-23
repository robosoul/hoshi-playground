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
package org.hoshi.playground.threads.synch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public class IncrementExample {
    public static final Logger log =
            LoggerFactory.getLogger(IncrementExample.class);

    public static void main(String[] args) {
        final Count c = new BadCount(0);
        //final Count c = new ThreadSafeCount(0);

        // create thread with starting value
        final Thread inc1 = new Thread(new IncrementingWorker(c));
        final Thread inc2 = new Thread(new IncrementingWorker(c));

        // let's roll!
        inc1.start();
        inc2.start();

        // wait to finish and check results
        try {
            inc1.join();
            inc2.join();
        } catch (InterruptedException e) {
            log.error("Failed joining!", e);
        }

        // number should be 2 x 10000
        System.out.println("And the count is = " + c);

    }

    private interface Count {
        void increment();
    }

    private static class BadCount implements Count {
        private int count;

        BadCount(final int value) {
            this.count = value;
        }

        @Override
        public void increment() {
            // NOT ATOMIC!
            //
            // count = count + 1 (3 operations):
            //  1) get 'count'
            //  2) add 1 to it's value
            //  3) assign new value back to 'count'
            //
            // one thread might increment 'count' value 1 or 2 times before
            // storing it back to it, so other thread(s) get un-incremented value
            count++;
        }

        @Override
        public String toString() {
            return count + "";
        }
    }

    private static class ThreadSafeCount implements Count {
        private int count;

        ThreadSafeCount(final int value) {
            this.count = value;
        }

        @Override
        public synchronized void increment() {
            count++;
        }

        @Override
        public String toString() {
            return count + "";
        }
    }

    private static class IncrementingWorker implements Runnable {
        private Count count;

        public IncrementingWorker(final Count count) {
            this.count = count;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; ++i) {
                count.increment();
            }
        }
    }
}

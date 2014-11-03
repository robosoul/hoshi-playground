/**
 * Copyright Vast 2014. All Rights Reserved.
 *
 * http://www.vast.com
 */
package org.hoshi.tutorials.threads.synch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Luka Obradovic (luka@vast.com)
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

    private static interface Count {
        public void increment();
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

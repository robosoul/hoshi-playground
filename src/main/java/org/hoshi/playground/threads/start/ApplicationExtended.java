/**
 * Copyright Vast 2014. All Rights Reserved.
 *
 * http://www.vast.com
 */
package org.hoshi.playground.threads.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates running new threads extending Thread class.
 *
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public class ApplicationExtended {
    public static final Logger log =
            LoggerFactory.getLogger(ApplicationExtended.class);

    public static void main(String[] args) {
        final Thread t1 = new ExtendedRunner();
        final Thread t2 = new ExtendedRunner();

        t1.start();
        t2.start();
    }

    private static class ExtendedRunner extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello: " + i + " Thread: " + this.getName());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

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

/**
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public class Counter implements Runnable {
    private final int start;
    private final int end;

    public Counter(final int start, final int end) {
        this.start = start;
        this.end   = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; ++i) {
            System.out.println("cntr: " + i);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // nothing to do
            }
        }
    }
}
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
package org.hoshi.playground.numbers;

/**
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public final class Fibonacci {
    private Fibonacci() {
        // a utility class
    }

    public static int iterative(final int n) {
        if (n < 0) {
            return -1; // invalid input
        }

        if (n == 0) {
            return 0;
        }

        int a = 1; // first
        int b = 1; // second
        for (int i = 3; i <= n; i++) {
            int c = a + b;

            a = b;
            b = c;
        }

        return b;
    }

    public static int recursive(final int n) {
        if (n < 0) {
            return -1; // invalid input
        }

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return recursive(n - 1) + recursive(n - 2);
    }

    public static void main(final String[] args) {
        final int n = 5;

        System.out.printf("First %d Fibonacci number(s): ", n + 1);
        for (int i = 0; i < n; i++) {
            System.out.printf("%d, ", iterative(i));
        }
        System.out.printf("%d", iterative(n));
    }
}
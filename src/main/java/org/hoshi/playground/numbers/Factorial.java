/**
 * The MIT License (MIT)
 * <p/>
 * Copyright (C) 2015 Luka Obradovic.
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p/>
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
public final class Factorial {
    private Factorial() {
        // utility class
    }

    public static long iterative(final int n) {
        long f = 1L;

        for (long i = 2; i <= n; i++) {
            f *= i;
        }

        return f;
    }

    public static long recursive(final int n) {
        if (n < 2) {
            return 1;
        }

        return n * recursive(n - 1);
    }

    public static void main(final String[] args) {
        System.out.println(Factorial.recursive(10));
    }
}
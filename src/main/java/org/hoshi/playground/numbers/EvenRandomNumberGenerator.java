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
package org.hoshi.playground.numbers;

import java.util.Random;

/**
 * Even numbers generator.
 *
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public final class EvenRandomNumberGenerator {
    private EvenRandomNumberGenerator() {
        // utility class
    }

    // our random number generator
    private static final Random RNG = new Random();

    /**
     * random & -2 (11111111 11111111 11111111 11111110 )resets '1' on the first position
     *
     * @return random even number
     */
    public static int nextEvenWithBitMask(final int n) {
        return RNG.nextInt(n) & -2;
    }

    public static int nextEvenWithShiftLeft(final int n) {
        return RNG.nextInt(n) << 1;
    }

    public static int nextEvenWithMultiplicationBy2(final int n) {
        return RNG.nextInt(n) * 2;
    }

    public static int nextEvenWithLoop(final int n) {
        int m = RNG.nextInt(n);

        while (n % 2 != 0) {
            m = RNG.nextInt(n);
        }

        return m;
    }

    public static void main(String[] args) {
        final int n = 100;

        for (int i = 1; i <= 10; ++i) {
            System.out.println(EvenRandomNumberGenerator.nextEvenWithBitMask(n));
        }
    }
}

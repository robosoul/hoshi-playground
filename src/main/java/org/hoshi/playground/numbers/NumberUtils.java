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
public final class NumberUtils {
    private static final int FIRST_BIT_MASK = 1;

    private NumberUtils() {
        // utility class
    }

    /**
     * Returns a string representation of the integer argument as an unsigned
     * integer in base 2. Returned string has all 32 digits including leading
     * zeros.
     *
     * @param number an integer to be converted to a string
     * @return the string representation of the unsigned integer value
     *         represented by the argument in binary (base 2)
     */
    public static String integerToBinaryString(int number) {
        String bin = "";

        for (int i = 1; i < Integer.SIZE; ++i) {
            if (i % 8 == 0) {
                bin = " " + (number & FIRST_BIT_MASK) + bin;
            } else {
                bin = (number & FIRST_BIT_MASK) + bin;
            }

            number = number >> 1;
        }

        bin = (number & FIRST_BIT_MASK) + bin;
        return bin;
    }
}
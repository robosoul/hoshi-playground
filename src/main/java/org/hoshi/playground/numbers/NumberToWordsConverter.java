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

import java.util.Random;

/**
 * Utility class for converting numeric values into an english representation.
 *
 * Some examples:
 *         1000 = 'one thousand'
 *         2015 = 'two thousand fifteen'
 *        11000 = 'eleven thousand'
 *    511450768 = 'five hundred eleven million four hundred fifty thousand seven hundred sixty eight'
 *
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public final class NumberToWordsConverter {
    private NumberToWordsConverter() {
        // utility class
    }

    public static final String[] UNITS = {
            "",             // 0
            "one",          // 1
            "two",          // 2
            "three",        // 3
            "four",         // 4
            "five",         // 5
            "six",          // 6
            "seven",        // 7
            "eight",        // 8
            "nine",         // 9
            "ten",          // 10
            "eleven",       // 11
            "twelve",       // 12
            "thirteen",     // 13
            "fourteen",     // 14
            "fifteen",      // 15
            "sixteen",      // 16
            "seventeen",    // 17
            "eighteen",     // 18
            "nineteen"      // 19
    };

    public static final String[] TENS = {
            "",        // 0
            "",        // 1
            "twenty",  // 2
            "thirty",  // 3
            "forty",   // 4
            "fifty",   // 5
            "sixty",   // 6
            "seventy", // 7
            "eighty",  // 8
            "ninety"   // 9
    };

    public static String convert(final int n) {
        if (n < 0) {
            return "minus " + convert(-n);
        }

        if (n < 20) {
            return UNITS[n];
        }

        if (n < 100) {
            return TENS[n / 10] + ((n % 10 != 0) ? " " : "") + UNITS[n % 10];
        }

        if (n < 1000) {
            return UNITS[n / 100] + " hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
        }

        if (n < 1000000) {
            return convert(n / 1000) + " thousand" + ((n % 1000 != 0) ? " " : "") + convert(n % 1000);
        }

        if (n < 1000000000) {
            return convert(n / 1000000) + " million" + ((n % 1000000 != 0) ? " " : "") + convert(n % 1000000);
        }

        return convert(n / 1000000000) + " billion"  + ((n % 1000000000 != 0) ? " " : "") + convert(n % 1000000000);
    }

    public static void main(final String[] args) {
        final Random generator = new Random();

        int n;
        for (int i = 0; i < 20; i++) {
            n = generator.nextInt(Integer.MAX_VALUE);

            System.out.printf("%10d = '%s'%n", n, convert(n));
        }

        n = 1000;
        System.out.printf("%10d = '%s'%n", n, convert(n));

        n = 2015;
        System.out.printf("%10d = '%s'%n", n, convert(n));

        n = 10000;
        System.out.printf("%10d = '%s'%n", n, convert(n));

        n = 11000;
        System.out.printf("%10d = '%s'%n", n, convert(n));

        n = 999999999;
        System.out.printf("%10d = '%s'%n", n, convert(n));

        n = Integer.MAX_VALUE;
        System.out.printf("%10d = '%s'%n", n, convert(n));
    }
}
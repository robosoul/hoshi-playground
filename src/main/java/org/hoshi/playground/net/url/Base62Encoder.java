/**
 * Copyright (C) 2014 Luka Obradovic.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.hoshi.playground.net.url;

/**
 * Theoretical background
 *  You need a Bijective Function f. This is necessary so that you can find a
 *  inverse function g('abc') = 123 for your f(123) = 'abc' function. This means:
 *
 *  There must be no x1, x2 (with x1 ≠ x2) that will make f(x1) = f(x2),
 *  and for every y you must be able to find an x so that f(x) = y.
 *
 * How to convert the ID to a shortened URL?
 *  Think of an alphabet we want to use. In your case that's [a-zA-Z0-9]. It
 *  contains 62 letters.
 *
 *  Take an auto-generated, unique numerical key (the auto-incremented id of a
 *  MySQL table for example).
 *
 *  For this example I will use 19158(10) (19158 with a base of 10). Now you
 *  have to convert 19158(10) to X(62) (base 62):
 *
 *   19158(10) = 4×62^2 + 61×62^1 + 0×62^0 = [4,61,0]
 *
 *  This requires use of integer division and modulo. A pseudo-code example:
 *   digits = []
 *
 *   while num > 0
 *    remainder = modulo(num, 62)
 *    digits.push(remainder)
 *    num = divide(num, 62)
 *
 *   digits = digits.reverse
 *
 *  Now map the indices 2 and 1 to your alphabet. This is how your mapping (with
 *  an array for example) could look like:
 *   0  → a
 *   1  → b
 *   ...
 *   25 → z
 *   ...
 *   52 → 0
 *   61 → 9
 *
 *  With 2 → c and 1 → b you will receive cb(62) as the shortened URL:
 *  http://shor.ty/cb
 *
 * How to resolve a shortened URL to the initial ID?
 *  The reverse is even easier. You just do a reverse lookup in your alphabet.
 *
 *  e9a(62) will be resolved to "4th, 61st, and 0th letter in alphabet".
 *  e9a(62) = [4,61,0] = 4×62^2 + 61×62^1 + 0×62^0 = 19158(10)
 *
 * Now find your database-record with WHERE id = 19158 and do the redirect.
 *
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public class Base62Encoder {
    protected static final String ALPHABET_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    protected static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    protected static final int BASE = ALPHABET.length;

    public static String encode(long num) {
        String res = "";

        if (num == 0) {
            return res + ALPHABET[0];
        }

        while (num > 0) {
            res = ALPHABET[(int) num % BASE] + res;
            num = num / BASE;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(encode(0));
        System.out.println(encode(125));
        System.out.println(encode(19158));
    }
}

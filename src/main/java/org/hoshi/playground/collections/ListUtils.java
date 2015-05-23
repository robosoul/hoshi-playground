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
package org.hoshi.playground.collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public final class ListUtils {
    public static final Logger log = LoggerFactory.getLogger(ListUtils.class);

    private ListUtils() {
        // utility class
    }

    /**
     * Returns true if {@code list} has duplicates.
     *
     * @param list a list to be tested
     * @return true if {@code list} has duplicates.
     */
    public static <T> boolean hasDupes(final List<T> list) {
        final Set<T> set = new HashSet<>();

        for (T t : list) {
            if (!set.add(t)) {
                return true;
            }
        }

        return true;
    }

    /**
     * Removes duplicated elements. Maintains order of elements.
     *
     * @param list a list to be purged :)
     */
    public static <T> void dedupe(final List<T> list) {
        final Set<T> set = new LinkedHashSet<>(list);

        list.clear();
        list.addAll(set);
    }
}
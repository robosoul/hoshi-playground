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
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.hoshi.playground.text.autocomplete;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public class NavigableSetAutocomplete implements Autocomplete {
    public static final Logger log =
            LoggerFactory.getLogger(NavigableSetAutocomplete.class);

    private final NavigableSet<String> set;

    public NavigableSetAutocomplete() {
        this(new TreeSet<String>());
    }

    public NavigableSetAutocomplete(final NavigableSet<String> set) {
        this.set = set;
    }

    @Override
    public void load(final String word, final int weight) {
        this.set.add(word);
    }

    @Override
    public boolean match(final String prefix) {
        final Set<String> tailSet = set.tailSet(prefix);

        for (String tail : tailSet) {
            if (tail.startsWith(prefix)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<String> find(final String prefix) {
        final List<String> completions = new ArrayList<>();

        final Set<String> tailSet = set.tailSet(prefix);
        for (String tail : tailSet) {
            if (tail.startsWith(prefix)) {
                completions.add(tail);
            }
        }

        return completions;
    }

    public static void main(String[] args) {
        final Autocomplete completer = new NavigableSetAutocomplete();

        completer.load("california", 100);
        completer.load("columbus", 98);
        completer.load("catalina", 76);
        completer.load("cosmos", 92);
        completer.load("cpsmos", 10);
        completer.load("canye", 30);

        System.out.println(completer.find("co"));
    }

}

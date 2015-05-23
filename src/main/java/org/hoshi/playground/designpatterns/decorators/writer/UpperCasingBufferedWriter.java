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
package org.hoshi.playground.designpatterns.decorators.writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public class UpperCasingBufferedWriter extends BufferedWriter {
    public static final Logger log = LoggerFactory.getLogger(
            UpperCasingBufferedWriter.class);

    public UpperCasingBufferedWriter(final Writer out) {
        super(out);
    }

    public UpperCasingBufferedWriter(final Writer out, final int sz) {
        super(out, sz);
    }

    @Override
    public void write(final String s, final int off, final int len)
    throws IOException {
        if (s != null) {
            super.write(s.toUpperCase(), off, len);
        } else {
            super.write(s, off, len);
        }
    }

    /// TEST ///
    public static void main(String[] args) {
        final String[] test = {"fOo", "bar", "Green Ham", "home", "woRld", "heLLo", "teSt"};

        try (BufferedWriter out = new UpperCasingBufferedWriter(new OutputStreamWriter(System.out))) {
            for (String s : test) {
                out.write(s);
                out.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

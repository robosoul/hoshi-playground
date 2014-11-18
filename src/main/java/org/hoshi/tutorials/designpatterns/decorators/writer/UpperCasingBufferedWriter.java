/**
 * Copyright Vast 2014. All Rights Reserved.
 *
 * http://www.vast.com
 */
package org.hoshi.tutorials.designpatterns.decorators.writer;

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

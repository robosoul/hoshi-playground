/***
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
package org.hoshi.playground.net.sockets.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Set;

/**
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public class ChatHandler implements Runnable{
    public static final Logger log = LoggerFactory.getLogger(ChatHandler.class);

    private String name;
    private Socket socket;

    private final Set<String> names;
    private final Set<PrintWriter> writers;

    public ChatHandler(
            final Socket socket,
            final Set<String> names,
            final Set<PrintWriter> writers) {
        this.name = name;
        this.socket = socket;
        this.names = names;
        this.writers = writers;
    }

    @Override
    public void run() {
        BufferedReader in;
        PrintWriter out = null;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                out.println("SUBMIT:NAME");
                name = in.readLine();
                if (name == null) {
                    return;
                }

                synchronized (names) {
                    if (!names.contains(name)) {
                        names.add(name);
                        break;
                    }
                }
            }

            out.println("NAME:ACCEPTED");
            writers.add(out);


            // Accept messages from this client and broadcast them.
            // Ignore other clients that cannot be broadcast to.
            while (true) {
                String input = in.readLine();
                if (input == null) {
                    return;
                }
                for (PrintWriter writer : writers) {
                    writer.println(name + ": " + input);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // This client is going down! Remove its name and its print
            // writer from the sets, and close its socket.
            if (name != null) {
                names.remove(name);
            }

            if (out != null) {
                writers.remove(out);
            }

            try {
                socket.close();
            } catch (IOException e) {

            }
        }
    }
}

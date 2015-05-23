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
package org.hoshi.playground.net.sockets.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public class ChatServer {
    public static final Logger log = LoggerFactory.getLogger(ChatServer.class);

    private final int port;

    private final Set<String> users;

    private final Set<PrintWriter> writers;

    public ChatServer(final int port) {
        this.port = port;

        this.users = new HashSet<String>();
        this.writers = new HashSet<PrintWriter>();
    }

    public Set<String> getUsers() {
        return users;
    }

    public Set<PrintWriter> getWriters() {
        return writers;
    }

    public void start() throws IOException {
        log.info("Starting chat server on port {}...", port);
        ServerSocket server = new ServerSocket(port);

        try {
            while (true) {
                new Thread(new ChatHandler(server.accept(), users, writers)).start();
            }
        } finally {
            server.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new ChatServer(9001).start();
    }
}

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
package org.hoshi.playground.net.sockets;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public class CapitalizeServer {
    public static final Logger log =
            LoggerFactory.getLogger(CapitalizeServer.class);

    public static final int PORT_TO_LISTEN = 10007;

    private void start() throws IOException {
        int clientNumber = 0;

        final ServerSocket listener = new ServerSocket(PORT_TO_LISTEN);
        try {
            while (true) {
                new Thread(new Capitalizer(listener.accept(), clientNumber++)).start();
            }
        } finally {
           IOUtils.closeQuietly(listener);
        }
    }

    private static class Capitalizer implements Runnable {
        private final Socket socket;
        private final int clientNumber;

        public Capitalizer(final Socket client, final int clientNumber) {
            this.socket = client;
            this.clientNumber = clientNumber;
            log.debug("New connection with client# " + clientNumber + " at " + socket);
        }

        @Override
        public void run() {
            PrintWriter out = null;
            BufferedReader in = null;

            try {
                in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                out = new PrintWriter(socket.getOutputStream(), true);

                String line;
                while ((line = in.readLine()) != null) {
                    if (line.equals(".")) {
                        break;
                    }

                    out.println(line.toUpperCase());
                }
            } catch (IOException ioex) {
                log.error("Error handling client# " + clientNumber + ": " + ioex);
            } finally {
                IOUtils.closeQuietly(in);
                IOUtils.closeQuietly(out);
                IOUtils.closeQuietly(socket);
            }
        }
    }

    public static void main(String[] args) {
        try {
            new CapitalizeServer().start();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}

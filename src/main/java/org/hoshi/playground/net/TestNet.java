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
package org.hoshi.playground.net;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

/**
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public class TestNet {
    public static final Logger log = LoggerFactory.getLogger(TestNet.class);

    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket("localhost", 11111);
            socket.setSoTimeout(2000);
        } catch (IOException e) {
            System.err.println("Unable to connect to 'localhost:11111': " + e.getMessage());
            System.exit(1);
        }

        BufferedReader in = null;
        PrintWriter out = null;

        while (true) {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                out.println("luka");
                System.out.println(in.readLine());

                out.println("bazza");
                System.out.println(in.readLine());

                break;
            } catch (SocketException e) {
                System.err.println("Unable to connect to 'localhost:11111': " + e.getMessage() + ", retrying...");

                try {
                    socket.close();

                    socket = new Socket("localhost", 11111);
                    socket.setSoTimeout(2000);
                } catch (IOException ex) {
                    System.err.println("Unable to connect to 'localhost:11111': " + ex.getMessage());
                }
            } catch (IOException e) {
                System.err.println(
                        "Unable to connect to 'localhost:11111': " + e.getMessage());
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

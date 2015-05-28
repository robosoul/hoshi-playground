/**
 * The MIT License (MIT)
 *
 * Copyright (C) 2015 Luka Obradovic.
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
package org.hoshi.playground.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * 1. Create a .properties file in (most commonly) src/main/resources directory:
 *      hoshi-tutorials/src/main/resources/info.properties
 *
 * 2. Set the value of some property in your .properties file using the standard
 *    Maven property for project version:
 *      application.name=${project.name}
 *      application.version=${project.version}
 *
 * 3. Load the value from the properties file as a resource from the classpath:
 *      properties.load(App.class.getResourceAsStream("/info.properties"));
 *
 * 4. In Maven, enable resource filtering - this cause Maven to copy properties
 *    file into output classes and translate the resource during that copy,
 *    interpreting the property:
 *      <resource>
 *        <directory>src/main/resources</directory>
 *        <filtering>true</filtering>
 *      </resource>
 *
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
public class ApplicationInfoFromMaven {
    public static final Logger log =
            LoggerFactory.getLogger(ApplicationInfoFromMaven.class);

    public static void main(final String[] args) throws IOException {
        // load properties from jar
        final Properties properties = new Properties();
        properties.load(ApplicationInfoFromMaven.class.getResourceAsStream("/info.properties"));

        // read properties
        System.out.println("Application name:    " + properties.getProperty("application.name"));
        System.out.println("Application version: " + properties.getProperty("application.version"));
    }
}
/**
 * Copyright Vast 2014. All Rights Reserved.
 *
 * http://www.vast.com
 */
package org.hoshi.tutorials.designpatterns.decorators.room;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Luka Obradovic (luka@vast.com)
 */
public class SimpleRoom extends Room {
    public static final Logger log = LoggerFactory.getLogger(SimpleRoom.class);

    @Override
    public String showRoom() {
        return "Room";
    }
}

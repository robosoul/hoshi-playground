package org.hoshi.tutorials.designpatterns.decorators.room;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Luka Obradovic (luka@vast.com)
 */
public abstract class Room {
    public static final Logger log = LoggerFactory.getLogger(Room.class);

    public abstract String showRoom();
}

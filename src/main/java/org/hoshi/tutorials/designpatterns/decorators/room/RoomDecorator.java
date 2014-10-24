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
public abstract class RoomDecorator extends Room {
    public static final Logger log = LoggerFactory.getLogger(RoomDecorator.class);

    private final Room room;

    public RoomDecorator(final Room room) {
        this.room = room;
    }

    @Override
    public String showRoom() {
        return room.showRoom();
    }
}

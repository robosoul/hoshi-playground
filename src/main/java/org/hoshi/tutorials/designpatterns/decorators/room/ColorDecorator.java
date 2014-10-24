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
public class ColorDecorator extends RoomDecorator {
    public static final Logger log = LoggerFactory.getLogger(ColorDecorator.class);

    private final String color;

    public ColorDecorator(final Room room, final String color) {
        super(room);
        this.color = color;
    }

    @Override
    public String showRoom() {
        return super.showRoom() + addColor();
    }

    protected String addColor() {
        return " + " + color;
    }
}

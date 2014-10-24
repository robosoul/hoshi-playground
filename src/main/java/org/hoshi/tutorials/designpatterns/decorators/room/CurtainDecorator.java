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
public class CurtainDecorator extends RoomDecorator {
    public static final Logger log = LoggerFactory.getLogger(CurtainDecorator.class);

    public CurtainDecorator(final Room room) {
        super(room);
    }

    @Override
    public String showRoom() {
        return super.showRoom() + addCurtains();
    }

    protected String addCurtains() {
        return " + Red Curtains";
    }
}

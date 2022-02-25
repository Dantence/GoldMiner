package com.yyw;

import java.awt.*;

public class Clock extends Object {
    Clock(){
        this.setX((int) (Math.random() * 900 + 50));
        this.setY((int) (Math.random() * 350 + 350));
        this.setWidth(48);
        this.setHeight(48);
        this.setImage(Toolkit.getDefaultToolkit().getImage(Clock.class.getResource("/imgs/clock.png")));
        this.setState(0);
        this.setFactor(1.5);
        this.setValue(1);
        this.set_clock(true);
    }
}

package com.yyw;

import java.awt.*;

public class Box extends Object{
    Box(){
        this.setX((int) (Math.random() * 950));
        this.setY((int) (Math.random() * 110 + 600));
        this.setWidth(128);
        this.setHeight(128);
        this.setImage(Toolkit.getDefaultToolkit().getImage(Box.class.getResource("/imgs/box.png")));
        this.setState(0);
        this.setFactor(0.65);
        this.setValue(0);
        this.set_box(true);
    }
}

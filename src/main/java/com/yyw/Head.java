package com.yyw;

import java.awt.*;

public class Head extends Object{
    Head(){
        this.setX((int) (Math.random() * 920 + 20));
        this.setY((int) (Math.random() * 380 + 320));
        this.setWidth(64);
        this.setHeight(64);
        this.setImage(Toolkit.getDefaultToolkit().getImage(Head.class.getResource("/imgs/head.png")));
        this.setFactor(1.9);
        this.setValue(95);
    }
}

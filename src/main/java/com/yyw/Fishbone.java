package com.yyw;

import java.awt.*;

public class Fishbone extends Object {
    Fishbone(){
        this.setX((int) (Math.random() * 920 + 20));
        this.setY((int) (Math.random() * 400 + 220));
        this.setWidth(32);
        this.setHeight(32);
        this.setImage(Toolkit.getDefaultToolkit().getImage(Fishbone.class.getResource("/imgs/fishbone.png")));
        this.setFactor(2.7);
        this.setValue(19);
    }
}

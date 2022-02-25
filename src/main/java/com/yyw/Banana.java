package com.yyw;

import java.awt.*;

public class Banana extends Object{
    Banana(){
        this.setX((int) (Math.random() * 920 + 20));
        this.setY((int) (Math.random() * 400 + 220));
        this.setWidth(32);
        this.setHeight(32);
        this.setImage(Toolkit.getDefaultToolkit().getImage(Banana.class.getResource("/imgs/banana.png")));
        this.setFactor(2.7);
        this.setValue(6);
    }
}

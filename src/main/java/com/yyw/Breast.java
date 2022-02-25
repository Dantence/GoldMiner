package com.yyw;

import java.awt.*;

public class Breast extends Object {
    Breast(){
        this.setX((int) (Math.random() * 920 + 20));
        this.setY((int) (Math.random() * 400 + 220));
        this.setWidth(64);
        this.setHeight(64);
        this.setImage(Toolkit.getDefaultToolkit().getImage(Breast.class.getResource("/imgs/breast.png")));
        this.setFactor(1.1);
        this.setValue(27);
    }
}

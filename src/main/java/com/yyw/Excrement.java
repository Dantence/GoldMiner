package com.yyw;

import java.awt.*;

public class Excrement extends Object {
    Excrement(){
        this.setX((int) (Math.random() * 920 + 20));
        this.setY((int) (Math.random() * 500 + 220));
        this.setWidth(32);
        this.setHeight(32);
        this.setImage(Toolkit.getDefaultToolkit().getImage(Excrement.class.getResource("/imgs/excrement.png")));
        this.setFactor(2.7);
        this.setValue(12);
    }
}

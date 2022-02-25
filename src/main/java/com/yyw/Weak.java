package com.yyw;

import java.awt.*;

public class Weak extends Object{
    Weak(){
        this.setX((int) (Math.random() * 900 + 25));
        this.setY((int) (Math.random() * 500 + 210));
        this.setWidth(64);
        this.setHeight(64);
        this.setImage(Toolkit.getDefaultToolkit().getImage(Weak.class.getResource("/imgs/weak.png")));
        this.setState(0);
        this.setFactor(3.8);
        this.setValue(8);
        this.set_weak(true);
    }
}

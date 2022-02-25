package com.yyw;

import java.awt.*;

public class TNT extends Object{
    TNT(){
        this.setX((int) (Math.random() * 900 + 50));
        this.setY((int) (Math.random() * 500 + 230));
        this.setWidth(128);
        this.setHeight(128);
        this.setImage(Toolkit.getDefaultToolkit().getImage(TNT.class.getResource("/imgs/TNT.png")));
        this.setState(0);
        this.setFactor(1.5);
        this.setValue(1);
        this.set_TNT(true);
    }
}

package com.yyw;

import java.awt.*;

public class GoldGod extends Object{
    GoldGod(){
        this.setX((int) (Math.random() * 900 + 40));
        this.setY((int) (Math.random() * 350 + 350));
        this.setWidth(80);
        this.setHeight(80);
        this.setImage(Toolkit.getDefaultToolkit().getImage(GoldGod.class.getResource("/imgs/goldGod.png")));
        this.setState(0);
        this.setFactor(1.5);
        this.setValue(1);
        this.set_goldGod(true);
    }
}

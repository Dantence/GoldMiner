package com.yyw;

import java.awt.*;

public class BlackRock extends Object{
    BlackRock(){
        this.setX((int) (Math.random() * 700 + 120));
        this.setY((int) (Math.random() * 300 + 400));
        this.setWidth(155);
        this.setHeight(155);
        this.setImage(Toolkit.getDefaultToolkit().getImage(BlackRock.class.getResource("/imgs/blackRock.png")));
        this.setState(0);
        this.setFactor(0.9);
        this.setValue((int)(Math.random() * 500 + 2700));
        this.set_black(true);
    }
}

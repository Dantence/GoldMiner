package com.yyw;

import java.awt.*;

public class Magic extends Object {
    Magic(){
        this.setX((int) (Math.random() * 920 + 20));
        this.setY(675);
        this.setWidth(60);
        this.setHeight(60);
        this.setImage(Toolkit.getDefaultToolkit().getImage(Box.class.getResource("/imgs/magic.png")));
        this.setState(0);
        this.setFactor(0.58);
        this.setValue(0);
        this.set_magic(true);
    }
}

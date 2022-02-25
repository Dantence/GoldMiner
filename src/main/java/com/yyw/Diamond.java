package com.yyw;

import java.awt.*;

public class Diamond extends Object{
    Diamond(){
        this.setX((int) (Math.random() * 900 + 50));
        this.setY((int) (Math.random() * 200 + 500));
        this.setWidth(31);
        this.setHeight(24);
        this.setImage(Toolkit.getDefaultToolkit().getImage(Diamond.class.getResource("/imgs/diamond.png")));
        this.setState(0);
        this.setFactor(4);
        this.setValue(800);
        this.set_diamond(true);
    }
    Diamond(int x, int y, boolean is_right, int speed){
        this.setWidth(56);
        this.setHeight(56);
        this.setSpeed(speed);
        this.set_special(true);
        this.setStart(x);
        this.setX(x);
        this.setY(y);
        this.setWidth(31);
        this.setHeight(24);
        this.setImage(Toolkit.getDefaultToolkit().getImage(Diamond.class.getResource("/imgs/diamond.png")));
        this.setState(0);
        this.setFactor(4);
        this.setValue(810);
        this.set_right(is_right);
        this.set_diamond(true);
        this.setId(Utils.DiamondWormId);
    }
}

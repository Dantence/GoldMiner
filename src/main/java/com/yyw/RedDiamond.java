package com.yyw;

import java.awt.*;

public class RedDiamond extends Object{
    RedDiamond(){
        this.setX((int) (Math.random() * 900 + 50));
        this.setY((int) (Math.random() * 110 + 600));
        this.setWidth(50);
        this.setHeight(50);
        this.setImage(Toolkit.getDefaultToolkit().getImage(RedDiamond.class.getResource("/imgs/reddiamond.png")));
        this.setState(0);
        this.setFactor(2.3);
        this.setValue(1200);
        this.set_diamond(true);
    }
    RedDiamond(int x, int y, boolean is_right, int speed){
        this.setWidth(56);
        this.setHeight(56);
        this.setSpeed(speed);
        this.set_right(is_right);
        this.set_special(true);
        this.setStart(x);
        this.setX(x);
        this.setY(y);
        this.setWidth(50);
        this.setHeight(50);
        this.setImage(Toolkit.getDefaultToolkit().getImage(RedDiamond.class.getResource("/imgs/reddiamond.png")));
        this.setState(0);
        this.setFactor(2.3);
        this.setValue(1210);
        this.set_diamond(true);
        this.setId(Utils.DiamondWormId);
    }
}

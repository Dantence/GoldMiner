package com.yyw;

import java.awt.*;

public class EarthWorm extends Object{
    EarthWorm(){
        this.setX((int) (Math.random() * 900 + 30));
        this.setY((int) (Math.random() * 480 + 220));
        this.set_right(Math.random() > 0.5);
        this.setWidth(64);
        this.setHeight(64);
        this.setImage(Toolkit.getDefaultToolkit().getImage(EarthWorm.class.getResource("/imgs/earthworm.png")));
        this.setFactor(3.2);
        this.set_worm(true);
        this.setStart(getX());
        this.setValue(10);
    }
}

class DiamondWorm extends EarthWorm{
    DiamondWorm(){
        this.setHave_dia(true);
        this.setValue(810);
        this.setId(Utils.DiamondWormId);
    }
}

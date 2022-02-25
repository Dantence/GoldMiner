package com.yyw;

import com.yyw.Utils;

import java.awt.*;

public class Rock extends Object{
    Rock(){
        this.setX((int) (Math.random() * 900 + 50));
        this.setY((int) (Math.random() * 450 + 250));
        this.setWidth(36);
        this.setHeight(36);
        this.setImage(Toolkit.getDefaultToolkit().getImage(Rock.class.getResource("/imgs/rock1.png")));
        this.setState(0);
        this.setFactor(1.2);
        this.set_rock(true);
        this.setValue(11);
    }
}
class BigRock extends Rock{
    BigRock(){
        this.setY((int) (Math.random() * 400 + 300));
        this.setWidth(71);
        this.setHeight(71);
        this.setImage(Toolkit.getDefaultToolkit().getImage(BigRock.class.getResource("/imgs/rock2.png")));
        this.setFactor(1);
        this.setValue(38);
    }
}
class HugeRock extends Rock{
    HugeRock(){
        this.setY((int) (Math.random() * 350 + 350));
        this.setWidth(105);
        this.setHeight(105);
        this.setImage(Toolkit.getDefaultToolkit().getImage(HugeRock.class.getResource("/imgs/hugerock.png")));
        this.setFactor(0.8);
        this.setValue(60);
    }
}

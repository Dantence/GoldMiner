package com.yyw;

import com.yyw.Utils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.Objects;

public class Gold extends Object{
    Gold(){
        this.setX((int) (Math.random() * 900 + 50));
        this.setY((int) (Math.random() * 400 + 300));
        this.setWidth(72);
        this.setHeight(72);
        this.setImage(Toolkit.getDefaultToolkit().getImage(Gold.class.getResource("/imgs/gold2.gif")));
        this.setState(0);
        this.setFactor(1.5);
        this.setValue(200);
    }
}

class SmallGold extends Gold{
    SmallGold(){
        this.setY((int) (Math.random() * 400 + 230));
        this.setWidth(36);
        this.setHeight(36);
        this.setImage(Toolkit.getDefaultToolkit().getImage(SmallGold.class.getResource("/imgs/gold1.gif")));
        this.setFactor(2.5);
        this.setValue(100);
    }
}

class BigGold extends Gold{
    BigGold(){
        this.setY((int) (Math.random() * 300 + 400));
        this.setWidth(140);
        this.setHeight(140);
        this.setImage(Toolkit.getDefaultToolkit().getImage(BigGold.class.getResource("/imgs/gold3.gif")));
        this.setFactor(0.8);
        this.setValue(500);
    }
}



package com.yyw;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Buy {
    public int x;
    public int y;
    public int height = 64;
    public int width = 64;
    Buy(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Image image = Toolkit.getDefaultToolkit().getImage(Buy.class.getResource("/imgs/buy.png"));

    public Buy() {

    }
}

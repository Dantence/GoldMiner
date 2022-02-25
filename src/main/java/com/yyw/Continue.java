package com.yyw;

import java.awt.*;

public class Continue {
    public int x;
    public int y;
    public int height = 76;
    public int width = 256;
    Continue(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Image image = Toolkit.getDefaultToolkit().getImage(Continue.class.getResource("/imgs/continue.png"));
    public static boolean is_clicked = false;
}

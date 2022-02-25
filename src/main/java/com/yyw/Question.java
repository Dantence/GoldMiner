package com.yyw;

import java.awt.*;

public class Question extends Object{
    Question(){
        this.setX((int) (Math.random() * 950));
        this.setY((int) (Math.random() * 510 + 220));
        this.setWidth(64);
        this.setHeight(64);
        this.setImage(Toolkit.getDefaultToolkit().getImage(Question.class.getResource("/imgs/question.png")));
        this.setState(0);
        this.setFactor(2*Math.random() + 0.5);
        this.setValue(0);
        this.set_question(true);
    }
}

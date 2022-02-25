package com.yyw;

import com.yyw.Utils;
import lombok.Data;

import java.awt.*;
import java.io.UnsupportedEncodingException;

@Data
public class Line {
    private int x = 465;
    private int y = 183;
    public static int endx = 0;
    public static int endy = 0;

    public static double length = 50;
    public static double MIN_length = 50;
    public static double MAX_length = 720;
    public static double n = 0.05;
    private int dir = 1;
    //0摇摆 1抓取 2收回 3抓取返回
    public static int state;
    //爪子
    private Image hook = Toolkit.getDefaultToolkit().getImage(Line.class.getResource("/imgs/hook.png"));
    private Image hook2 = Toolkit.getDefaultToolkit().getImage(Line.class.getResource("/imgs/magnet.png"));
    private GameWindow frame;

    Line(GameWindow frame) {
        this.frame = frame;
    }

    public void collideLogic() throws UnsupportedEncodingException {

        if (state == 1) {
            for (int index0 = 0; index0 < this.frame.objectList.size(); index0++) {
                if (endx > this.frame.objectList.get(index0).getX() - Info.range && endx < this.frame.objectList.get(index0).getX() + this.frame.objectList.get(index0).getWidth() + Info.range
                        && endy > this.frame.objectList.get(index0).getY() - Info.range && endy < this.frame.objectList.get(index0).getY() + this.frame.objectList.get(index0).getHeight() + Info.range) {
                    this.frame.objectList.get(index0).setState(1);
                    state = 3;
                    if (this.frame.objectList.get(index0).is_TNT()) {
                        new Player("music/explosive.mp3").start();
                        for(int index = 0; index < this.frame.objectList.size(); index++) {
                            Rectangle rectanglge = new Rectangle(this.frame.objectList.get(index0).getX() - 86, this.frame.objectList.get(index0).getY() - 86, 300, 300);
                            if (rectanglge.intersects(this.frame.objectList.get(index).getRec()) && index!= index0) {
                                if (this.frame.objectList.get(index).is_TNT()) {
                                    new Player("music/explosive.mp3").start();
                                    for(int index2 = 0; index2 < this.frame.objectList.size(); index2++) {
                                        Rectangle rectanglge1 = new Rectangle(this.frame.objectList.get(index).getX() - 86, this.frame.objectList.get(index).getY() - 86, 300, 300);
                                        if (rectanglge1.intersects(this.frame.objectList.get(index2).getRec()) && index2 != index) {
                                            if (this.frame.objectList.get(index2).is_TNT()) {
                                                new Player("music/explosive.mp3").start();
                                                for(int index3 = 0; index3 < this.frame.objectList.size(); index3++) {
                                                    Rectangle rectanglge2 = new Rectangle(this.frame.objectList.get(index2).getX() - 86, this.frame.objectList.get(index2).getY() - 86, 300, 300);
                                                    if (rectanglge2.intersects(this.frame.objectList.get(index3).getRec()) && index3 != index2) {
                                                        this.frame.objectList.get(index3).setX(-200);
                                                        this.frame.objectList.get(index3).setY(-200);
                                                        Info.boomx = Line.endx;
                                                        Info.boomy = Line.endy;
                                                        this.frame.objectList.get(index3).setState(2);
                                                        Utils.should_show_small_boom = true;
                                                        state = 2;
                                                    }
                                                }
                                            } else if(this.frame.objectList.get(index2) instanceof DiamondWorm){
                                                for (Object oo : this.frame.objectList){
                                                    if(oo.is_special() && oo.getId() == this.frame.objectList.get(index2).getId()){
                                                        oo.setX(-200);
                                                        oo.setY(-200);
                                                        oo.setState(2);
                                                    }
                                                }
                                            }
                                            this.frame.objectList.get(index2).setX(-200);
                                            this.frame.objectList.get(index2).setY(-200);
                                            Info.boomx = Line.endx;
                                            Info.boomy = Line.endy;
                                            this.frame.objectList.get(index2).setState(2);
                                            Utils.should_show_small_boom = true;
                                            state = 2;
                                        }
                                    }
                                } else if(this.frame.objectList.get(index) instanceof DiamondWorm){
                                    for (Object oc : this.frame.objectList){
                                        if(oc.is_special() && oc.getId() == this.frame.objectList.get(index).getId()){
                                            oc.setX(-200);
                                            oc.setY(-200);
                                            oc.setState(2);
                                        }
                                    }
                                }

                                this.frame.objectList.get(index).setX(-200);
                                this.frame.objectList.get(index).setY(-200);
                                Info.boomx = Line.endx;
                                Info.boomy = Line.endy;
                                this.frame.objectList.get(index).setState(2);
                                Utils.should_show_small_boom = true;
                                state = 2;
                            }
                        }
                        this.frame.objectList.get(index0).setX(-200);
                        this.frame.objectList.get(index0).setY(-200);
                        Info.boomx = Line.endx;
                        Info.boomy = Line.endy;
                        this.frame.objectList.get(index0).setState(2);
                        Utils.should_show_small_boom = true;
                        state = 2;
                    } else if(this.frame.objectList.get(index0).is_clock()){
                        //延时
                        state = 2;
                        Info.extraTime = 10;
                        this.frame.objectList.get(index0).setX(-200);
                        this.frame.objectList.get(index0).setY(-200);
                        this.frame.objectList.get(index0).setState(2);
                    } else if (this.frame.objectList.get(index0).is_black() && !Info.is_magnet){
                        new Player("music/low-value.mp3").start();
                        state = 2;
                        this.frame.objectList.get(index0).setState(2);
                    } else if(this.frame.objectList.get(index0).is_goldGod()){
                        new Player("music/high-value.mp3").start();
                        state = 2;
                        this.frame.objectList.get(index0).setX(-200);
                        this.frame.objectList.get(index0).setY(-200);
                        this.frame.objectList.get(index0).setState(2);
                        double p = Math.random();
                        int num = 1;
                        if(p < 0.7) {
                            num++;
                        }
                        if(p < 0.3) {
                            num++;
                        }
                        for (int i = 0; i < num; i++) {
                            if(!Level.addObject(new Diamond(), this.frame.objectList)){
                                i--;
                            }
                        }
                    } else if (this.frame.objectList.get(index0) instanceof DiamondWorm) {
                        new Player("music/high-value.mp3").start();
                        for (Object o : this.frame.objectList) {
                            if (o.is_special() && this.frame.objectList.get(index0).getId() == o.getId()) {
                                o.setState(1);
                            }
                        }
                    } else if (this.frame.objectList.get(index0) instanceof Diamond || this.frame.objectList.get(index0) instanceof RedDiamond || this.frame.objectList.get(index0) instanceof BigGold || this.frame.objectList.get(index0) instanceof Box || this.frame.objectList.get(index0) instanceof BlackRock || this.frame.objectList.get(index0) instanceof Magic){
                        new Player("music/high-value.mp3").start();
                    } else if (this.frame.objectList.get(index0) instanceof Gold || this.frame.objectList.get(index0) instanceof SmallGold || this.frame.objectList.get(index0) instanceof Question || this.frame.objectList.get(index0) instanceof Head || this.frame.objectList.get(index0) instanceof Clock) {
                        new Player("music/normal-value.mp3").start();
                    } else {
                        new Player("music/low-value.mp3").start();
                    }

                }
            }
        }
    }

    private void DrawLine(Graphics g) {
        endx = (int) (x + length * Math.cos(n * Math.PI));
        endy = (int) (y + length * Math.sin(n * Math.PI));
        g.drawLine(x, y, endx, endy);
        g.drawLine(x - 1, y, endx - 1, endy);
        g.drawLine(x + 1, y, endx + 1, endy);
        if (Info.is_magnet) {
            g.drawImage(hook2, endx - 18, endy - 10, null);
        } else {
            g.drawImage(hook, endx - 18, endy - 2, null);
        }
    }

    public void paintSelf(Graphics g) throws UnsupportedEncodingException {
        collideLogic();
        switch (state) {
            case 0:
                Utils.should_show_small_boom = false;
                if (n < 0.05 || n > 0.95) {
                    dir *= -1;
                }
                n = n + 0.005 * dir - dir * 0.0004 * Info.dropSpeed;
                DrawLine(g);
                break;
            case 1:
                Info.is_powerful = false;
                Info.is_getboom = false;
                Utils.should_show = false;
                if (length < MAX_length) {
                    length = length + 10 - Info.dropSpeed;
                    DrawLine(g);
                } else {
                    state = 2;
                }
                break;
            case 2:
                if (length > MIN_length) {
                    length = length - 10 + Info.dropSpeed * 0.5;
                    DrawLine(g);
                } else {
                    state = 0;
                }
                break;
            case 3:
                Info.BakudanAllow = true;
                if (length > MIN_length) {
                    length = length - Utils.nowfactor - Info.power + Info.weak;
                    DrawLine(g);
                    for (Object obj : this.frame.objectList) {
                        if (obj.getState() == 1) {
                            Utils.nowfactor = obj.getFactor();
                            obj.setX(endx - obj.getWidth() / 2);
                            obj.setY(endy);

                            if (Info.BakudanFlag) {
                                obj.setX(-200);
                                obj.setY(-200);
                                obj.setState(2);
                                Utils.should_show = false;
                                Utils.nowfactor = 10;
                                Info.BakudanFlag = false;
                                state = 2;
                                Info.BakudanAllow = false;
                            }
                        }
                        if (obj.is_special() && obj.getState() == 1) {
                            obj.setX(endx - obj.getWidth() / 2 + 2);
                            obj.setY(endy + 2);
                        }
                    }
                }
                if (length <= MIN_length) {
                    for (Object obj1 : this.frame.objectList) {
                        if (obj1.getState() == 1) {
                            if (obj1.is_question()) {
                                double prob = Math.random();
                                if (prob > 0 && prob < 0.1) {
                                    //大力士
                                    new Player("music/high-value.mp3").start();
                                    Info.power += 7;
                                    Info.is_powerful = true;
                                } else if (prob > 0.1 && prob < 0.2) {
                                    //获得炸弹
                                    new Player("music/high-value.mp3").start();
                                    Info.BakudanNum++;
                                    Info.is_getboom = true;
                                } else if (prob > 0.2 && prob < 0.3) {
                                    obj1.setValue(2);
                                } else if (prob > 0.3 && prob < 0.4) {
                                    obj1.setValue(888);
                                } else {
                                    obj1.setValue((int) (Math.random() * 750 + 20));
                                }
                            } else if (obj1.is_diamond()) {
                                obj1.setValue(obj1.getValue() + Info.extraValue);
                            } else if (obj1.is_weak()) {
                                new Player("music/low-value.mp3").start();
                                Info.weak = 0.5;
                                Info.dropSpeed = 6;
                            } else if (obj1.is_rock()) {
                                obj1.setValue(obj1.getValue() * Utils.rock_times);
                            } else if (obj1 instanceof DiamondWorm) {
                                if (obj1.getType() == 0) {
                                    obj1.setValue(obj1.getValue() + Info.extraValue);
                                } else {
                                    obj1.setValue(obj1.getValue() + Info.extraValue + 400);
                                }
                                for (Object obj2 : this.frame.objectList) {
                                    if (obj2.is_special() && obj2.getId() == obj1.getId()) {
                                        obj2.setX(-200);
                                        obj2.setY(-200);
                                        obj2.setState(2);
                                    }
                                }
                            } else if (obj1.is_box()) {
                                double p = Math.random();
                                if (p > 0.15 && p < 1) {
                                    obj1.setValue((int) (Math.random() * 400 + 900));
                                }
                            } else if(obj1.is_magic()){
                                for(Object diamonObj : this.frame.objectList){
                                    if(diamonObj.is_diamond() && diamonObj.getState() != 2){
                                        obj1.setValue(obj1.getValue() + diamonObj.getValue());
                                        diamonObj.setX(-200);
                                        diamonObj.setY(-200);
                                        diamonObj.setState(2);
                                    }
                                }

                            }

                            obj1.setX(-200);
                            obj1.setY(-200);
                            obj1.setState(2);
                            Utils.nowfactor = 10;
                            Utils.should_show = true;
                            Info.Money += obj1.getValue();
                            Info.now_value = obj1.getValue();
                            Info.BakudanFlag = false;
                            state = 0;
                        }
                    }
                }
                break;

        }
    }
}


package com.yyw;

import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameWindow extends JFrame {
    Line line = new Line(this);
    BackGround backGround = new BackGround();
    List<Object> objectList = new ArrayList<>();
    Image offScreenImage;
    void launch() throws InterruptedException {
        objectList.clear();

        Level.GenerateLevel(Info.level, objectList);
        this.setVisible(true);
        this.setSize(960,740);
        this.setLocationRelativeTo(null);
        this.setTitle("黄金矿工 V1.1  By yyw");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMouseListener(new MouseAdapter() {
            @SneakyThrows
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Thread.sleep(2);
                switch (Info.GameState){
                    case 0:
                        if(e.getButton() == 3){
                            new Player("music/cut-scene.mp3").start();
                            Info.GameState = 1;
                            Info.startTime = System.currentTimeMillis();
                        }
                        break;
                    case 1:
                        if(e.getButton() == 1 && Line.state == 0){
                            Line.state = 1;
                        }
                        if(e.getButton() == 3 && Line.state == 3 && Info.BakudanAllow){
                            if(Info.BakudanNum >= 1){
                                new Player("music/explosive.mp3").start();
                                Info.BakudanAllow = false;
                                Info.BakudanNum--;
                                Info.BakudanFlag = true;
                                Info.boomx = Line.endx;
                                Info.boomy = Line.endy;
                                Utils.should_show_small_boom = true;
                            }
                        }
                        break;
                    case 2:
                        if(e.getButton() == 1) {
                            //炸弹
                            if(e.getX() >= 38 && e.getX() <= 102 && e.getY() >= 400 && e.getY() <= 464 && Info.is_sale[0]){
                                if(!Info.is_clicked[0]){
                                    Info.BakudanNum++;
                                    if(Info.Money >= Info.cost[0]){
                                        Info.Money -= Info.cost[0];
                                        Info.is_shopped[0] = true;
                                    }
                                    Info.is_clicked[0] = true;
                                }
                            //生力水
                            } else if (e.getX() >= 188 && e.getX() <= 252 && e.getY() >= 400 && e.getY() <= 464 && Info.is_sale[1]){
                                if(!Info.is_clicked[1]){
                                    if(Info.Money >= Info.cost[1]){
                                        Info.Money -= Info.cost[1];
                                        Info.is_shopped[1] = true;
                                        Info.power = 0.8;
                                    }
                                    Info.is_clicked[1] = true;
                                }
                                //钻石升值水
                            } else if (e.getX() >= 338 && e.getX() <= 402 && e.getY() >= 400 && e.getY() <= 464 && Info.is_sale[2]){
                                if(!Info.is_clicked[2]){
                                    if(Info.Money >= Info.cost[2]){
                                        Info.Money -= Info.cost[2];
                                        Info.is_shopped[2] = true;
                                        Info.extraValue = 400;
                                    }
                                    Info.is_clicked[2] = true;
                                }
                                //石头收藏书
                            } else if (e.getX() >= 550 && e.getX() <= 614 && e.getY() >= 400 && e.getY() <= 464 && Info.is_sale[3]){
                                if(!Info.is_clicked[3]){
                                    if(Info.Money >= Info.cost[3]){
                                        Info.Money -= Info.cost[3];
                                        Info.is_shopped[3] = true;
                                        Utils.rock_times = (int) (Math.random()*10 + 5);
                                    }
                                    Info.is_clicked[3] = true;
                                }
                                //磁铁
                            } else if (e.getX() >= 750 && e.getX() <= 814 && e.getY() >= 400 && e.getY() <= 464 && Info.is_sale[4]){
                                if(!Info.is_clicked[4]){
                                    if(Info.Money >= Info.cost[4]){
                                        Info.Money -= Info.cost[4];
                                        Info.is_shopped[4] = true;
                                        Info.range = 30;
                                        Info.is_magnet = true;
                                    }
                                    Info.is_clicked[4] = true;
                                }
                            }
                        }
                        if(e.getButton() == 3) {
                            //下一关
                            if(e.getX() >= 650 && e.getX() <= (650 + 256) && e.getY() >= 80 && e.getY() <= (80 + 76)) {
                                Continue.is_clicked = true;
                                Info.GameState = 1;
                                Info.startTime = System.currentTimeMillis();
                                Line.length = Line.MIN_length;
                                new Player("music/cut-scene.mp3").start();
                            }
                        }
                        break;
                    case 3:
                    case 4:
                        if(e.getButton() == 1){
                            Info.GameState = 0;
                            Utils.Resume();
                        }
                        break;

                }

            }
        });
        while (true){
            repaint();
            NextLevel();
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @SneakyThrows
    public void paint(Graphics g){
        offScreenImage = this.createImage(960, 740);
        Graphics gImage = offScreenImage.getGraphics();
        backGround.paintSelf(gImage);
        if(Info.GameState == 1){
            for(Object obj : objectList) {
                obj.paintSelf(gImage);
                if(obj.is_worm() || obj.is_special()){
                    if(obj.is_right()){
                        obj.setX(obj.getX() + obj.getSpeed());
                        if(obj.getX() > 960 + 100){
                            obj.set_right(false);
                        }
                    } else {
                        obj.setX(obj.getX() - obj.getSpeed());
                        if(obj.getX() < -100 ){
                            obj.set_right(true);
                        }
                    }

                }
            }
            line.paintSelf(gImage);
        }
        if(Utils.should_show){
            Utils.DrawValue(gImage, Info.now_value, Info.is_powerful, Info.is_getboom);
        }
        if(Utils.should_show_small_boom){
            Utils.DrawBoom(gImage, Info.boomx, Info.boomy, 1);
        }
        g.drawImage(offScreenImage, 0, 0, null);

    }

    public void NextLevel() throws InterruptedException {
        if(Utils.gameTime() && Info.GameState == 1){
            if(Info.Money >= Info.map.get(Info.level)){
                Info.level++;
                if(Info.level > Info.levelNum){
                    Info.GameState = 4;
                    Info.level = 1;
                } else {
                    //进入商店
                    Info.is_shopping = true;
                    //力量清零
                    Info.power = 0;
                    Info.extraTime = 0;
                    Info.extraValue = 0;
                    Info.weak = 0;
                    Info.dropSpeed = 0;
                    Info.range = 0;
                    Info.is_magnet = false;
                    for (int i = 0; i < Info.is_sale.length; i++) {
                        Info.is_sale[i] = Math.random() > 0.5;
                    }
                    Utils.rock_times = 1;
                    Continue.is_clicked = false;
                    Arrays.fill(Info.is_clicked, false);
                    Arrays.fill(Info.is_display, false);
                    Arrays.fill(Info.is_shopped, false);
                    Info.GameState = 2;
                }
                Utils.LevelUpdate();
            } else {
                Info.GameState = 3;
                Info.level = 1;
            }
            Utils.should_show = false;
            Info.gameWindow.launch();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Info.gameWindow = new GameWindow();
        Info.gameWindow.launch();
    }
}

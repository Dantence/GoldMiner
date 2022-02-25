package com.yyw;

import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class BackGround {
    private static final String ResourcePath = Utils.getResourcePath();
    private Image bg = Toolkit.getDefaultToolkit().getImage(BackGround.class.getResource("/imgs/bg1.jpg"));
    private Image bg2 = Toolkit.getDefaultToolkit().getImage(BackGround.class.getResource("/imgs/bg2.png"));
    private Image peo = Toolkit.getDefaultToolkit().getImage(BackGround.class.getResource("/imgs/peo.jpg"));
    private Image bakudan = Toolkit.getDefaultToolkit().getImage(BackGround.class.getResource("/imgs/bakudan.jpg"));
    private Image power = Toolkit.getDefaultToolkit().getImage(BackGround.class.getResource("/imgs/power.png"));
    private Image value = Toolkit.getDefaultToolkit().getImage(BackGround.class.getResource("/imgs/value.png"));
    private Image book = Toolkit.getDefaultToolkit().getImage(BackGround.class.getResource("/imgs/book.png"));
    private Image magnet = Toolkit.getDefaultToolkit().getImage(BackGround.class.getResource("/imgs/magnet2.png"));

    public void paintSelf(Graphics g) {
        g.drawImage(bg2, 0, 0, null);
        switch (Info.GameState) {
            case 0 -> Utils.drawWord(g, 20, Color.black, "Tips:按右键开始游戏,左键发出钩子,右键可销毁不要的物品,左键购物车可购买物品,右键继续游戏", 37, 710);
            case 1 -> {
                g.drawImage(bg, 0, 200, null);
                g.drawImage(peo, 437, 130, null);
                g.drawImage(bakudan, 550, 120, null);
                Utils.drawWord(g, 30, Color.black, "Level " + Info.level, 30, 60);
                Utils.drawWord(g, 30, Color.black, "我的金钱：" + Info.Money, 30, 110);
                Utils.drawWord(g, 30, Color.black, "目标金钱：" + Info.map.get(Info.level), 30, 160);
                Utils.drawWord(g, 20, Color.black, "*" + Info.BakudanNum, 600, 140);
                Info.endTime = System.currentTimeMillis();
                long time = Info.levelTime + Info.extraTime - (Info.endTime - Info.startTime) / 1000;
                Utils.drawWord(g, 20, Color.black, "剩余时间：" + (time > 0 ? time : 0), 800, 100);
            }
            case 2 -> {
                Utils.drawWord(g, 30, Color.black, "我的金钱：" + Info.Money, 30, 110);
                List<Buy> buy = new ArrayList<>();
                buy.add(new Buy(38, 400));
                buy.add(new Buy(188, 400));
                buy.add(new Buy(338, 400));
                buy.add(new Buy(550, 400));
                buy.add(new Buy(750, 400));
                Continue con = new Continue(650, 80);
                g.drawImage(con.image, con.x, con.y, null);
                //画炸弹
                if(Info.is_sale[0]){
                    g.drawImage(bakudan, 60, 280, null);
                }

                if (!Info.is_display[0]) {
                    Info.cost[0] = (int) (Math.random() * 300 + 20);
                    Info.is_display[0] = true;
                }
                if(Info.is_sale[0]){
                    Utils.drawWord(g, 20, Color.black, "炸弹 $" + Info.cost[0], buy.get(0).x, buy.get(0).y);
                }
                if ((!Info.is_clicked[0] || !Info.is_shopped[0]) && Info.is_sale[0]) {
                    g.drawImage(buy.get(0).image, buy.get(0).x, buy.get(0).y, null);
                }

                //画生力水
                if(Info.is_sale[1]){
                    g.drawImage(power, 180, 220, null);
                }

                if (!Info.is_display[1]) {
                    Info.cost[1] = (int) (Math.random() * 700 + 200);
                    Info.is_display[1] = true;
                }
                if(Info.is_sale[1]){
                    Utils.drawWord(g, 20, Color.black, "生力水 $" + Info.cost[1], buy.get(1).x, buy.get(1).y);
                }
                if ((!Info.is_clicked[1] || !Info.is_shopped[1]) && Info.is_sale[1]) {
                    g.drawImage(buy.get(1).image, buy.get(1).x, buy.get(1).y, null);
                }

                //钻石升值水
                if(Info.is_sale[2]){
                    g.drawImage(value, 360, 250, null);
                }
                if (!Info.is_display[2]) {
                    Info.cost[2] = (int) (Math.random() * 900 + 300);
                    Info.is_display[2] = true;
                }
                if(Info.is_sale[2]){
                    Utils.drawWord(g, 20, Color.black, "钻石升值水 $" + Info.cost[2], buy.get(2).x, buy.get(2).y);
                }
                if ((!Info.is_clicked[2] || !Info.is_shopped[2]) && Info.is_sale[2]) {
                    g.drawImage(buy.get(2).image, buy.get(2).x, buy.get(2).y, null);
                }

                //石头书
                if(Info.is_sale[3]){
                    g.drawImage(book, 560, 250, null);
                }
                if (!Info.is_display[3]) {
                    Info.cost[3] = (int) (Math.random() * 500 + 100);
                    Info.is_display[3] = true;
                }
                if(Info.is_sale[3]){
                    Utils.drawWord(g, 20, Color.black, "石头收藏书 $" + Info.cost[3], buy.get(3).x, buy.get(3).y);
                }
                if ((!Info.is_clicked[3] || !Info.is_shopped[3]) && Info.is_sale[3]) {
                    g.drawImage(buy.get(3).image, buy.get(3).x, buy.get(3).y, null);
                }

                //磁铁
                if(Info.is_sale[4]){
                    g.drawImage(magnet, 760, 250, null);
                }
                if (!Info.is_display[4]) {
                    Info.cost[4] = (int) (Math.random() * 400 + 200);
                    Info.is_display[4] = true;
                }
                if(Info.is_sale[4]){
                    Utils.drawWord(g, 20, Color.black, "魔力磁铁 $" + Info.cost[4], buy.get(4).x, buy.get(4).y);
                }
                if ((!Info.is_clicked[4] || !Info.is_shopped[4]) && Info.is_sale[4]) {
                    g.drawImage(buy.get(4).image, buy.get(4).x, buy.get(4).y, null);
                }

            }
            case 3 -> {
                Utils.drawWord(g, 50, Color.black, "Game Over!", 350, 300);
                Utils.drawWord(g, 50, Color.black, "最终金钱：" + Info.Money, 350, 400);
                Utils.drawWord(g, 50, Color.black, "左键重新开始游戏", 280, 500);
            }
            case 4 -> {
                Utils.drawWord(g, 50, Color.black, "恭喜您通关！", 350, 300);
                Utils.drawWord(g, 50, Color.black, "最终金钱：" + Info.Money, 350, 400);
                Utils.drawWord(g, 50, Color.black, "左键重新开始游戏", 280, 500);
            }
        }

    }


}

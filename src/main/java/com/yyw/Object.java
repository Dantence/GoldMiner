package com.yyw;

import lombok.Data;

import java.awt.*;
@Data
public class Object {
    //坐标
    private int x;
    private int y;
    //宽高
    private int width;
    private int height;
    //图片
    private Image image;
    //状态 0未被抓取 1正被抓取 2已被抓取
    private int state;
    //对抓取速度的影响因子，越大抓取速度越快
    private double factor;
    //价值
    private int value;
    //是否是问号袋子
    private boolean is_question = false;
    //是否是钻石
    private boolean is_diamond = false;
    //是否是虚弱药
    private boolean is_weak = false;
    //是否是TNT
    private boolean is_TNT = false;
    //是否是rock
    private boolean is_rock = false;
    //是否是蚯蚓
    private boolean is_worm = false;
    //是否含有钻石
    private boolean have_dia = false;
    //是否宝箱
    private boolean is_box = false;
    //活动速度
    private int speed = (int)(Math.random()*1.99 + 1);
    //活动起点
    private int start;
    //活动方向
    private boolean is_right;
    //特殊钻石
    private boolean is_special;
    //钻石钟类
    private int type = 0;
    //用于钻石虫
    private int id;
    //是否时钟
    private boolean is_clock;
    //是否黑曜石
    private boolean is_black;
    //是否财神
    private boolean is_goldGod;
    //是否魔术棒
    private boolean is_magic;

    public void paintSelf(Graphics g){
        g.drawImage(image, x, y, null);
    }
    public Rectangle getRec(){
        return new Rectangle(x, y, width, height);
    }
}

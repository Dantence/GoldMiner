package com.yyw;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class Utils {
    public static String getResourcePath(){
        return "src/main/resources/";
    }
    public static void drawWord(Graphics g, int size, Color color, String str, int x, int y){
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str, x, y);
    }
    public static double nowfactor = 10;
    public static boolean should_show = false;
    public static boolean should_show_small_boom = false;
    public static int rock_times = 1;
    public static int DiamondWormId = 1;
    static public boolean gameTime(){
        long time = (Info.endTime - Info.startTime) / 1000;
        return (time > Info.levelTime + Info.extraTime);
    }
    public static void Resume(){
        Info.extraTime = 0;
        Utils.DiamondWormId = 1;
        Info.power = 0;
        Info.extraValue = 0;
        Info.weak = 0;
        Info.dropSpeed = 0;
        Info.range = 0;
        Info.is_magnet = false;
        Utils.should_show = false;
        Utils.rock_times = 1;
        Continue.is_clicked = false;
        Arrays.fill(Info.is_clicked, false);
        Arrays.fill(Info.is_display, false);
        Arrays.fill(Info.is_shopped, false);
        Info.Money = 0;
        Info.BakudanNum = 1;
        Info.BakudanFlag = false;
        Line.n = 0.5;
        Line.length = 50;
        Line.state = 0;
    }
    public static void LevelUpdate(){
        Info.startTime = System.currentTimeMillis();
        Line.n = 0.5;
        Line.length = 50;
        Line.state = 0;
    }
    public static void DrawValue(Graphics g, int value, boolean is_powerful, boolean is_getboom){
        if(is_powerful){
            drawWord(g, 40, Color.black, "Stronger!", 250, 140);
        } else if(is_getboom){
            drawWord(g, 35, Color.black, "获得炸弹*1", 250, 140);
        } else {
            drawWord(g, 50, Color.black, "$" + value, 300, 140);
        }
    }
    public static void DrawBoom(Graphics g, int boomx, int boomy, int type){
        Image image = null;
        if(type == 0){
            image = Toolkit.getDefaultToolkit().getImage(Utils.class.getResource("/imgs/smallboom.png"));
        } else if (type == 1){
            image = Toolkit.getDefaultToolkit().getImage(Utils.class.getResource("/imgs/bigboom.png"));
        }
        g.drawImage(image, boomx, boomy, null);
    }
    public static int compute(int level){
        return (int) (level * level * 220);
    }
}

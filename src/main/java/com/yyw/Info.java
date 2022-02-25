package com.yyw;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Info {
    static int Money = 0;
    static int BakudanNum = 1;
    //是否应该执行丢炸弹逻辑
    static boolean BakudanFlag = false;
    //是否可以丢炸弹
    static boolean BakudanAllow = false;
    static Map<Integer, Integer> map = new HashMap<>();
    static {
        map.put(1, 650);
        map.put(2, 1760);
        map.put(3, 3090);
        map.put(4, 5210);
        map.put(5, 6720);
        map.put(6, 8848);
        map.put(7, 13120);
        map.put(8, 16930);
        map.put(9, 23170);
        map.put(10, 26480);
        map.put(11, 30180);
        map.put(12, 34990);
        map.put(13, 38820);
        for(int i = 14; i <= 67; i++){
            map.put(i,Utils.compute(i));
        }
        map.put(68, 1000000);
    }
    static int level = 1;
    static int levelNum = 68;
    //0未开始 1运行中 2商店 3失败 4胜利 5购买道具
    static int GameState = 0;
    static long levelTime = 60;
    static long startTime;
    static long endTime;
    static long extraTime;
    static boolean is_shopping = false;
    static double power = 0;
    static int [] cost = {0, 0, 0, 0, 0};
    static boolean [] is_clicked = {false, false, false, false, false};
    static boolean [] is_display= {false, false, false, false, false};
    static boolean [] is_shopped= {false, false, false, false, false};
    static boolean [] is_sale= {false, false, false, false, false};
    static GameWindow gameWindow;
    static int now_value;
    static boolean is_powerful = false;
    static boolean is_getboom = false;
    static boolean is_magnet = false;
    static int extraValue = 0;
    static int boomx;
    static int boomy;
    static double weak = 0;
    static int range = 0;
    static int dropSpeed = 0;

}

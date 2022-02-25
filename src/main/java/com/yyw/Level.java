package com.yyw;

import java.util.List;

public class Level {
    public static boolean addObject(Object new_obj, List<Object> objectList){
        if(!new_obj.is_special()){
            for(Object obj : objectList){
                if(new_obj.getRec().intersects(obj.getRec())){
                    return false;
                }
            }
        }
        objectList.add(new_obj);
        return true;
    }
    private static void addObject2(Object new_obj, List<Object> objectList){
        objectList.add(new_obj);
    }
    private static void addDiamondWorm(List<Object> objectList, int type){
        DiamondWorm earthWorm = new DiamondWorm();
        earthWorm.setType(type);
        int x = earthWorm.getX();
        int y = earthWorm.getY();
        boolean is_right = earthWorm.is_right();
        int speed = earthWorm.getSpeed();
        addObject2(earthWorm, objectList);
        if(type == 0){
            Diamond diamond = new Diamond(x + 4, y + 4, is_right, speed);
            addObject2(diamond, objectList);
        } else if (type == 1){
            RedDiamond redDiamond = new RedDiamond(x + 4, y + 4, is_right, speed);
            addObject2(redDiamond, objectList);
        }
        Utils.DiamondWormId++;
    }
    public static void GenerateLevel(int level, List<Object> objectList) {
        int x = 0, y = 0;
        switch (level) {
            case 1 -> {
                BigGold bigGold = new BigGold();
                x = bigGold.getX();
                y = bigGold.getY();
                BigRock bigRock = new BigRock();
                bigRock.setX(x - 20);
                bigRock.setY(y - 80);
                addObject(bigRock,objectList);

                for (int i = 0; i < 1; i++) {
                    if (!addObject(new Magic(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if (!addObject(bigGold, objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if (!addObject(new SmallGold(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if (!addObject(new BigRock(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if (!addObject(new Rock(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if (!addObject(new Question(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if (!addObject(new SmallGold(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if (!addObject(new Rock(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if (!addObject(new BigGold(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if (!addObject(new SmallGold(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if (!addObject(new HugeRock(), objectList)) {
                        i--;
                    }
                }
            }
            case 2 -> {
                Diamond diamond = new Diamond();
                addObject(diamond,objectList);
                x = diamond.getX();
                y = diamond.getY();
                Rock rock = new Rock();
                rock.setX(x - 30);
                rock.setY(y - 60);
                BigRock bigRock = new BigRock();
                bigRock.setX(x + 70);
                bigRock.setY(y - 90);
                addObject(bigRock,objectList);
                addObject(rock,objectList);
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Question(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Gold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 4; i++) {
                    if(!addObject(new SmallGold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new HugeRock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Fishbone(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 4; i++) {
                    if(!addObject(new Rock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new SmallGold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new BigGold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if (!addObject(new Breast(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if (!addObject(new Weak(), objectList)) {
                        i--;
                    }
                }
            }
            case 3 -> {
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new EarthWorm(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Box(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Diamond(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new HugeRock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new BigRock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if(!addObject(new Gold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Fishbone(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new BigGold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if(!addObject(new BigRock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Gold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new EarthWorm(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new HugeRock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Question(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Weak(), objectList)){
                        i--;
                    }
                }
            }
            case 4 -> {
                addDiamondWorm(objectList,0);
                RedDiamond redDiamond = new RedDiamond();
                x = redDiamond.getX();
                y = redDiamond.getY();
                HugeRock hugerock = new HugeRock();
                hugerock.setX(x);
                hugerock.setY(y - 120);
                Rock rock = new Rock();
                rock.setX(x + 45);
                rock.setY(y - 95);
                addObject(hugerock,objectList);
                addObject(rock,objectList);
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Weak(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new RedDiamond(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Gold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Question(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Banana(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if(!addObject(new SmallGold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if(!addObject(new Rock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new HugeRock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new BigGold(), objectList)){
                        i--;
                    }
                }

            }
            case 5 -> {
                for (int i = 0; i < 6; i++) {
                    if(!addObject(new BigGold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 7; i++) {
                    if(!addObject(new Weak(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Rock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Diamond(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if (!addObject(new GoldGod(), objectList)) {
                        i--;
                    }
                }
            }
            case 6 -> {
                addDiamondWorm(objectList,0);
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new EarthWorm(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new TNT(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Head(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Box(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new BigGold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 5; i++) {
                    if(!addObject(new SmallGold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Fishbone(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Rock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if (!addObject(new Breast(), objectList)) {
                        i--;
                    }
                }
            }
            case 7 -> {
                RedDiamond redDiamond = new RedDiamond();
                addObject(redDiamond, objectList);
                x = redDiamond.getX();
                y = redDiamond.getY();
                BigGold bigGold = new BigGold();
                bigGold.setX(x + (int)(Math.random()*30));
                bigGold.setY(y + 60);
                addObject(bigGold, objectList);

                for (int i = 0; i < 1; i++) {
                    if(!addObject(new RedDiamond(), objectList)){
                        i--;
                    }
                }
                addObject(redDiamond, objectList);
                x = objectList.get(2).getX();
                y = objectList.get(2).getY();
                HugeRock hugeRock = new HugeRock();
                hugeRock.setX(x + (int)(Math.random()*20));
                hugeRock.setY(y + 60);
                addObject(hugeRock, objectList);

                for (int i = 0; i < 2; i++) {
                    if(!addObject(new TNT(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Box(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Question(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Diamond(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new TNT(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Diamond(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Rock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new EarthWorm(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Gold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new SmallGold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if (!addObject(new Magic(), objectList)) {
                        i--;
                    }
                }
            }
            case 8 -> {
                for (int i = 0; i < 6; i++) {
                    if(!addObject(new BigGold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 7; i++) {
                    if(!addObject(new Gold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 15; i++) {
                    if(!addObject(new SmallGold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Box(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if(!addObject(new EarthWorm(), objectList)){
                        i--;
                    }
                }

            }
            case 9 -> {
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Excrement(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new EarthWorm(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    addDiamondWorm(objectList,1);
                }
                for (int i = 0; i < 1; i++) {
                    addDiamondWorm(objectList,0);
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new EarthWorm(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    addDiamondWorm(objectList,1);
                }
                for (int i = 0; i < 1; i++) {
                    addDiamondWorm(objectList,0);
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new EarthWorm(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    addDiamondWorm(objectList,1);
                }
                for (int i = 0; i < 1; i++) {
                    addDiamondWorm(objectList,0);
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new EarthWorm(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    addDiamondWorm(objectList,0);
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new EarthWorm(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    addDiamondWorm(objectList,0);
                }
                for (int i = 0; i < 6; i++) {
                    if(!addObject(new EarthWorm(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    addDiamondWorm(objectList,0);
                }
                for (int i = 0; i < 8; i++) {
                    if(!addObject(new Excrement(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if (!addObject(new Breast(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if (!addObject(new Weak(), objectList)) {
                        i--;
                    }
                }


            }
            case 10 -> {
                for (int i = 0; i < 3; i++) {
                    if(!addObject(new HugeRock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 5; i++) {
                    if(!addObject(new BigRock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 9; i++) {
                    if(!addObject(new Rock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if(!addObject(new Box(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Banana(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if(!addObject(new Fishbone(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if(!addObject(new Weak(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Question(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Clock(), objectList)){
                        i--;
                    }
                }
            }
            case 11 -> {
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new BlackRock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if(!addObject(new Excrement(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if(!addObject(new Gold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new RedDiamond(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    addDiamondWorm(objectList,0);
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new RedDiamond(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Question(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new BigRock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if(!addObject(new Fishbone(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Box(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new EarthWorm(), objectList)){
                        i--;
                    }
                }

            }
            case 12 -> {
                for (int i = 0; i < 4; i++) {
                    if(!addObject(new TNT(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 5; i++) {
                    addDiamondWorm(objectList,1);
                }
                for (int i = 0; i < 10; i++) {
                    if(!addObject(new SmallGold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if(!addObject(new Banana(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Head(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new HugeRock(), objectList)){
                        i--;
                    }
                }
            }
            case 13 -> {
                addDiamondWorm(objectList, 1);
                for (int i = 0; i < 1; i++) {
                    if (!addObject(new Diamond(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if (!addObject(new Magic(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if (!addObject(new GoldGod(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if (!addObject(new TNT(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 12; i++) {
                    if (!addObject(new Rock(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (!addObject(new BigRock(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 6; i++) {
                    if (!addObject(new HugeRock(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if (!addObject(new SmallGold(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if (!addObject(new Box(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if (!addObject(new Head(), objectList)) {
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if (!addObject(new Excrement(), objectList)) {
                        i--;
                    }
                }
            }
            default -> {
                addDiamondWorm(objectList, 1);
                addDiamondWorm(objectList, 0);
                if(Math.random() > 0.7){
                    for (int i = 0; i < 1; i++) {
                        if(!addObject(new BlackRock(), objectList)){
                            i--;
                        }
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new HugeRock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new TNT(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if(!addObject(new Rock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new BigRock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new TNT(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Box(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Question(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new BigGold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Gold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 4; i++) {
                    if(!addObject(new SmallGold(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Diamond(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new RedDiamond(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if(!addObject(new Clock(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new EarthWorm(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Banana(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Excrement(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Head(), objectList)){
                        i--;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if(!addObject(new Fishbone(), objectList)){
                        i--;
                    }
                }

                for (int i = 0; i < 2; i++) {
                    if(!addObject(new Weak(), objectList)){
                        i--;
                    }
                }
                if(Math.random() > 0.5)
                {
                    for (int i = 0; i < 1; i++) {
                        if (!addObject(new Magic(), objectList)) {
                            i--;
                        }
                    }
                }
                for (int i = 0; i < 1; i++) {
                    if (!addObject(new Breast(), objectList)) {
                        i--;
                    }
                }
                if(Math.random() > 0.5){
                    for (int i = 0; i < 1; i++) {
                        if (!addObject(new GoldGod(), objectList)) {
                            i--;
                        }
                    }
                }


            }
        }
    }
}

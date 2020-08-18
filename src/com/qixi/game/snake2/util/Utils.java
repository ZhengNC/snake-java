package com.qixi.game.snake2.util;

import com.qixi.game.snake2.main.Box;
import com.qixi.game.snake2.constants.Direction;

import java.awt.*;

/**
 * @author ZhengNC
 * @date 2020/8/14 15:32
 */
public class Utils {

    /**
     * 判断两个格子是否重合
     * @param box1
     * @param box2
     * @return
     */
    public static boolean isCoincide(Box box1, Box box2){
        if (box1.getX() == box2.getX()
                && box1.getY() == box2.getY()){
            return true;
        }
        return false;
    }

    /**
     * 判断方向是否冲突（同方向或反方向都为冲突）
     * @param d1
     * @param d2
     * @return
     */
    public static boolean conflictDirection(Direction d1, Direction d2){
        if (d1 == null || d2 == null || d1 == d2){
            return true;
        }
        if (d1 == Direction.UP && d2 == Direction.DOWN){
            return true;
        }
        if (d2 == Direction.UP && d1 == Direction.DOWN){
            return true;
        }
        if (d1 == Direction.LEFT && d2 == Direction.RIGHT){
            return true;
        }
        if (d2 == Direction.LEFT && d1 == Direction.RIGHT){
            return true;
        }
        return false;
    }

    /**
     * 获取一个随机数，范围在[min, max]
     * @param min 最小数（包括）
     * @param max 最大数（包括）
     * @return
     */
    public static int randomNum(int min, int max){
        if (min < 0 || max < 0 || min > max){
            throw new RuntimeException("选择的范围错误");
        }
        int result = (int)(Math.random() * (max - min + 1)) + min;
        return result;
    }

    /**
     * 随机获取颜色
     *
     * @return
     */
    public static Color randomColor(){
        int r = randomNum(1, 5);
        switch (r){
            case 1:
                return Color.BLUE;
            case 2:
                return Color.CYAN;
            case 3:
                return Color.DARK_GRAY;
            case 4:
                return Color.PINK;
            case 5:
                return Color.MAGENTA;
            default:
                return Color.yellow;
        }
    }
}

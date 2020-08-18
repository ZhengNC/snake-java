package com.qixi.game.snake;

import java.awt.*;

/**
 * @author ZhengNC
 * @date 2020/7/31 17:42
 */
public class Utils {

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
                return Color.GREEN;
        }
    }
}

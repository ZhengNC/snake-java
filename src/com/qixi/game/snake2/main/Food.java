package com.qixi.game.snake2.main;

import java.awt.*;

/**
 * @author ZhengNC
 * @date 2020/8/14 15:37
 */
public class Food extends Box {
    public Food(int x, int y, Color color){
        super(x, y, color);
    }

    /**
     * 重新设置食物的属性
     *
     * @param x
     * @param y
     * @param color
     */
    public void reSet(int x, int y, Color color){
        setX(x);
        setY(y);
        setColor(color);
    }
}

package com.qixi.game.snake2.main;

import com.qixi.game.snake2.constants.Constants;

import java.awt.*;

/**
 * 基础格子
 *
 * @author ZhengNC
 * @date 2020/8/14 15:18
 */
public abstract class Box {

    /**
     * 格子大小
     */
    private final int size = Constants.boxSize;

    /**
     * X坐标
     */
    private int x;

    /**
     * Y坐标
     */
    private int y;

    /**
     * 颜色
     */
    private Color color;

    public Box(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * 绘制此方格
     *
     * @param g
     */
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect((x-1) * size, (y-1) * size, size, size);
    }
}

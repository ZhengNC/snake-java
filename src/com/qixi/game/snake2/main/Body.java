package com.qixi.game.snake2.main;

import java.awt.*;

/**
 * 蛇的身体
 *
 * @author ZhengNC
 * @date 2020/8/14 15:27
 */
public class Body extends Box {

    /**
     * 下一节身体
     */
    private Body next;

    /**
     * 是否为头
     */
    private boolean isHead = false;

    public Body(int x, int y, Color color) {
        super(x, y, color);
    }

    public Body getNext() {
        return next;
    }

    public void setNext(Body next) {
        this.next = next;
    }

    public boolean isHead() {
        return isHead;
    }

    public void setHead(boolean head) {
        isHead = head;
    }
}

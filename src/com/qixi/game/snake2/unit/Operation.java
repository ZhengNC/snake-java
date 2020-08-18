package com.qixi.game.snake2.unit;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author ZhengNC
 * @date 2020/8/14 17:06
 */
public class Operation extends OperationSubject implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        sendKey(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

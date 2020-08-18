package com.qixi.game.snake2.unit;

import java.awt.event.KeyEvent;

/**
 * @author ZhengNC
 * @date 2020/8/17 14:16
 */
public interface OperationObserver {

    /**
     * 监听按键
     * @param e
     */
    void listenerKey(KeyEvent e);
}

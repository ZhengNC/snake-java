package com.qixi.game.snake2.unit;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

/**
 * 操作观察者主题
 *
 * @author ZhengNC
 * @date 2020/8/17 14:15
 */
public abstract class OperationSubject {

    private Set<OperationObserver> observerSet = new HashSet<>();

    /**
     * 注册操作观察者
     *
     * @param observer
     */
    public void registerObserver(OperationObserver observer){
        observerSet.add(observer);
    }

    /**
     * 移除操作观察者
     * @param observer
     */
    public void removeObserver(OperationObserver observer){
        observerSet.remove(observer);
    }

    /**
     * 向观察者发送事件
     * @param e
     */
    public void sendKey(KeyEvent e){
        observerSet.forEach(observer -> observer.listenerKey(e));
    }
}

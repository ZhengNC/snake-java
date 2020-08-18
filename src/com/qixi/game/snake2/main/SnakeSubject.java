package com.qixi.game.snake2.main;

import com.qixi.game.snake2.unit.SnakeObserver;

import java.util.HashSet;
import java.util.Set;

/**
 * 蛇观察者主题
 *
 * @author ZhengNC
 * @date 2020/8/17 10:17
 */
public abstract class SnakeSubject {

    private Set<SnakeObserver> observerSet = new HashSet<>();

    public void registerObserver(SnakeObserver observer){
        observerSet.add(observer);
    }

    public void removeObserver(SnakeObserver observer){
        observerSet.remove(observer);
    }

    public void eatObserver(Food food){
        observerSet.forEach(observer -> observer.eatObserver(food));
    }
}

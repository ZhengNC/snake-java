package com.qixi.game.snake2.unit;

import com.qixi.game.snake2.main.Food;

/**
 * 贪吃蛇行为观察者接口
 *
 * @author ZhengNC
 * @date 2020/8/17 10:19
 */
public interface SnakeObserver {

    /**
     * 吃的行为通知接口
     *
     * @param food
     */
    void eatObserver(Food food);
}

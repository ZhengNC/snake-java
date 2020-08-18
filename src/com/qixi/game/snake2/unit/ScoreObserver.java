package com.qixi.game.snake2.unit;

import com.qixi.game.snake2.main.Food;
import com.qixi.game.snake2.main.Snake;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZhengNC
 * @date 2020/8/17 10:21
 */
public class ScoreObserver implements SnakeObserver {

    /**
     * 分数
     */
    private AtomicInteger score = new AtomicInteger(0);

    public ScoreObserver(Snake snake){
        snake.registerObserver(this);
    }

    @Override
    public void eatObserver(Food food) {
        score.addAndGet(1);
    }

    /**
     * 获取分数
     * @return
     */
    public int getScore(){
        return score.get();
    }
}

package com.qixi.game.snake;

import javax.swing.*;
import java.awt.*;

/**
 * @author ZhengNC
 * @date 2020/7/31 16:55
 */
public class Lawn extends JPanel {

    /**
     * 蛇
     */
    private Body snake;

    /**
     * 食物
     */
    private Body food;

    public Lawn(){
        snake = new Body(0, 0);
        snake.setColor(Color.RED);
        randomFood();
    }

    public Body getSnake(){
        return snake;
    }

    public Body getFood(){
        return food;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        snake.draw(g);
        food.draw(g);
    }

    /**
     * 随机产生食物
     */
    public void randomFood(){
        food = new Body(Utils.randomNum(0, 19), Utils.randomNum(0, 19));
        food.setColor(Color.YELLOW);
    }
}

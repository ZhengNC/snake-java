package com.qixi.game.snake2.main;

import com.qixi.game.snake2.constants.Constants;
import com.qixi.game.snake2.util.Utils;

import javax.swing.*;
import java.awt.*;

/**
 * 草地
 *
 * @author ZhengNC
 * @date 2020/8/14 15:51
 */
public class Lawn extends JPanel {

    /**
     * 草地上有条蛇
     */
    public final Snake snake = new Snake(1, 1);

    /**
     * 草地上有一块食物
     */
    public final Food food = new Food(1, 1, Color.YELLOW);

    public Lawn(){
        initBasic();
        initOther();
    }

    /**
     * 初始化草地的基本属性
     */
    private void initBasic(){
        this.setBounds(0, 0, Constants.mapWidth, Constants.mapHeight);
        this.setBackground(Color.GREEN);
        this.setLayout(null);
    }

    /**
     * 初始化草地上的其它物体
     */
    private void initOther(){
        //初始化食物
        randomFood();
    }

    /**
     * 随机在草地上放一块食物
     */
    public void randomFood(){
        int x = Utils.randomNum(1, 20);
        int y = Utils.randomNum(1, 20);
        Color color = Utils.randomColor();
        food.reSet(x, y, color);
    }

    /**
     * 绘制草地上的物品
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //绘制蛇
        Body body = snake.getHead();
        while (body != null){
            body.draw(g);
            body = body.getNext();
        }
        //绘制食物
        food.draw(g);
    }
}

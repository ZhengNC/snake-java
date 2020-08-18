package com.qixi.game.snake;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author ZhengNC
 * @date 2020/8/13 16:53
 */
public class Move extends Thread {

    /**
     * 速度（移动时间间隔，单位毫秒）
     */
    private long speed = 500L;

    private Body.MoveType direction;

    private Queue<Body.MoveType> directionQueue = new ArrayDeque<>();

    private Lawn lawn;

    public Move(Lawn lawn){
        this.lawn = lawn;
    }

    public void addDirection(Body.MoveType direction) {
        //最多放三个动作
        if (directionQueue.size() < 3){
            directionQueue.add(direction);
        }
    }

    private void setNextDirection(){
        Body.MoveType next = directionQueue.poll();
        if (next != null){
            this.direction = next;
        }
    }

    @Override
    public void run() {
        while (true){
            setNextDirection();
            if (direction != null){
                move();
            }
            try {
                sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move(){
        Body snake = lawn.getSnake();
        Body food = lawn.getFood();

        snake.move(direction);
        snake.draw(lawn.getGraphics());
        snake.printPosition();
        lawn.repaint();
        //判断是否吃到食物
        if (snake.getPosition().equals(food.getPosition())){
            snake.eat(food);
            //随机产生新的食物
            lawn.randomFood();
        }
    }
}

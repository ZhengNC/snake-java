package com.qixi.game.snake2.main;

import com.qixi.game.snake2.constants.Constants;
import com.qixi.game.snake2.constants.Direction;
import com.qixi.game.snake2.main.Body;
import com.qixi.game.snake2.main.Food;
import com.qixi.game.snake2.util.Utils;

import java.awt.*;
import java.util.ArrayDeque;

/**
 * @author ZhengNC
 * @date 2020/8/14 15:44
 */
public class Snake extends SnakeSubject {

    private final Body head;

    private int size;

    /**
     * 蛇当前的移动方向
     */
    private Direction direction;

    /**
     * 蛇未来的行动队列
     */
    private ArrayDeque<Direction> directionQueue = new ArrayDeque<>();

    public Snake(int x, int y) {
        head = new Body(x, y, Color.RED);
        head.setHead(true);
        size = 1;
    }

    public Body getHead() {
        return head;
    }

    /**
     * 吃食物
     *
     * @param food
     */
    public void eat(Food food){
        Body nextBody = head;
        while (nextBody.getNext() != null){
            nextBody = nextBody.getNext();
        }
        //设置新身体为现在尾巴的位置以及食物的颜色
        Body newBody = new Body(nextBody.getX(), nextBody.getY(), food.getColor());
        nextBody.setNext(newBody);
        size++;
        eatObserver(food);
    }

    /**
     * 添加一个行为
     *
     * @param direction
     */
    public void addDirection(Direction direction){
        //如果当前行为为空
        if (this.direction == null){
            directionQueue.add(direction);
            return;
        }
        //获取上一个行为
        Direction last = directionQueue.peekLast();
        //如果行为队列为空
        if (last == null){
            last = this.direction;
        }
        //如果不冲突
        if (!Utils.conflictDirection(last, direction)){
            directionQueue.add(direction);
        }
    }

    /**
     * 蛇移动
     */
    public void move(){
        //取出行动队列的行为
        Direction temp = directionQueue.poll();
        if (temp != null){
            this.direction = temp;
        }
        if (direction != null){
            moveBody(head);
            moveHead();
        }
    }

    private void moveHead(){
        switch (direction){
            case UP:
                head.setY(head.getY()-1);
                if (head.getY() < 1){
                    head.setY(Constants.mapHeightBox);
                }
                break;
            case DOWN:
                head.setY(head.getY()+1);
                if (head.getY() > Constants.mapHeightBox){
                    head.setY(1);
                }
                break;
            case LEFT:
                head.setX(head.getX()-1);
                if (head.getX() < 1){
                    head.setX(Constants.mapWidthBox);
                }
                break;
            case RIGHT:
                head.setX(head.getX()+1);
                if (head.getX() > Constants.mapWidthBox){
                    head.setX(1);
                }
                break;
        }
    }

    private void moveBody(Body body){
        if (body.getNext() == null){
            return;
        }
        moveBody(body.getNext());
        body.getNext().setX(body.getX());
        body.getNext().setY(body.getY());
    }

    public int size(){
        return size;
    }
}

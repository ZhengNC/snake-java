package com.qixi.game.snake;

import java.awt.*;

/**
 * 贪吃蛇的身体
 *
 * @author ZhengNC
 * @date 2020/7/31 14:06
 */
public class Body {

    /**
     * 下一节身体
     */
    private Body next;

    /**
     * 位置
     */
    private Position position;

    /**
     * 大小
     */
    public static final int size = 20;

    /**
     * 颜色
     */
    private Color color;

    /**
     * 位置定义
     */
    public static class Position implements Cloneable{
        /**
         * x坐标
         */
        private int x;
        /**
         * y坐标
         */
        private int y;

        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public Position clone(){
            return new Position(x, y);
        }

        @Override
        public String toString(){
            return "["+x+", "+y+"]";
        }

        @Override
        public boolean equals(Object obj){
            if (obj == null || !(obj instanceof Position)){
                return false;
            }
            Position other = (Position) obj;
            if (this.x == other.x && this.y == other.y){
                return true;
            }else {
                return false;
            }
        }
    }

    public enum MoveType{
        UP, DOWN, LEFT, RIGHT
    }

    public Body(int x, int y){
        this.position = new Position(x, y);
        this.color = Color.GREEN;
    }

    /**
     * 吃
     *
     * @param food
     */
    public void eat(Body food){
        Body temp = this;
        while (temp.next != null){
            temp = temp.next;
        }
        food.setColor(Utils.randomColor());
        temp.next = food;
    }

    /**
     * 移动
     *
     * @param moveType
     */
    public void move(MoveType moveType){
        move(this);
        switch (moveType){
            case UP:
                this.position.y--;
                break;
            case DOWN:
                this.position.y++;
                break;
            case LEFT:
                this.position.x--;
                break;
            case RIGHT:
                this.position.x++;
                break;
        }
    }

    private void move(Body body){
        if (body.next == null){
            return;
        }
        move(body.next);
        body.next.position = body.position.clone();
    }

    public void draw(Graphics g){
        Body temp = this;
        while (temp != null){
            g.setColor(temp.color);
            g.fillRect(temp.position.x * size, temp.position.y * size, size, size);
            temp = temp.next;
        }
    }

    /**
     * 打印位置
     */
    public void printPosition(){
        Body temp = this;
        while (temp != null){
            System.out.println(temp.position);
            temp = temp.next;
        }
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Position getPosition(){
        return position;
    }

}

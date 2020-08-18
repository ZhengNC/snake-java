package com.qixi.game.snake2;

import com.qixi.game.snake2.constants.Constants;
import com.qixi.game.snake2.main.Body;
import com.qixi.game.snake2.main.Lawn;
import com.qixi.game.snake2.unit.GameOperationObserver;
import com.qixi.game.snake2.unit.Operation;
import com.qixi.game.snake2.unit.ScoreObserver;
import com.qixi.game.snake2.unit.SnakeOperationObserver;
import com.qixi.game.snake2.util.UserThreadFactory;
import com.qixi.game.snake2.util.Utils;

import javax.swing.*;

/**
 * @author ZhengNC
 * @date 2020/8/14 16:42
 */
public class Game extends JFrame {

    private Operation operation;

    private volatile boolean gameOver = false;

    public Game(){
        this.setTitle("窗口");
        //设置大小
        this.setSize(Constants.mapWidth+6, Constants.mapHeight+29);
        this.setLayout(null);

        //显示窗口
        this.setVisible(true);

        //设置窗口大小不可调整
        this.setResizable(false);

        //初始化键盘监听
        operation = new Operation();
        this.addKeyListener(operation);

        //设置窗口关闭的事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void runGame(){
        //初始化草地
        Lawn lawn = new Lawn();
        this.add(lawn);
        lawn.repaint();

        //初始化计分系统
        ScoreObserver scoreObserver = new ScoreObserver(lawn.snake);

        //初始化蛇的操控观察者
        SnakeOperationObserver soo = new SnakeOperationObserver(lawn.snake, operation);

        while (!gameOver){
            lawn.snake.move();
            //判断是否吃到食物
            if (Utils.isCoincide(lawn.snake.getHead(), lawn.food)){
                lawn.snake.eat(lawn.food);
                lawn.randomFood();
            }

            //判断是否咬到自己的身子
            if (lawn.snake.size() > 2){
                Body head = lawn.snake.getHead();
                //从第二节身体开始比较
                Body nextBody = head.getNext().getNext();
                while (nextBody != null){
                    if (Utils.isCoincide(head, nextBody)){
                        gameOver = true;
                        break;
                    }
                    nextBody = nextBody.getNext();
                }
            }
            lawn.repaint();
            try {
                Thread.sleep(Constants.speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        operation.removeObserver(soo);
        this.remove(lawn);
        System.out.println("游戏结束，得分："+scoreObserver.getScore());
    }

    public void startGame(){
        Runnable runnable = () -> {
            gameOver = false;
            runGame();
        };
        UserThreadFactory.execute(runnable);
    }

    public boolean gameOver(){
        return gameOver;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
        new GameOperationObserver(game, game.operation);
    }
}

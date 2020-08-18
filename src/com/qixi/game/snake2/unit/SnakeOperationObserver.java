package com.qixi.game.snake2.unit;

import com.qixi.game.snake2.constants.Direction;
import com.qixi.game.snake2.main.Snake;

import java.awt.event.KeyEvent;

/**
 * 蛇操控观察者
 *
 * @author ZhengNC
 * @date 2020/8/17 14:24
 */
public class SnakeOperationObserver implements OperationObserver {

    private Snake snake;

    public SnakeOperationObserver(Snake snake, Operation operation){
        this.snake = snake;
        operation.registerObserver(this);
    }

    @Override
    public void listenerKey(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                snake.addDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                snake.addDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                snake.addDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                snake.addDirection(Direction.RIGHT);
                break;
            default:
                break;
        }
    }
}

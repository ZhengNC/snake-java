package com.qixi.game.snake2.unit;

import com.qixi.game.snake2.Game;

import java.awt.event.KeyEvent;

/**
 * 游戏操作监听者
 *
 * @author ZhengNC
 * @date 2020/8/17 14:47
 */
public class GameOperationObserver implements OperationObserver {

    private Game game;

    public GameOperationObserver(Game game, Operation operation){
        operation.registerObserver(this);
        this.game = game;
    }

    @Override
    public void listenerKey(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_ENTER:
                if (game.gameOver()){
                    game.startGame();
                }
                break;
            default:
                break;
        }
    }
}

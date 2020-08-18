package com.qixi.game.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author ZhengNC
 * @date 2020/7/31 11:15
 */
public class Game extends JFrame implements KeyListener {

    /**
     * 草地
     */
    private Lawn lawn;

    private Move move;

    public Game(){
        this.setTitle("窗口");
        //设置大小
        this.setSize(500, 500);
        this.setLayout(null);

        //显示窗口
        this.setVisible(true);

        //设置窗口大小不可调整
        this.setResizable(false);

        lawn = new Lawn();
        lawn.setBounds(0, 0, 400, 400);
        lawn.setBackground(Color.GREEN);
        lawn.setLayout(null);
        this.add(lawn);

        lawn.repaint();

        move = new Move(lawn);
        move.start();

        //设置窗口关闭的事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.addKeyListener(game);

        game.lawn.repaint();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                System.out.println("上");
                move(Body.MoveType.UP);
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("下");
                move(Body.MoveType.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("左");
                move(Body.MoveType.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("右");
                move(Body.MoveType.RIGHT);
                break;
            default:
                System.out.println(e.getKeyCode());
                break;
        }
    }

    public void move(Body.MoveType moveType){
        move.addDirection(moveType);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

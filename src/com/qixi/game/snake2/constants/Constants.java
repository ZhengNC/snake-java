package com.qixi.game.snake2.constants;

/**
 * @author ZhengNC
 * @date 2020/8/14 15:20
 */
public interface Constants {

    /**
     * 单个方块的大小
     */
    int boxSize = 20;

    /**
     * 地图格子宽度
     */
    int mapWidthBox = 20;

    /**
     * 地图格子高度
     */
    int mapHeightBox = 20;

    /**
     * 地图像素宽度（{@value boxSize} * {@value mapWidthBox} = 400）
     */
    int mapWidth = boxSize * mapWidthBox;

    /**
     * 地图像素高度（{@value boxSize} * {@value mapHeightBox} = 400）
     */
    int mapHeight = boxSize * mapHeightBox;

    /**
     * 速度（移动时间间隔，单位毫秒）
     */
    long speed = 200;
}

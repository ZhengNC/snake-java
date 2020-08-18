package com.qixi.game.snake2.util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ZhengNC
 * @date 2020/8/17 10:43
 */
public class UserThreadFactory {

    private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(
            2, 2,
            0, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1));

    public static void execute(Runnable runnable){
        EXECUTOR.submit(runnable);
    }

}

package com.study.study.vertx.httpvertx;

import io.vertx.core.AbstractVerticle;

/**
 * 苹果卖家
 *
 * @author fangjy
 * @date 2019-10-05 14:41
 **/
public class AppleConsumer extends AbstractVerticle {
    public static final String APPLE_URL="fruitServer.buyApple";

    @Override
    public void start() {
        System.out.println("AppleConsumer_thread_id:"+Thread.currentThread().getId());
        vertx.eventBus().consumer(APPLE_URL,
                msg -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(msg.body()); //处理请求消息
                    msg.reply(Thread.currentThread().getId()+" give you an apple");  //返回给result
                }
        );
    }
}

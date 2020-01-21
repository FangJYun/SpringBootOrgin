package com.study.study.vertx.httpvertx;

import io.vertx.core.Vertx;

/**
 * vertx发布类
 *
 * @author fangjy
 * @date 2019-10-02 21:33
 **/
public class MainStart {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new FruitServer());
        vertx.deployVerticle(new AppleConsumer());
    }
}

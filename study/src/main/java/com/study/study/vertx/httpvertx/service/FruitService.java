package com.study.study.vertx.httpvertx.service;

import com.study.study.vertx.httpvertx.AppleConsumer;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.RoutingContext;

/**
 * 处理方法
 *
 * @author fangjy
 * @date 2019-10-05 14:11
 **/
public class FruitService {

    public void buyApple(RoutingContext ctx, Vertx vertx) {
        vertx.eventBus().request(AppleConsumer.APPLE_URL, Thread.currentThread().getId()+" buy an apple", ar -> {
            if (ar.succeeded()) {
                System.out.println("Received reply: " + ar.result().body() + "and currentThread:"+Thread.currentThread().getId());
                ctx.response().end(ar.result().body().toString());
            }
            else{
                throw new RuntimeException("no apple!");
            }
        });
    }

    public void buyBanana(RoutingContext context) {
        HttpServerRequest request = context.request();
        System.out.println("banana_currentThread:"+Thread.currentThread().getId());
        String count = request.getParam("count");
        context.response()
                .putHeader("content-type", "text/plain")
                .end("buy "+ count + " banana");
    }

    public void buyPear(RoutingContext context) {
        HttpServerRequest request = context.request();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("pear_currentThread:"+Thread.currentThread().getId());
        String count = request.getParam("count");
        context.response()
                .putHeader("content-type", "text/plain")
                .end("buy "+ count + " pear");
    }
}

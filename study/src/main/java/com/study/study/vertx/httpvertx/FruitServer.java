package com.study.study.vertx.httpvertx;

import com.study.study.vertx.httpvertx.service.FruitService;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

/**
 * 用于请求转发
 *
 * @author fangjy
 * @date 2019-10-02 22:05
 **/
public class FruitServer extends AbstractVerticle {


    @Override
    public void start() {
        System.out.println("FruitServer_thread_id:"+Thread.currentThread().getId());
        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);

        //买一个苹果
        router.route(HttpMethod.GET,"/apple").handler(ctx ->new FruitService().buyApple(ctx,vertx));

        //买几个香蕉
        router.route(HttpMethod.GET,"/banana/:count").handler(ctx ->new FruitService().buyBanana(ctx));

        //买几个梨
        router.route(HttpMethod.GET,"/pear/:count").blockingHandler(ctx ->new FruitService().buyPear(ctx));

        server.requestHandler(router).listen(8081);
    }

}

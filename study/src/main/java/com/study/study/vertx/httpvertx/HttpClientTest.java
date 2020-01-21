package com.study.study.vertx.httpvertx;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;

/**
 * 调用请求测试
 *
 * @author fangjy
 * @date 2019-10-05 17:32
 **/
public class HttpClientTest {

    public static void sendRequest(){
        Vertx vertx = Vertx.vertx();
        WebClient client = WebClient.create(vertx);

        System.out.println("enter banana 1 request");

        client.get(8081, "localhost", "/banana/1")
                .send(ar -> {
                    if (ar.succeeded()) {
                        HttpResponse<Buffer> response = ar.result();
                        System.out.println("Got HTTP response:" + response.bodyAsString());
                    } else {
                        ar.cause().printStackTrace();
                    }
                });

        System.out.println("enter banana 2 request");

        client.get(8081, "localhost", "/pear/2")
                .send(ar -> {
                    if (ar.succeeded()) {
                        HttpResponse<Buffer> response = ar.result();
                        System.out.println("Got HTTP response:" + response.bodyAsString());
                    } else {
                        ar.cause().printStackTrace();
                    }
                });
    }

    public static void main(String[] args) {
        sendRequest();
    }

}

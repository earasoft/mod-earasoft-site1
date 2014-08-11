package com.earasoft.site1.requestHandlers;


import org.vertx.java.core.Vertx;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.platform.Container;

import com.earasoft.site1.requestHandlers.util.BaseRequestHander;


public class WSHandler extends BaseRequestHander {

    public WSHandler(Container container, Vertx vertx) {
    	super(container, vertx);
    }

    @Override
    public void get(HttpServerRequest httpServerRequest) {
        httpServerRequest.response().sendFile("templates/ws.html");
    }
    
}
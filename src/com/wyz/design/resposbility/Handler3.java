package com.wyz.design.resposbility;

/**
 * com.wyz.design.resposbility
 * Created by jax on 2019/11/15 15:33
 * TODO:
 */
public class Handler3 extends AbstractHandler {
    @Override
    public void handle(AbstractRequest abstractRequest) {
        System.out.println("------>Handler3处理了request请求----"+abstractRequest.toString());
    }

    @Override
    public int getHandleLevel() {
        return 3;
    }
}

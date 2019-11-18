package com.wyz.design.resposbility;

/**
 * com.wyz.design.resposbility
 * Created by jax on 2019/11/15 15:31
 * TODO:
 */
public class Handler1 extends AbstractHandler {
    @Override
    public void handle(AbstractRequest abstractRequest) {
        System.out.println("------>Handler1处理了request请求----"+abstractRequest.toString());
    }

    @Override
    public int getHandleLevel() {
        return 1;
    }
}

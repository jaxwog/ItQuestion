package com.wyz.design.resposbility;

/**
 * com.wyz.design.resposbility
 * Created by jax on 2019/11/15 15:37
 * TODO:
 */
public class Request3 extends AbstractRequest {
    public Request3(Object object) {
        super(object);
    }

    @Override
    public int getRequestLevel() {
        return 3;
    }
}

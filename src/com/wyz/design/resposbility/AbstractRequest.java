package com.wyz.design.resposbility;

/**
 * com.wyz.design.resposbility
 * Created by jax on 2019/11/15 15:25
 * TODO:抽象请求者
 */
public abstract class AbstractRequest {
    private Object object;

    public AbstractRequest(Object object) {
        this.object=object;
    }
    /**
     * 具体的内容对象
     * @return
     */
    public Object getContent() {
        return object;
    }

    @Override
    public String toString() {
        return "AbstractRequest{" + object +
                '}';
    }

    /**
     * 获取请求级别
     */
    public abstract int getRequestLevel();
}

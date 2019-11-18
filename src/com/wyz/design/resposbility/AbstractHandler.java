package com.wyz.design.resposbility;

/**
 * com.wyz.design.resposbility
 * Created by jax on 2019/11/15 15:28
 * TODO:抽象处理者
 */
public abstract class AbstractHandler {
    protected AbstractHandler nextHandler;
    public  void handleRequest(AbstractRequest abstractRequest) {
        if(getHandleLevel()==abstractRequest.getRequestLevel()) {
            handle(abstractRequest);
        }else {
            if(nextHandler!=null) {
                nextHandler.handleRequest(abstractRequest);
            }else {
                System.out.println("---->  所有的处理对象都不能处理它");
            }
        }
    }

    /**
     * 每个处理者的对象的具体处理方式
     * @param abstractRequest
     */
    public abstract void handle(AbstractRequest abstractRequest);
    /**
     * 每个处着对象处理的级别
     * @return
     */
    public abstract int getHandleLevel();
}

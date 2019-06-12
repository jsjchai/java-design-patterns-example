package com.github.jsjchai;

public abstract class AbstractRuleHandler {

    private AbstractRuleHandler next;

    protected AbstractRuleHandler(AbstractRuleHandler handler){
        this.next = handler;
    }

    protected  boolean check(RedPacketActivity activity){
        if(next != null){
            return next.check(activity);
        }
        return true;
    }
}

package com.github.jsjchai;

public class RedPacketRule extends AbstractRuleHandler {


    public RedPacketRule(AbstractRuleHandler handler) {
        super(handler);
    }

    @Override
    protected boolean check(RedPacketActivity activity) {
        System.out.println("check activity number");
        return activity.getTotal() > 0 && super.check(activity);
    }
}

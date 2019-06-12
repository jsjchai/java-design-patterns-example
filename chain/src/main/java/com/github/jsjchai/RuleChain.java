package com.github.jsjchai;

public class RuleChain {

    AbstractRuleHandler chain;

    public RuleChain(){
        this.chain = new ActivityDateRule(new RedPacketRule(null));
    }

    public boolean check(RedPacketActivity activity) {
        return chain.check(activity);
    }
}

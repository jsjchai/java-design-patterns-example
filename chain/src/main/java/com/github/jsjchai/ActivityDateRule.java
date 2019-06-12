package com.github.jsjchai;

import java.util.Date;

public class ActivityDateRule extends AbstractRuleHandler{

    public ActivityDateRule(AbstractRuleHandler handler) {
        super(handler);
    }

    @Override
    protected boolean check(RedPacketActivity activity) {
        System.out.println("check activity date");
        Date now = new Date();
        boolean result = activity.getStartTime().before(now) && activity.getEndTime().after(now);

        return result && super.check(activity);
    }
}

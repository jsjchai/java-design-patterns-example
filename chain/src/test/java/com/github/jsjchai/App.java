package com.github.jsjchai;



import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Date;
import org.joda.time.DateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class App {

    @Test
    @DisplayName("check red packet rule")
    public void test() {
        RuleChain chain = new RuleChain();

        Date start = new DateTime(2019, 6, 10, 0, 0, 0).toDate();
        Date end = new DateTime(2019, 6, 18, 23, 59, 59).toDate();

        RedPacketActivity activity =
            new RedPacketActivity("redPack",start,end,10);

        assumeTrue(end.after(new Date()),"Activity expired,Please modify the end time");
        assertTrue(chain.check(activity));
    }
}

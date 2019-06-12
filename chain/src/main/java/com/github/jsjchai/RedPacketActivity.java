package com.github.jsjchai;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RedPacketActivity {

    /**
     * 红包活动名称
     */
    private String name;

    /**
     *  活动起始时间
     */
    private Date startTime;

    /**
     *  活动结束时间
     */
    private Date endTime;

    /**
     *  红包总数
     */
    private Integer total;
}

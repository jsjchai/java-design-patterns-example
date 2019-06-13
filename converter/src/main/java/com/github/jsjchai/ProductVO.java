package com.github.jsjchai;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ProductVO {

    private String name;

    private List<String> imgUrls;

    private String createTime;


}

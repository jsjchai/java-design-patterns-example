package com.github.jsjchai;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Product {

    private Long id;

    private String name;

    private List<String> imgUrls;

    private Date createTime;

    private Date updateTime;

    public Product(String name) {
        this.name = name;
    }
}

package com.github.jsjchai;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collections;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class App {

    @Test
    @DisplayName("Product convert ProductVO")
    public void test(){
        Product product = new Product("羽毛球");
        product.setId(1000L);
        product.setImgUrls(Collections.singletonList("https://url"));

        Date now = new Date();
        product.setCreateTime(now);
        product.setUpdateTime(now);


        ProductVO productVO = new ProductConverter().convertFromEntity(product);

        assertNotNull(productVO.getName());
    }
}

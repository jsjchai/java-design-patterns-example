package com.github.jsjchai;

import org.joda.time.DateTime;

public final class ProductConverter extends Converter<ProductVO, Product> {


    public ProductConverter() {
        super(productVO -> new Product(productVO.getName()),
            product -> new ProductVO(product.getName(), product.getImgUrls(),
                new DateTime(product.getCreateTime()).toString()));
    }
}

package com.github.jsjchai;


import lombok.Setter;
import lombok.Getter;

/**
 * @author jsjchai.
 */
@Setter
@Getter
public abstract class AbstractOperation {

    double num1;

    double num2;

    /**
     *  计算结果
     * @return 结果
     */
    public abstract double getResult();
}

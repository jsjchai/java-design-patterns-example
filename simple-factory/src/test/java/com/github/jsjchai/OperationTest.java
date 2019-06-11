package com.github.jsjchai;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jsjchai.
 */
@DisplayName("Test operation")
class OperationTest {

    @Test
    @DisplayName("Test 100.2 + 100.8 = 201.0")
    public void testAdd(){
        AbstractOperation oper = OperationFactory.createOperation("+");
        oper.setNum1(100.2);
        oper.setNum2(100.8);

        assertEquals(oper.getResult(),201.0);
    }
}

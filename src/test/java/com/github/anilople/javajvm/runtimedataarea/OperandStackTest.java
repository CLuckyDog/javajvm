package com.github.anilople.javajvm.runtimedataarea;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperandStackTest {

    @Test
    public void OperandStackTest() {
        OperandStack operandStack = new OperandStack(100);
        operandStack.pushBooleanValue(false);
        operandStack.pushByteValue(Byte.MAX_VALUE);
        operandStack.pushCharValue('9');

        Assertions.assertEquals('9', operandStack.popCharValue());
        Assertions.assertEquals(Byte.MAX_VALUE, operandStack.popByteValue());
        Assertions.assertEquals(false, operandStack.popBooleanValue());

        operandStack.pushIntValue(333);
        operandStack.pushLongValue(100000000000000L);
        operandStack.pushShortValue((short) 999);

        Assertions.assertEquals((short) 999, operandStack.popShortValue());
        Assertions.assertEquals(100000000000000L, operandStack.popLongValue());
        Assertions.assertEquals(333, operandStack.popIntValue());

        operandStack.pushReference(null);

        Assertions.assertEquals(null, operandStack.popReference());
    }

}

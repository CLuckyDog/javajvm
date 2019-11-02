package com.github.anilople.javajvm.runtimedataarea;

import java.util.Stack;

public class OperandStack {
    
    private int maxStack;
    
    private Stack<LocalVariable> operandStack;
    
    private OperandStack() {}
    
    public OperandStack(int maxStack) {
        this.maxStack = maxStack;
        operandStack = new Stack<>();
    }


    public boolean popBooleanValue() {
        return operandStack.pop().getBooleanValue();
    }

    public byte popByteValue() {
        return operandStack.pop().getByteValue();
    }

    public char popCharValue() {
        return operandStack.pop().getCharValue();
    }

    public short popShortValue() {
        return operandStack.pop().getShortValue();
    }

    public int popIntValue() {
        return operandStack.pop().getIntValue();
    }

    public float popFloatValue() {
        return operandStack.pop().getFloatValue();
    }

    public Object popReference() {
        return operandStack.pop().getReference();
    }

    public int popReturnAddress() {
        return operandStack.pop().getReturnAddress();
    }

    public long popLongValue() {
        return operandStack.pop().getLongValue();
    }

    public double popDoubleValue() {
        return operandStack.pop().getDoubleValue();
    }


    public void pushBooleanValue(boolean booleanValue) {
        operandStack.push(new LocalVariable().setBooleanValue(booleanValue));
    }

    public void pushByteValue(byte byteValue) {
        operandStack.push(new LocalVariable().setByteValue(byteValue));
    }

    public void pushCharValue(char charValue) {
        operandStack.push(new LocalVariable().setCharValue(charValue));
    }

    public void pushShortValue(short shortValue) {
        operandStack.push(new LocalVariable().setShortValue(shortValue));
    }

    public void pushIntValue(int intValue) {
        operandStack.push(new LocalVariable().setIntValue(intValue));
    }

    public void pushFloatValue(float floatValue) {
        operandStack.push(new LocalVariable().setFloatValue(floatValue));
    }

    public void pushReference(Object reference) {
        operandStack.push(new LocalVariable().setReference(reference));
    }

    public void pushReturnAddress(int returnAddress) {
        operandStack.push(new LocalVariable().setReturnAddress(returnAddress));
    }

    public void pushLongValue(long longValue) {
        operandStack.push(new LocalVariable().setLongValue(longValue));
    }

    public void pushDoubleValue(double doubleValue) {
        operandStack.push(new LocalVariable().setDoubleValue(doubleValue));
    }
}

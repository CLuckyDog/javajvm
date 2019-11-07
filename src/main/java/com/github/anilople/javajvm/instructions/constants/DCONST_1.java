package com.github.anilople.javajvm.instructions.constants;

import com.github.anilople.javajvm.instructions.BytecodeReader;
import com.github.anilople.javajvm.instructions.Instruction;
import com.github.anilople.javajvm.runtimedataarea.Frame;

/**
 * Description: Push the double constant <d> (0.0 or 1.0) onto the operand stack.
 */
public class DCONST_1 implements Instruction {
    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {

    }

    @Override
    public int execute(Frame frame) {
        frame.getOperandStacks().pushDoubleValue(1.0D);
        return this.size();
    }

    @Override
    public int size() {
        return 1;
    }
}

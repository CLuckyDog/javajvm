package com.github.anilople.javajvm.instructions.constants;

import com.github.anilople.javajvm.instructions.BytecodeReader;
import com.github.anilople.javajvm.instructions.Instruction;
import com.github.anilople.javajvm.runtimedataarea.Frame;

/**
 * Description: Push the int constant <i> (-1, 0, 1, 2, 3, 4 or 5) onto the operand
 * stack.
 * Notes: Each of this family of instructions is equivalent to bipush <i> for
 * the respective value of <i>, except that the operand <i> is implicit.
 */
public class ICONST_2 implements Instruction {
    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {

    }

    @Override
    public int execute(Frame frame) {
        frame.getOperandStacks().pushIntValue(2);
        return this.size();
    }

    @Override
    public int size() {
        return 1;
    }
}

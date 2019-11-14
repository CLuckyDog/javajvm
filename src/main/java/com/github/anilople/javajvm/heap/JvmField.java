package com.github.anilople.javajvm.heap;

import com.github.anilople.javajvm.classfile.FieldInfo;
import com.github.anilople.javajvm.constants.Descriptors;
import com.github.anilople.javajvm.utils.ConstantPoolUtils;

import java.util.List;

public class JvmField extends JvmClassMember {

    public JvmField(JvmClass jvmClass, FieldInfo fieldInfo) {
        super(
                jvmClass,
                fieldInfo.getAccessFlags(),
                ConstantPoolUtils.getUtf8(fieldInfo.getClassFile().getConstantPool(), fieldInfo.getNameIndex()),
                ConstantPoolUtils.getUtf8(fieldInfo.getClassFile().getConstantPool(), fieldInfo.getDescriptorIndex()),
                fieldInfo.getAttributes()
        );
    }

    public static JvmField[] generateJvmFields(JvmClass jvmClass, FieldInfo[] fieldInfos) {
        JvmField[] jvmFields = new JvmField[fieldInfos.length];
        for(int i = 0; i < jvmFields.length; i++) {
            jvmFields[i] = new JvmField(jvmClass, fieldInfos[i]);
        }
        return jvmFields;
    }

    @Override
    public boolean equals(Object obj) {
        if(null == obj) {
            // null pointer
            return false;
        }
        if(!(obj instanceof JvmField)) {
            // type is not equal
            return false;
        }
        if(obj == this) {
            // same pointer
            return true;
        }
        JvmField jvmField = (JvmField) obj;
        // simply judge with access flag, name and descriptor
        return this.getAccessFlags() == jvmField.getAccessFlags()
                && this.getName().equals(jvmField.getName())
                && this.getDescriptor().equals(jvmField.getDescriptor());
    }

    /**
     * an field's type
     * size = 1 (1 int can represent it)
     * boolean, byte, char, short, int
     * float, reference
     *
     * size = 2 (2 int can represent it)
     * long, double
     * @return
     */
    public int getSize() {
        String descriptor = this.getDescriptor();
        if(Descriptors.BaseType.LONG.equals(descriptor)
        || Descriptors.BaseType.DOUBLE.equals(descriptor)) {
            return 2;
        } else {
            return 1;
        }
    }

    /**
     * calculate that the offset of a non static field in a class
     * just remember that long and double occupy 2 location
     * @param jvmClass
     * @param jvmField
     * @return
     */
    public static int calculateNonStaticFieldOffset(JvmClass jvmClass, JvmField jvmField) {
        int offset = 0;
        for(JvmClass tempClass : JvmClass.getInheritedClassesChain(jvmClass)) {
            offset += tempClass.getNonStaticFieldsSize();
        }

        // subtract now class fields's size
        offset -= jvmClass.getNonStaticFieldsSize();

        // add offset
        for(JvmField tempField : jvmClass.getJvmFields()) {
            if(tempField.equals(jvmField)) {
                // meet same
                break;
            } else {
                offset += tempField.getSize();
            }
        }

        return offset;
    }

    /**
     * suppose this field is not static field
     * now calculate its offset in all fields (current class and super classes)
     * @return
     */
    public int calculateNonStaticFieldOffset() {
        return JvmField.calculateNonStaticFieldOffset(this.getJvmClass(), this);
    }
}
package com.fullstacker.study.course.JAVASE.enumTest;

/**
 * 由字节码命令可以看出枚举类其实最终形式为
 * <p>
 * public class EnumTest extends enum{
 * public static final EnumTest A;
 * public static final EnumTest B;
 * public static final EnumTest C;
 * }
 */
public enum EnumTest {
    A(1, 200), B(2, 300), C;

    EnumTest() {

    }

    EnumTest(int code, int value) {

    }

    private int code;

    private int value;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

package com.annoProc;

/**
 * 命名规范校验代码
 */
public class NameTest {

    enum colors {
        read, blue, green;
    }

    static final int _FORTY_TWO = 42;

    public static int NOT_A_CONSTANT = _FORTY_TWO;

    protected void BADLY_NAMED_CODE() {
    }

    public void NotCamelCASEmethodNAME() {
    }
}

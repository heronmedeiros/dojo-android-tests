package com.example.dojo1.test;

import java.security.InvalidParameterException;

import junit.framework.TestCase;

import com.example.dojo1.Convert;

public class ConvertTest extends TestCase {

    private Convert convert;

    @Override
    protected void setUp() throws Exception {
        convert = new Convert();
        super.setUp();
    }

    public void testBinaryToDecimal0() {
        assertEquals(0, convert.binaryToDecimal("0"));
    }

    public void testBinaryToDecimal1() {
        assertEquals(1, convert.binaryToDecimal("1"));
    }

    public void testBinaryToDecimal2() {
        assertEquals(2, convert.binaryToDecimal("10"));
    }

    public void testBinaryToDecimal15() {
        assertEquals(15, convert.binaryToDecimal("1111"));
    }

    public void testBinaryToDecimal1000007() {
        String binary = Integer.toBinaryString(1000007);
        assertEquals(1000007, convert.binaryToDecimal(binary));
    }

    public void testInvalidBinary() {
        try {
            convert.binaryToDecimal("2");
            fail("InvalidParameterException not received.");
        } catch (InvalidParameterException e) {
            assertTrue(true);
        }
    }
    
}

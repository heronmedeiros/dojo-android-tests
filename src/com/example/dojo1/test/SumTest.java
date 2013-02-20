package com.example.dojo1.test;

import static org.mockito.Mockito.when;

import java.security.InvalidParameterException;

import junit.framework.TestCase;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoAnnotations.Mock;

import com.example.dojo1.Convert;
import com.example.dojo1.Sum;



public class SumTest extends TestCase {

	@Mock
	private Convert convert;
	@InjectMocks
	private Sum sum = new Sum();

    @Override
    protected void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(convert.binaryToDecimal("0")).thenReturn(0);
        when(convert.binaryToDecimal("1")).thenReturn(1);
        when(convert.binaryToDecimal("11")).thenReturn(3);
        super.setUp();
    }

    
    public void testBinarySumWhen0And0Return0() {
    	assertEquals(0, sum.binarySum("0", "0"));
    }

    public void testBinarySumWhen1And11Return4() {
        assertEquals(4, sum.binarySum("1", "11"));
    }

    public void testInvalidParameters() {
        sum.setConvert(new Convert());
        try {
            sum.binarySum("1", "21");
            fail("Should raise a InvalidParameterException");
        } catch (InvalidParameterException e) {
            assertTrue(true);
        }
    }
    
    public void testValidParameters() {
        try {
            sum.binarySum("1", "11");
            assertTrue(true);
        } catch (InvalidParameterException e) {
            fail("Should not raise a InvalidParameterException");
        }
    }
}

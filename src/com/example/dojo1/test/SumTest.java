package com.example.dojo1.test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.security.InvalidParameterException;

import junit.framework.TestCase;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations.Mock;

import com.example.dojo1.Convert;
import com.example.dojo1.Sum;



public class SumTest extends TestCase {

	
	private Sum sum;
   
	@Mock
	private Convert convert;
	
	@InjectMocks
	private Sum sum1;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        sum = new Sum();
    }

    
    public void testBinarySumWhen0And0Return0() {
    	
    	
    	when(convert.binaryToDecimal("0")).thenReturn(12);
    	
    	sum1 = new Sum();
    
    	
    	assertEquals(12, sum1.binarySum("0", "0"));
 
    
/*    public void testBinarySumWhen0And0Return0() {
    	Sum spySum = spy(new Sum());
    	
    	Convert mockConvert = mock(Convert.class);
    	
    	when(mockConvert.binaryToDecimal("0")).thenReturn(10);
//    	when(mockConvert.binaryToDecimal("1")).thenReturn(1);
    	
    	assertEquals(2, spySum.binarySum("0", "0"));
*/    	
    	
    	
//        Convert convert = mock(Convert.class);        
//        
//        //Sum s = spy(new Sum());        
//        
//        when(convert.binaryToDecimal("0")).thenReturn(111);
//        
//        
//        //int result = s.binarySum("0", "0");
////        assertEquals(0, result);
//        assertEquals(111, convert.binaryToDecimal("0"));
    }

    public void testBinarySumWhen1And11Return4() {
        int result = sum.binarySum("1", "11");
        assertEquals(4, result);
    }

    public void testInvalidParameters() {
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

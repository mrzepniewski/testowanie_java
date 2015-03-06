

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.Assert;

import static org.hamcrest.BaseMatcher.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {
		
	  @Test
      public void testAddMethod(){
             
              Calculator calc = new Calculator();
              assertEquals(10.2, calc.add(5.1, 5.1),1e-15);
              //assertThat("should be equal", calc.add(7,6)  );
      }
	  
	  @Test
      public void testSubMethod(){
             
              Calculator calc = new Calculator();
              assertEquals(10.02, calc.sub(11.12,1.1),1e-15);
      }
	  
	  @Test
      public void testDivMethod(){
             
              Calculator calc = new Calculator();
              assertEquals(1.0, calc.div(0.5, 0.5),1e-15);
      }
	  
	  @Test
      public void testMultiMethod(){
             
              Calculator calc = new Calculator();
              assertEquals(0.25, calc.multi(0.5, 0.5),1e-15);
              assertNotEquals(0.1, calc.multi(0.1, 0.0),1e-15);
              
      }
	  
	  @Test
      public void testGreaterMethod(){
             
              Calculator calc = new Calculator();
              assertEquals(true, calc.greater(20.1, 10.3));
              assertTrue(calc.greater(5.2, 2.123));
      }
	  @Test(expected = java.lang.ArithmeticException.class)
      public void testDivMethodWithException(){
             
              Calculator calc = new Calculator();
              assertEquals(0.0, calc.div(0.5, 0.0),1e-15);
      }
	  
}

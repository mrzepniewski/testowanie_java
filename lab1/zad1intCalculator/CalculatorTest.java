package zad1intCalculator;

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
              assertEquals(10, calc.add(5, 5));
              //assertThat("should be equal", calc.add(7,6)  );
      }
	  
	  @Test
      public void testSubMethod(){
             
              Calculator calc = new Calculator();
              assertEquals(10, calc.sub(20, 10));
      }
	  
	  @Test
      public void testDivMethod(){
             
              Calculator calc = new Calculator();
              assertEquals(100, calc.div(100, 1));
              assertNotEquals(120, calc.div(100, 1));
      }
	  
	  @Test
      public void testMultiMethod(){
             
              Calculator calc = new Calculator();
              assertEquals(10, calc.multi(2, 5));
              assertNotEquals(18, calc.multi(2, 5));
              
      }
	  
	  @Test
      public void testGreaterMethod(){
             
              Calculator calc = new Calculator();
              assertEquals(true, calc.greater(20, 10));
              assertTrue(calc.greater(5, 2));
      }
	  @Test(expected = ArithmeticException.class)
	  public void testDivbyZero(){
		  Calculator calc = new Calculator();
		  assertEquals(0, calc.div(100, 0));
	  }
}

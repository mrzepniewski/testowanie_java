package com.gra.testowanie.lab2;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class cyfrokradTestsWithParamTest {
	  		@Parameters
	  		public static Collection<Object[]> data() {
	  	        return Arrays.asList(new Object[][] {
	  	                 { 77777777,777777777 }, {  null,8 },  { -2, -22 }, { 444, 4444 }, 
	  	           });
	  	    }
			private Integer expected;
            private Integer input;
           
            public cyfrokradTestsWithParamTest(Integer expectedResult,Integer input1) {
                                            this.expected = expectedResult;
                                            this.input = input1;
                   
                                        }
          
             
   
            @Test
            public void TestingwithParameters(){
                     Kontrakt target = new Kontrakt();
                    
                     assertEquals(expected, (target.cyfrokrad(input)));	
            }
   
    
}

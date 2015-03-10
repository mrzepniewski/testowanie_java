package lab2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class nieksztaltekTestWithParam {
	  		@Parameters
	  		public static Collection<Object[]> data() {
	  	        return Arrays.asList(new Object[][] {
	  	                 { 11, 11 }, { 28, 23 },  { 22, 22 }, { 82, 32 },  {1592,1562},
	  	           });
	  	    }
			private Integer expected;
            private Integer input;
           
            public nieksztaltekTestWithParam(Integer expectedResult,Integer input1) {
                                            this.expected = expectedResult;
                                            this.input = input1;
                   
                                        }
          
             
   
            @Test
            public void TestingwithParameters() {
                     Kontrakt target = new Kontrakt();
                    // Integer result = target.hultajchochla(input);
                     //assertTrue("should be equal",result.equals(expected));
                     
                     //nieksztaltekTestWithParam NieksztaltekTestWithParam= new nieksztaltekTestWithParam();
                     assertEquals(expected, (target.nieksztaltek(input)));	
            }
   
    
}

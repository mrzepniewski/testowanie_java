package lab2;

import static org.hamcrest.CoreMatchers.*;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.both;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.junit.matchers.JUnitMatchers.everyItem;
import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import org.junit.experimental.categories.Category;
import org.junit.matchers.JUnitMatchers;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.BaseMatcher.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class InterfejsTests {
	@Test
	public void CyfrokradTest1(){
		Kontrakt target = new Kontrakt();
		Integer actual = target.cyfrokrad(4);
		assertNull("should be null",actual);
	}
	
	@Test
	public void CyfrokradTest2(){
		Kontrakt target = new Kontrakt();
		Integer dlugoscpo=target.cyfrokrad(4413).toString().length();
		assertThat("shouldbeequal",dlugoscpo.equals(3));
	}
	@Test
	public void CyfrokradTest3(){
		Kontrakt target = new Kontrakt();
		Integer checknull = target.cyfrokrad(01);
		assertNull("should be null",checknull);
	}
	@Test
	public void CyfrokradTest4(){
		Kontrakt target = new Kontrakt();
		Integer checknull = target.cyfrokrad(0);
		assertNull("should be null",checknull);
	}
	
	@Test
	public void CyfrokradTest5(){
		Kontrakt target = new Kontrakt();
		Integer shouldnotbenull=target.cyfrokrad(4413);
		assertNotNull("should not be null", shouldnotbenull);
	}
	@Test
	public void CyfrokradTest6(){
		Kontrakt target = new Kontrakt();
		Integer result=target.cyfrokrad(4413);
		assertThat("one of them should be equal",result==441|| result==413 || result==443 );
		
	}
//////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void hultajchochlaTest1() throws NieudanyPsikusException{
		Kontrakt target = new Kontrakt();
		Integer result=target.hultajchochla(12);
		Integer expected = 21;
		Integer notexpected=12;
		assertEquals(result,expected);
		assertNotEquals(result,notexpected);
	}
	
	@Test
	public void hultajchochlaTest2() throws NieudanyPsikusException{
		boolean thrown=false;
		try{
			Kontrakt target = new Kontrakt();
			target.hultajchochla(313);
			
		}
		catch(NieudanyPsikusException ex)
		{
			thrown=true;
		}
		assertFalse(thrown);
	}
	
    @Rule
    public ExpectedException thrown2 = ExpectedException.none();
	@Test
	public void hultajchochlaTest7() throws NieudanyPsikusException{

			thrown2.expect(NieudanyPsikusException.class);
			thrown2.expectMessage("Jedna cyfra");
			Kontrakt target = new Kontrakt();
			target.hultajchochla(2);
	}
	
	
	@Test//(expected= NieudanyPsikusException.class)
	public void hultajchochlaTest3() throws NieudanyPsikusException {
	
		boolean thrown=false;
		try{
			Kontrakt target = new Kontrakt();
			target.hultajchochla(3);
			fail("Oczekujemy NieudanyPsikusException by zostal wylapany");
		}
		catch(NieudanyPsikusException ex)
		{
			thrown=true;
		}
		assertTrue(thrown);
	}
	
	@Test//(expected = NieudanyPsikusException.class)  
	public void hultajchochlaTest4() throws NieudanyPsikusException {
		Kontrakt target = new Kontrakt();
		Integer result;
		try{
			target.hultajchochla(2);
			fail("Oczekujemy NieudanyPsikusException by zostal wylapany");
		}
		catch(NieudanyPsikusException ex)
		{
			assertEquals(NieudanyPsikusException.class,ex.getClass());
			assertTrue(NieudanyPsikusException.class==ex.getClass());
		}
		
	}
	
	@Test//(expected = NieudanyPsikusException.class)  
	public void hultajchochlaTest5() throws NieudanyPsikusException {
		Kontrakt target = new Kontrakt();
		Integer result;
		String expected="Jedna cyfra";
		try{
			target.hultajchochla(2);
			fail("Oczekujemy NieudanyPsikusException by zostal wylapany");
			
		}
		catch(NieudanyPsikusException ex)
		{
			assertEquals(expected,ex.getMessage());
			assertTrue(expected==ex.getMessage());
		}
		
	}
	@Test//(expected = NieudanyPsikusException.class)  
	public void hultajchochlaTest6() throws NieudanyPsikusException {
		Kontrakt target = new Kontrakt();
		Integer result;
		result = target.hultajchochla(213);
		//we expect 312 or 231 or 123
		Integer expected1=123;
		Integer expected2=312;
		Integer expected3=231;
		assertThat("one of them should be equal", result.equals(expected1)|| result.equals(expected2) || result.equals(expected3));
	}
	
	
	@Test
	public void hultajchochlaTest() throws NieudanyPsikusException{
		Kontrakt target = new Kontrakt();
		Integer result=target.hultajchochla(2123);
		String resul=result.toString();
		org.junit.Assert.assertThat(resul, JUnitMatchers.both(JUnitMatchers.containsString("2")).and(JUnitMatchers.containsString("3")));
		
	}
	@Test//changing 3->8,7->1,6->9
	public void nieksztaltek6() throws NieudanyPsikusException{
		Kontrakt target = new Kontrakt();
		Integer result=target.nieksztaltek(1234567890);
		Integer expected1=1284567890;
		Integer expected2=1234597890;
		Integer expected3=1234561890;
		assertThat("one of expected should be equal",result.equals(expected1) || result.equals(expected2) || result.equals(expected3));
		
	}
	@Test//testy referencji example
	public void nieksztaltekTest3(){
		Kontrakt target = new Kontrakt();
		Kontrakt target2 = new Kontrakt();
		assertNotSame("should not be same objects",target,target2);
		target=target2;
		assertSame("now should be same-reference to object2",target,target2);
	}
	@Test
	public void nieksztaltekTest1(){
		Kontrakt target = new Kontrakt();
		Integer result=target.nieksztaltek(2122);
		Integer expected=2122;
		assertEquals("should be equal",result,expected);
		
	}
	
	@Test
	public void nieksztaltekTest4(){
		Kontrakt target = new Kontrakt();
		Integer result=target.nieksztaltek(2123);
		Integer notexpected=2122;
		Integer expected=2128;
		assertEquals("should not be equals",result,expected);
		assertNotEquals("should not be equals",result,notexpected);
		
	}
	
	
	@Test//Just to test assertArrayEquals 
	public void nieksztaltekTest5(){
		Kontrakt target = new Kontrakt();
		Integer result=target.nieksztaltek(2123);
		String resul=result.toString();
		byte[] expected=resul.getBytes();
		byte[] expected2="2128".getBytes();
	
		assertArrayEquals("arrays should be equals",expected,expected2);
	
	}
	
	// JUnit Matchers assertThat
	@Test
	public void nieksztaltekTest6(){
		Kontrakt target = new Kontrakt();
		Integer result=target.nieksztaltek(2123);
		String resul=result.toString();
		org.junit.Assert.assertThat(resul, JUnitMatchers.both(containsString("8")).and(JUnitMatchers.containsString("2")));
		
	}
	/* ????????
	@RunWith(Parameterized.class)
	public class nieksztaltekTest {
		private Integer expected1;
		private Integer expected2;
		private Integer actual;
	
		 public void JunitAdditionTest(Integer expected2Result,Integer expected3Result,Integer actual1) {
					        this.expected1 = expected2Result;
					        this.expected2 = expected3Result;
					        this.actual = actual1;
			
				 	    }
	    @Parameters//changing 3->8,7->1,6->9
	    public Collection<Integer[]> addedNumbers() {
	    	        return Arrays.asList(new Integer[][] { { 879,319, 379}, { 913,618 , 613 },
	    	                { 857, 351, 357 }});
	    		    }
	    	 
	
	@Test
    public void TestingwithParameters(){
		      
	}*/
}

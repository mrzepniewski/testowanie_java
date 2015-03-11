package com.rzymskie.testowanie.lab1;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.Assert;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import static org.hamcrest.BaseMatcher.*;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

public class LiczbaRzymskaTest {
	
	@Test
	public void TestRomanThat434(){
		LiczbaRzymska roman = new LiczbaRzymska(434);
		assertThat("should be equal", roman.toString().equals("CDXXXIV"));
	}
	@Test
	public void TestRomanEquals434(){
		LiczbaRzymska roman = new LiczbaRzymska(434);
		assertEquals(true, roman.toString().equals("CDXXXIV"));
	}
	@Test
	public void TestRomanEquals2(){
		LiczbaRzymska roman = new LiczbaRzymska(2);
		 String expectedArray = new String();
		 expectedArray="II";
		 assertEquals(expectedArray, roman.toString());
		 
	}
	@Test
	public void TestRomanWhatDoIfOutOfRange(){
		LiczbaRzymska roman = new LiczbaRzymska(40000);
		
		 assertEquals(null, roman.toString());
		 
	}
	
	@Test
	public void TestRomanNotEquals(){
		LiczbaRzymska roman = new LiczbaRzymska(434);
		assertNotEquals("should be equal", roman.toString().equals("CDXXX"));
	}
	@Test
	public void TestRomanNotNull(){
		LiczbaRzymska roman = new LiczbaRzymska(3999);
		assertNotNull("should not be null", roman.toString());
	}
	
	@Test
	public void TestRomanAssertFalse(){
		LiczbaRzymska roman = new LiczbaRzymska(4999);
		assertFalse("failure - should be false", roman.toString()!=null);
	}
	@Test
	public void TestRomanNull(){
		LiczbaRzymska roman = new LiczbaRzymska(4999);
		assertNull("should be null", roman.toString());
	}
	@Test
	public void Test1RomanShouldNotBeSame(){
		LiczbaRzymska roman = new LiczbaRzymska(5);
		assertNotSame("should not be same", roman.toString(),"VI");
	}
	@Test
	public void TestRomanTrue(){
		LiczbaRzymska roman = new LiczbaRzymska(5315);
		assertTrue("should  be true", roman.toString()==null);
	}
	
}

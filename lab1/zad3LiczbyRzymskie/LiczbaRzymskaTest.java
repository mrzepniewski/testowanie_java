import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.Assert;
import static org.hamcrest.BaseMatcher.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class LiczbaRzymskaTest {
	
	@Test
	public void verifyRomanThat434(){
		LiczbaRzymska roman = new LiczbaRzymska(434);
		assertThat("should be equal", roman.toString().equals("CDXXXIV"));
	}
	@Test
	public void verifyRomanEquals434(){
		LiczbaRzymska roman = new LiczbaRzymska(434);
		assertEquals(true, roman.toString().equals("CDXXXIV"));
	}
	@Test
	public void verifyRomanNotEquals(){
		LiczbaRzymska roman = new LiczbaRzymska(434);
		assertNotEquals("should be equal", roman.toString().equals("CDXXX"));
	}
	@Test
	public void verifyRomanNotNull(){
		LiczbaRzymska roman = new LiczbaRzymska(3999);
		assertNotNull("should not be null", roman.toString());
	}
	
	@Test
	public void verifyRomanAssertFalse(){
		LiczbaRzymska roman = new LiczbaRzymska(4999);
		assertFalse("failure - should be false", roman.toString()!=null);
	}
	@Test
	public void verifyRomanNull(){
		LiczbaRzymska roman = new LiczbaRzymska(4999);
		assertNull("should be null", roman.toString());
	}
	@Test
	public void verifyRomanShouldNotBeSame(){
		LiczbaRzymska roman = new LiczbaRzymska(5);
		assertNotSame("should not be same", roman.toString(),"VI");
	}
	
}

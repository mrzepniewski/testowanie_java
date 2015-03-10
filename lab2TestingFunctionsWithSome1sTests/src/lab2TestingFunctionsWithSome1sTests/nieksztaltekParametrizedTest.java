package lab2TestingFunctionsWithSome1sTests;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class nieksztaltekParametrizedTest {
int _Input;
int _Expected;
private static Kontrakt gra;
@BeforeClass
public static void setUp() {
gra = new Kontrakt();
}
@Parameters
public static Collection<Object[]> data() {
return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { -1, -1 },
{ 9, 9 }, { -9, -9 }, { 10, 10 }, { -10, -10 }, { 3, 8 },
{ -3, -8 }, { 7, 1 }, { -7, -1 }, { 6, 9 }, { -6, -9 } });
}
public nieksztaltekParametrizedTest(int input, int expected) {
_Input = input;
_Expected = expected;
}
@Test
public void NieksztaltekParametrizedTests() {
assertEquals(Integer.valueOf(_Expected), gra.nieksztaltek(_Input));
}
}
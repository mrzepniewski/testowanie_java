package lab2TestingFunctionsWithSome1sTests;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
public class hultajchochlaTest {
private static Kontrakt gra = new Kontrakt();
@BeforeClass
public static void setUp() {
gra = new Kontrakt();
}
@Test(expected = NieudanyPsikusException.class)
public void hultajchochlaTest1() throws NieudanyPsikusException {
gra.hultajchochla(0);
}
@Test(expected = NieudanyPsikusException.class)
public void hultajchochlaTest2() throws NieudanyPsikusException {
gra.hultajchochla(1);
}
@Test(expected = NieudanyPsikusException.class)
public void hultajchochlaTest3() throws NieudanyPsikusException {
gra.hultajchochla(-1);
}
@Test(expected = NieudanyPsikusException.class)
public void hultajchochlaTest4() throws NieudanyPsikusException {
gra.hultajchochla(9);
}
@Test(expected = NieudanyPsikusException.class)
public void hultajchochlaTest5() throws NieudanyPsikusException {
gra.hultajchochla(-9);
}
@Test
public void hultajchochlaTest6() throws NieudanyPsikusException {
assertThat(gra.hultajchochla(10), is(1));
}
@Test
public void hultajchochlaTest7() throws NieudanyPsikusException {
assertThat(gra.hultajchochla(-10), is(-1));
}
@Test
public void hultajchochlaTest8() throws NieudanyPsikusException {
assertThat(gra.hultajchochla(123),
either(is(132)).or(is(213)).or(is(321)));
}
@Test
public void hultajchochlaTest9() throws NieudanyPsikusException {
assertThat(gra.hultajchochla(256),
either(is(265)).or(is(652)).or(is(526)));
}
@Test
public void hultajchochlaTest10() throws NieudanyPsikusException {
assertThat(gra.hultajchochla(-123),
either(is(-132)).or(is(-213)).or(is(-321)));
}
@Test
public void hultajchochlaTest11() throws NieudanyPsikusException {
assertThat(gra.hultajchochla(-256),
either(is(-265)).or(is(-652)).or(is(-526)));
}
}
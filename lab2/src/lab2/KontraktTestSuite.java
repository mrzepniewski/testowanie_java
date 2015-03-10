package lab2;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  InterfejsTests.class,
  nieksztaltekTestWithParam.class,
  hultajchochlaTestsWithParam.class,
  cyfrokradTestsWithParam.class
})

public class KontraktTestSuite {
  // the class remains empty,
  // used only as a holder for the above annotations
}

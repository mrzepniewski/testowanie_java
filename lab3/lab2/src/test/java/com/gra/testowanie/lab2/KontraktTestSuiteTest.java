package com.gra.testowanie.lab2;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  InterfejsTestZ.class,
  nieksztaltekTestWithParamTestZ.class,
  hultajchochlaTestsWithParamTestZ.class,
  cyfrokradTestsWithParamTestZ.class
})

public class KontraktTestSuiteTest {
  // the class remains empty,
  // used only as a holder for the above annotations
}

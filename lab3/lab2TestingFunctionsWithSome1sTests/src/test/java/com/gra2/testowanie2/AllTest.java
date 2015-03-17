package com.gra2.testowanie2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
cyfrokradTests.class,
hultajchochlaTests.class,
nieksztaltekParametrizedTests.class,
nieksztaltekTests.class
})
public class AllTest { }
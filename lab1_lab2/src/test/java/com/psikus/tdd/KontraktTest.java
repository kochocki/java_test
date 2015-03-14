package com.psikus.tdd;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  Interfejs.class,
  nieksztaltekWithParam.class,
  hultajchochlaWithParam.class,
  cyfrokradWithParam.class
})

public class KontraktTest {
  // the class remains empty,
  // used only as a holder for the above annotations
}

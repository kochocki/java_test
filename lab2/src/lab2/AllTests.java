package lab2;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  cyfrokradTest.class,
  hultajchochlaTest.class,
  nieksztaltekParametrizedTest.class,
  nieksztaltekTest.class
})

public class AllTests { }
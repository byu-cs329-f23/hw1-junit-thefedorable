import org.junit.jupiter.api.*;
//import org.junit.platform.runner.JUnitPlatform;
//import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;


/**
 * Testing for the entire project
 *
 * @author Tanner Hartwell
 */
@DisplayName("Testing using JUnit 5")
public class WaitTimeTest {

  /**
   * constructor for class
   */
  public WaitTimeTest() {}

  private static final Logger log = LoggerFactory.getLogger(WaitTimeTest.class);

  @Test
  @DisplayName("A disabled test")
  void testNotRun() {
    log.info("disabled test so it shouldn't run");
  }
}

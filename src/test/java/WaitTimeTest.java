import attractions.Land;
import attractions.Park;
import attractions.Ride;
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
  private Land landTest;
  private Park parkTest;
  private Ride rideTest;

  /**
   * Starts up the tests
   */
  @BeforeAll
  public static void init() {
    log.info("@BeforeAll: init()");
  }

  /**
   * finishes the tests
   */
  @AfterAll
  public static void done() {
    log.info("@AfterAll: done()");
  }

  /**
   * performs function before each test function
   */
  @BeforeEach
  public void setUp() {
    log.info("@BeforeEach: setUp()");
  }

  /**
   * tears down each of the tests once done
   */
  @AfterEach
  public void tearDown() {
    log.info("@AfterEach: tearDown()");
    landTest = null;
    parkTest = null;
    rideTest = null;
  }

  /**
   * Tests the land class
   */
  @Nested
  @DisplayName("Test the land class")
  class LandTest {
    Ride[] rides;

    /**
     * gets the rides list setup for each test, so it can be inserted into the class
     */
    @BeforeEach
    public void setUp() {
      Ride ride1 = new Ride("ROTR",true,45);
      Ride ride2 = new Ride("Indiana Jones",true,25);
      Ride ride3 = new Ride("Pirates", true, 20);
      rides = new Ride[]{ride1, ride2, ride3};
    }
    /**
     * tests get name function
     */
    @Test
    @DisplayName("Testing getName")
    public void testGetName() {
      assertAll(
              () -> {
                landTest = new Land("Adventureland",rides);
                assertEquals("Adventureland", landTest.getName());
              },

              () -> {
                landTest = new Land("AdventureLand", rides);
                assertNotEquals("Adventureland",landTest.getName());
              }
      );
    }

    /**
     * Test function that takes average wait time
     */
    @Test
    @DisplayName("Testing average wait time function")
    public void testAvWaitTime() {

      landTest = new Land("diseny", rides);
      int expWaitTimeAv = 30;
      int waitTimeAv =landTest.avWaitTime();
      assertEquals(expWaitTimeAv,waitTimeAv);
    }
  }

  @Nested
  @DisplayName("Test the land class")
  class ParkTest {
    Land[] lands;
    Land land1;
    Land land2;

    /**
     * gets the lands list setup for each test, so it can be inserted into the class
     */
    @BeforeEach
    public void setUp() {
      Ride ride1 = new Ride("ROTR",true,45);
      Ride ride2 = new Ride("Indiana Jones",true,25);
      Ride ride3 = new Ride("Pirates", true, 20);
      Ride[] rides1 = {ride1, ride2, ride3};

      land1 = new Land("disney", rides1);

      Ride ride4 = new Ride("Jurassic Park",true,30);
      Ride ride5 = new Ride("Harry Potter",true,15);
      Ride ride6 = new Ride("Transformers", true, 15);
      Ride[] rides2 = {ride4, ride5, ride6};

      land2 = new Land("Universal", rides2);

      lands = new Land[]{land1, land2};
    }

    /**
     * testing the get land function
     */
    @Test
    @DisplayName("Testing getLands")
    public void testGetLands() {
      assertAll(
              () -> {
                parkTest = new Park(lands);
                assertNotNull(parkTest.getLands());
              },

              () -> {
                Land[] landList = null;
                parkTest = new Park(landList);
                assertNull(parkTest.getLands());
              }
      );
    }

    /**
     * Test function that takes average wait time
     */
    @Test
    @DisplayName("Testing average wait time function")
    public void testAvWaitTime() {
      parkTest = new Park(lands);
      int expAvWaitTime = 25;
      int avWaitTime = parkTest.getAverageWait();
      assertEquals(expAvWaitTime,avWaitTime);
    }
  }
}

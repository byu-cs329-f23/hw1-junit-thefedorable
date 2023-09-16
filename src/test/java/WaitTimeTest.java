import attractions.Land;
import attractions.Park;
import attractions.Ride;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


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
  @Tag("ClassTest")
  @DisplayName("Test the Land class")
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
      landTest = new Land("Adventureland",rides);
    }
    /**
     * tests get name function
     */
    @Test
    @Tag("ReturnAccuracy")
    @DisplayName("Testing getName")
    public void testGetName() {
      assertAll(
              () -> {
                assertEquals("Adventureland", landTest.getName());
              },

              () -> {
                assertNotEquals("AdventureLand",landTest.getName());
              }
      );
    }

    /**
     * Test function that takes average wait time
     */
    @DisplayName("Testing average wait time function")
    @Tag("Function")
    @ParameterizedTest(name = "{0} testing land average wait time")
    @CsvSource({"30"})

    void testAvWaitTime(int x){
      assertEquals(x, landTest.avWaitTime());
    }
  }

  @Nested
  @Tag("ClassTest")
  @DisplayName("Test the Park class")
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
     * testing the get lands function
     */
    @Test
    @Tag("ReturnAccuracy")
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
    @Tag("Function")
    @DisplayName("Testing average wait time function")
    public void testAvWaitTime() {
      parkTest = new Park(lands);
      int expAvWaitTime = 25;
      int avWaitTime = parkTest.getAverageWait();
      assertEquals(expAvWaitTime,avWaitTime);
    }
  }

  @Nested
  @Tag("ClassTest")
  @DisplayName("Test the Ride class")
  class RideTest {

    Ride ride0 = new Ride("ROTR",true,45);
    Ride ride1 = new Ride("Indiana Jones",true,25);
    Ride ride2 = new Ride("Pirates", true, 20);
    Ride[] rides = {ride0,ride1,ride2};

    /**
     * Test the getWaitTime function for accuracy.
     */
    @DisplayName("Test the GetWaitTime function")
    @Tag("ReturnAccuracy")
    @ParameterizedTest(name = "{0} testing ride{1}")
    @CsvSource({"45,0","25,1","20,2"})

    void testGetWaitTime(int x,int i){
      assertEquals(x, rides[i].getWait_time());
    }

    @DisplayName("Testing the getWaitTime function")
    @Tag("ReturnAccuracy")
    @TestFactory
    Stream<DynamicTest> TestGetWaitTime() {
      int[] x = { 45, 25, 20 };

      Stream<Integer> indices = Stream.iterate(0, i -> i + 1);
      Stream<DynamicTest> tests = indices
              .limit(3)
              .map(i -> {
                String displayName = MessageFormat.format(
                        "{0} testing ride{1}",
                        x[i], i);
                final int index = i;
                return DynamicTest.dynamicTest(displayName,
                        () -> {
                          Assertions.assertEquals(x[index], rides[index].getWait_time());
                        });
              });
      return tests;
    }

  }
}

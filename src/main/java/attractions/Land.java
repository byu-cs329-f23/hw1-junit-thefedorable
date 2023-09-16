package attractions;

/**
 * Object that represents the lands within a theme park.
 *
 * @author Tanner Hartwell
 */
public class Land {
  private final String name;
  private final Ride[] rides;

  /**
   * Constructor for class.
   *
   * @param name set name of land
   * @param rides set list of rides in land
   */
  public Land(String name, Ride[] rides) {
    this.name = name;
    this.rides = rides;
  }

  /**
   * Get the name of the land in the object.
   *
   * @return String of name
   */
  public String getName() {
    return name;
  }

  /**
   * Calculate the average wait time of a land.
   *
   * @return int representing average wait time
   */
  public int avWaitTime() {
    int add = 0;
    int rideNum = 0;

    for (Ride ride : rides) {
      if (ride.getWait_time() != 0) {
        add += ride.getWait_time();
        rideNum += 1;
      }
    }

    int average;

    if (rideNum != 0) {
      average = add / rideNum;
      return average;
    } else {
      return 0;
    }
  }

  @Override
  public String toString() {
    StringBuilder out = new StringBuilder();
    StringBuilder combined = new StringBuilder();
    String begin = "Name: " + name + "\n" + "Rides:" + "\n" + "\n";

    for (Ride ride : rides) {

      out.append(ride.toString()).append("\n").append("\n");
    }

    String end = out.toString();
    combined.append(begin).append(end);


    return combined.toString();
  }
}

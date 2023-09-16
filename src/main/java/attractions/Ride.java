package attractions;

/**
 * Object that represents a single ride within the theme park.
 *
 * @author Tanner Hartwell
 */
public class Ride {
  private final String name;
  private final boolean isOpen;
  private final int waitTime;

  /**
   * Constructor for ride object.
   *
   * @param name of ride
   * @param isOpen represents if the ride open
   * @param waitTime of the ride
   */

  public Ride(String name, boolean isOpen, int waitTime) {
    this.name = name;
    this.isOpen = isOpen;
    this.waitTime = waitTime;
  }

  /**
   * Get the wait time of the ride.
   *
   * @return int representing the wait time in min
   */
  public int getWait_time() {
    return waitTime;
  }

  @Override
  public String toString() {
    StringBuilder string = new StringBuilder();
    string.append("Name: ").append(name);
    string.append('\n');

    if (isOpen) {
      string.append("Status: ").append("Open");
      string.append("\n");
      string.append("Wait: ").append(waitTime);
    } else  {
      string.append("Status: ").append("Closed");
    }


    return string.toString();
  }
}

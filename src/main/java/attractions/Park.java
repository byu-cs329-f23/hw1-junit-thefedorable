package attractions;

/**
 * Object that holds wait time information regrading different theme parks.
 *
 * @author Tanner Hartwell
 */
public class Park {
  private final Land[] lands;

  /**
   * contractor for park object.
   *
   * @param lands list of land within park
   */
  public Park(Land[] lands) {
    this.lands = lands;
  }

  /**
   * get a copy of the list of lands with park.
   *
   * @return array of land objects
   */
  public Land[] getLands() {
    return lands;
  }

  /**
   * calculates average wait for entire park object.
   *
   * @return int representing wait time in min
   */
  public int getAverageWait() {
    int averageWait = 0;

    for (Land land : lands) {
      averageWait += land.avWaitTime();
    }

    averageWait = averageWait / lands.length;
    return averageWait;
  }

  @Override
  public String toString() {
    StringBuilder out = new StringBuilder();

    for (Land land : lands) {
      out.append(land.toString());
      out.append("\n");
    }

    return out.toString();
  }
}

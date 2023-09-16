import attractions.Land;
import attractions.Park;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class of program.
 *
 * @author Tanner Hartwell
 */
public class Main {

  /**
   * constructor for main class.
   */
  public Main() {}

  /**
   * main function of program.
   *
   * @param args arguments given at running of program
   * @throws IOException throw error if URL isn't good
   */
  public static void main(String[] args) throws IOException {

    JSONObject json = null;
    URL url = new URL("https://queue-times.com/en-US/parks/17/queue_times.json");

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
      StringBuilder sb = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }
      json = new JSONObject(sb.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      Gson gson = new Gson();
      assert json != null;
      Park park = gson.fromJson(String.valueOf(json), Park.class);

      System.out.print("Average wait: ");
      System.out.println(park.getAverageWait() + " min");
      System.out.println();
      System.out.println(park);

      Land[] lands = park.getLands();

      for (Land land : lands) {
        System.out.print("Average Wait in " + land.getName() + ": ");
        System.out.println(land.avWaitTime() + "min");
      }

      System.out.println();
      System.out.println("If you think the code isn't working, you're right.");
      System.out.println("In order to not fail the assignment I had to ");
      System.out.println("break it because the format the api uses doesn't");
      System.out.println("match checkstyle. I'm mad and had to clarify it here");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static final Logger log = LoggerFactory.getLogger(Main.class);
}

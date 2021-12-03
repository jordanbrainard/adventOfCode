import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

import main.december.day2.PositionFinder;
import main.domain.Movement;

public class App {
    static PositionFinder pf = new PositionFinder();
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws Exception {
        String line = "";
        List<Movement> movements = new ArrayList();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src\\main\\resources\\movements.txt"));

            while ((line = br.readLine()) != null) {
                String[] splits = line.split(" ");
                String dir = splits[0];
                int dis = Integer.parseInt(splits[1]);
                movements.add(new Movement(dir, dis));
            }
        } catch (Exception e) {
            LOGGER.info("error parsing list");
        } finally {
            LOGGER.log(Level.INFO, pf.findEndpointProduct(movements).toString());
            if (br != null) {
                br.close();
            }
        }

    }
}

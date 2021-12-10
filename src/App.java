import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

import main.december.day3.PowerConsumptionCalculator;

public class App {
    static PowerConsumptionCalculator pcc = new PowerConsumptionCalculator();
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws Exception {
        String line = "";
        List<String> readings = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src\\main\\resources\\binary.txt"));

            
            while ((line = br.readLine()) != null) {
                readings.add(line);
            }

        } catch (Exception e) {
            LOGGER.info("error parsing list");
        } finally {
            LOGGER.log(Level.INFO, pcc.calculatePowerConsumption(readings).toString());
            if (br != null) {
                br.close();
            }
        }

    }
}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

import main.december.day1.DepthFinder;
public class App {
    static DepthFinder df = new DepthFinder();
    static File f = new File("resources/depths.txt");
    static String[] fileDepths = f.list();
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    public static void main(String[] args) throws Exception {
        String line = "";
        List<Integer> readInDepths= new ArrayList();
        BufferedReader br = null;
        try {
        br = new BufferedReader(new FileReader("src\\main\\resources\\depths.txt"));

        while ((line = br.readLine()) != null) {  
            readInDepths.add(Integer.parseInt(line));
        }
    }catch(Exception e){
        LOGGER.info("error parsing list");
    }
    finally{
        LOGGER.log(Level.INFO, df.seaFloorChange(readInDepths).toString());
        if(br != null){
            br.close();
        }
    }

    }
}

package main.december.day3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LifeSupportRating {

    private static final Logger LOGGER = Logger.getLogger(LifeSupportRating.class.getName());

    public Integer calculateLifeSupportRating(List<String> readings) {
        List<String> dupReadings = new ArrayList<>();
        dupReadings.addAll(readings);
        System.out.println(dupReadings.get(0));

        String binaryOxygenRating = calculateOxygenRating(readings);
        String binaryCO2Rating = calculateCO2Rating(dupReadings);

        LOGGER.log(Level.INFO, "binary oxygen rating: " + binaryOxygenRating);
        LOGGER.log(Level.INFO, "binary CO2 rating: " + binaryCO2Rating);

        return Integer.parseInt(binaryOxygenRating, 2) * Integer.parseInt(binaryCO2Rating, 2);
    }

    public String calculateOxygenRating(List<String> readings) {
    
        for(int y = 0; y < readings.get(0).length(); y++){
            if(readings.size() == 1) {return readings.get(0);}

            int digitSum = 0;
            for(String reading: readings){
                digitSum+= Integer.parseInt(String.valueOf(reading.charAt(y)));
            }

            double quotient = (double)digitSum/readings.size();
            if(quotient >= 0.5){
                for (Iterator<String> iterator = readings.iterator(); iterator.hasNext();) {
                    String reading = iterator.next();
                    if(reading.charAt(y) == '0') {
                        iterator.remove();
                    }
                }
            }else {
                for (Iterator<String> iterator = readings.iterator(); iterator.hasNext();) {
                    String reading = iterator.next();
                    if(reading.charAt(y) == '1') {
                        iterator.remove();
                    }
                }
            }

        }

        return readings.get(0);
    }

    public String calculateCO2Rating(List<String> readings) {
    
        for(int y = 0; y < readings.get(0).length(); y++){
            if(readings.size() == 1) {return readings.get(0);}
            int digitSum = 0;
            for(String reading: readings){
                digitSum+= Integer.parseInt(String.valueOf(reading.charAt(y)));
            }

            double quotient = (double)digitSum/readings.size();
            System.out.println(quotient + " " + y);
            if(quotient >= 0.5){
                for (Iterator<String> iterator = readings.iterator(); iterator.hasNext();) {
                    String reading = iterator.next();
                    if(reading.charAt(y) == '1') {
                        iterator.remove();
                    }
                }
            }else {
                for (Iterator<String> iterator = readings.iterator(); iterator.hasNext();) {
                    String reading = iterator.next();
                    if(reading.charAt(y) == '0') {
                        iterator.remove();
                    }
                }
            }
        }
        return readings.get(0);
    }

}

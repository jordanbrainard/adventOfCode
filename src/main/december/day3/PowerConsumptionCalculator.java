package main.december.day3;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PowerConsumptionCalculator {
    private static final Logger LOGGER = Logger.getLogger(PowerConsumptionCalculator.class.getName());

    public Integer calculatePowerConsumption(List<String> readings) throws IOException {
        String binaryGamma = calculateGammaValue(readings);
        String binaryEpsilon = calculateEpsilonValue(binaryGamma);

        LOGGER.log(Level.INFO, "binary gamma: " + binaryGamma);
        LOGGER.log(Level.INFO, "binary epsilon: " + binaryEpsilon);

        Integer decimalGamma = getValueFromBinary(binaryGamma);
        Integer decimalEpsilon = getValueFromBinary(binaryEpsilon);

        return decimalGamma*decimalEpsilon;
    }

    public String calculateGammaValue(List<String> readings) {
        int oneCount = 0;
        int zeroCount = 0;
        char charToAppend;

        StringBuilder gammaVal = new StringBuilder();

        for(int y = 0; y < readings.get(0).length(); y++){
            for(String reading: readings){
                if(reading.charAt(y) == '1'){
                    oneCount++;
                }else{
                    zeroCount++;
                }
            }

            charToAppend = zeroCount > oneCount ? '0' : '1';
            gammaVal.append(charToAppend);
            oneCount = 0;
            zeroCount = 0;
        }

        return gammaVal.toString();
    }

    public String calculateEpsilonValue(String gamma) throws IOException {
        StringBuilder epsilon = new StringBuilder();
        StringReader reader = new StringReader(gamma);

        for(int i = 0; i < gamma.length(); i++){
            if(reader.read() == '1'){
                epsilon.append('0');
            }else{
                epsilon.append('1');
            }
        }
        
        return epsilon.toString();
    }

    public Integer getValueFromBinary(String binary){
        return Integer.parseInt(binary, 2);
    }
}
